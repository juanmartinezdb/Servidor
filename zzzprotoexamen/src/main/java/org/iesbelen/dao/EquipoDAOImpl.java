package org.iesbelen.dao;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

import org.iesbelen.modelo.Equipo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Repository
public class EquipoDAOImpl implements EquipoDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public synchronized void create(Equipo equipo) {


        String sqlInsert = """
							INSERT INTO equipos (nombre_equipo, ciudad, fecha_creacion, liga, estadio) 
							VALUES  (     ?,         ?,         ?,       ?,         ? 		)
						   """;


        int rows = jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sqlInsert, new String[] { "id" });
            int idx = 1;
            ps.setString(idx++, equipo.getNombreEquipo());
            ps.setString(idx++, equipo.getCiudad());
            ps.setObject(idx++, equipo.getFechaCreacion());
            ps.setString(idx++, equipo.getLiga());
            ps.setString(idx++, equipo.getEstadio());
            return ps;
        });

        log.info("Insertados {} registros.", rows);
    }

    @Override
    public List<Equipo> getAll() {

        List<Equipo> listFab = jdbcTemplate.query(
                "SELECT nombre_equipo, ciudad, fecha_creacion, liga, estadio FROM equipos",
                (rs, rowNum) -> new Equipo(rs.getString("nombre_equipo"),
                        rs.getString("ciudad"),
                        rs.getDate("fecha_creacion").toLocalDate(),
                        rs.getString("liga"),
                        rs.getString("estadio")
                )
        );

        log.info("Devueltos {} registros.", listFab.size());

        return listFab;
    }

    /**
     * Devuelve Optional de Equipo con el ID dado.
     */
    @Override
    public Optional<Equipo> find(String  nombre) {

        Equipo equipo =  jdbcTemplate
                .queryForObject("SELECT nombre_equipo, ciudad, fecha_creacion, liga, estadio FROM equipos WHERE nombre_equipo = ?"
                        , (rs, rowNum) -> new Equipo(rs.getString("nombre_equipo"),
                                rs.getString("ciudad"),
                                rs.getDate("fecha_creacion").toLocalDate(),
                                rs.getString("liga"),
                                rs.getString("estadio"))
                        , nombre
                );

        if (equipo != null) {
            return Optional.of(equipo);}
        else {
            log.info("Equipo no encontrado.");
            return Optional.empty(); }

    }

    @Override
    public void update(Equipo equipo) {

        int rows = jdbcTemplate.update("""
										UPDATE equipos SET 
														nombre_equipo = ?, 
														ciudad = ?, 
														fecha_creacion = ?,
														liga = ?,
														estadio = ?,
												WHERE nombre_equipo = ?
										""", equipo.getNombreEquipo()
                , equipo.getCiudad()
                , equipo.getFechaCreacion()
                , equipo.getLiga()
                , equipo.getEstadio()
                , equipo.getNombreEquipo());

        log.info("Update de Equipo con {} registros actualizados.", rows);
    }

    /**
     * Borra Equipo con ID proporcionado.
     */
    @Override
    public void delete(String nombre) {

        int rows = jdbcTemplate.update("DELETE FROM equipos WHERE nombre_equipo = ?", nombre);

        log.info("Delete de Equipo con {} registros eliminados.", rows);
    }
}
