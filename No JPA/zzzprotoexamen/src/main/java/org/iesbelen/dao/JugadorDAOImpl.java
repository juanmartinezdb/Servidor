package org.iesbelen.dao;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

import org.iesbelen.modelo.Jugador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Repository
public class JugadorDAOImpl implements JugadorDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * Inserta en base de datos el nuevo Jugador, actualizando el id en el bean Jugador.
     */
    @Override
    public synchronized void create(Jugador jugador) {

        String sqlInsert = """
							INSERT INTO jugadores (nombre, posicion, fecha_fichaje, equipo) 
							VALUES  (     ?,         ?,         ?,       ?)
						   """;

        KeyHolder keyHolder = new GeneratedKeyHolder();
        //Con recuperación de id generado
        int rows = jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sqlInsert, new String[] { "id" });
            int idx = 1;
            ps.setString(idx++, jugador.getNombre());
            ps.setString(idx++, jugador.getPosicion());
            ps.setObject(idx++, jugador.getFechaFichaje());
            ps.setString(idx++, jugador.getEquipo());
            return ps;
        },keyHolder);

        jugador.setId(keyHolder.getKey().intValue());


        log.info("Insertados {} registros.", rows);
    }

    /**
     * Devuelve lista con todos loa Jugadors.
     */
    @Override
    public List<Jugador> getAll() {

        List<Jugador> jugadores = jdbcTemplate.query(
                "SELECT id, nombre, posicion, fecha_fichaje, equipo FROM jugadores",
                (rs, rowNum) ->  Jugador.builder()
                        .id(rs.getInt("id"))
                        .nombre(rs.getString("nombre"))
                        .posicion(rs.getString("posicion"))
                        .fechaFichaje(rs.getDate("fecha_fichaje").toLocalDate())
                        .equipo(rs.getString("equipo"))
                        .build());


        log.info("Devueltos {} registros.", jugadores.size());

        return jugadores;
    }

    /**
     * Devuelve Optional de Jugador con el ID dado.
     */
    @Override
    public Optional<Jugador> find(int id) {

        Jugador jugador =  jdbcTemplate
                .queryForObject("SELECT id, nombre, posicion, fecha_fichaje, equipo  FROM jugadores WHERE id = ?"
                        , (rs, rowNum) -> Jugador.builder()
                                .id(rs.getInt("id"))
                                .nombre(rs.getString("nombre"))
                                .posicion(rs.getString("posicion"))
                                .fechaFichaje(rs.getDate("fecha_fichaje").toLocalDate())
                                .equipo(rs.getString("equipo"))
                                .build(), id);

        if (jugador != null) {
            return Optional.of(jugador);}
        else {
            log.info("Jugador no encontrado.");
            return Optional.empty(); }

    }
    /**
     * Actualiza Jugador con campos del bean Jugador según ID del mismo.
     */
    @Override
    public void update(Jugador jugador) {

        int rows = jdbcTemplate.update("""
										UPDATE jugadores SET 
														nombre = ?, 
														posicion = ?, 
														fecha_fichaje = ?,
														equipo = ?
												WHERE id = ?
										""", jugador.getNombre()
                , jugador.getPosicion()
                , jugador.getFechaFichaje()
                , jugador.getEquipo()
                , jugador.getId());

        log.info("Update de Jugador con {} registros actualizados.", rows);
    }

    /**
     * Borra Jugador con ID proporcionado.
     */
    @Override
    public void delete(int id) {

        int rows = jdbcTemplate.update("DELETE FROM jugadores WHERE id = ?", id);

        log.info("Delete de Jugador con {} registros eliminados.", rows);
    }
}
