package org.iesbelen.dao;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

import org.iesbelen.modelo.Partido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;


@Slf4j

@Repository
public class PartidoDAOImpl implements PartidoDAO {


    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * Inserta en base de datos el nuevo Partido, actualizando el id en el bean Partido.
     */
    @Override
    public synchronized void create(Partido partido) {


        String sqlInsert = """
							INSERT INTO partidos (fecha_partido, equipo_local, equipo_visitante, jugador_destacado) 
							VALUES  (     ?,         ?,         ?,     ?)
						   """;

        KeyHolder keyHolder = new GeneratedKeyHolder();
        //Con recuperación de id generado
        int rows = jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sqlInsert, new String[] { "id" });
            int idx = 1;
            ps.setObject(idx++, partido.getFechaPartido());
            ps.setString(idx++, partido.getEquipoLocal());
            ps.setString(idx++, partido.getEquipoVisitante());
            ps.setString(idx++, partido.getJugadorDestacado());
            return ps;
        },keyHolder);

        partido.setIdPartido(keyHolder.getKey().intValue());


        log.info("Insertados {} registros.", rows);
    }

    /**
     * Devuelve lista con todos loa Partidos.
     */
    @Override
    public List<Partido> getAll() {

        List<Partido> partidos = jdbcTemplate.query(
                "SELECT fecha_partido, equipo_local, equipo_visitante, jugador_destacado FROM partidos",
                (rs, rowNum) ->  Partido.builder()
                        .fechaPartido(rs.getDate(1).toLocalDate())
                        .equipoLocal(rs.getString(2))
                        .equipoVisitante(rs.getString(3))
                        .jugadorDestacado(rs.getString(4))
                        .build());


        log.info("Devueltos {} registros.", partidos.size());

        return partidos;
    }

    /**
     * Devuelve Optional de Partido con el ID dado.
     */
    @Override
    public Optional<Partido> find(int id) {

        Partido partido =  jdbcTemplate
                .queryForObject("SELECT fecha_partido, equipo_local, equipo_visitante, jugador_destacado FROM partidos WHERE id = ?"
                        , (rs, rowNum) ->  Partido.builder()
                                .fechaPartido(rs.getDate(1).toLocalDate())
                                .equipoLocal(rs.getString(2))
                                .equipoVisitante(rs.getString(3))
                                .jugadorDestacado(rs.getString(4))
                                .build(), id);

        if (partido != null) {
            return Optional.of(partido);}
        else {
            log.info("Partido no encontrado.");
            return Optional.empty(); }

    }
    /**
     * Actualiza Partido con campos del bean Partido según ID del mismo.
     */
    @Override
    public void update(Partido partido) {

        int rows = jdbcTemplate.update("""
										UPDATE partidos SET 
														fecha_partido = ?, 
														equipo_local = ?, 
														equipo_visitante = ?,
														jugador_destacado = ?,
												WHERE id = ?
										""", partido.getFechaPartido()
                , partido.getEquipoLocal()
                , partido.getEquipoVisitante()
                , partido.getJugadorDestacado()
                , partido.getIdPartido());

        log.info("Update de Partido con {} registros actualizados.", rows);
    }

    /**
     * Borra Partido con ID proporcionado.
     */
    @Override
    public void delete(long id) {

        int rows = jdbcTemplate.update("DELETE FROM partidos WHERE id = ?", id);

        log.info("Delete de Partido con {} registros eliminados.", rows);
    }
}
