package org.iesbelen.dao;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;


import org.iesbelen.modelo.Comercial;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

//Anotación lombok para logging (traza) de la aplicación
@Slf4j
@Repository
//Utilizo lombok para generar el constructor
@AllArgsConstructor
public class ComercialDAOImpl implements ComercialDAO {

	//JdbcTemplate se inyecta por el constructor de la clase automáticamente
	//
	//@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public synchronized void create(Comercial comercial) {
		// TODO Auto-generated method stub

		String sqlInsert = """
				INSERT INTO comercial (nombre, apellido1, apellido2, comisión, email)
				VALUES (		?, 		?, 			?, 			?, ?)
				""";
		KeyHolder keyHolder = new GeneratedKeyHolder();

		int rows = jdbcTemplate.update(connection -> {
		PreparedStatement ps = connection.prepareStatement(sqlInsert, new String[] { "id" });
		int idx = 1;
		ps.setString(idx++, comercial.getNombre());
		ps.setString(idx++, comercial.getApellido1());
		ps.setString(idx++, comercial.getApellido2());
		ps.setBigDecimal(idx++,  comercial.getComision());
		ps.setString(idx++, comercial.getEmail());
		return ps;
	}, keyHolder);

		 comercial.setId(keyHolder.getKey().intValue());

		log.info("Insertados {} registros.", rows);
	}

	@Override
	public List<Comercial> getAll() {
		
		List<Comercial> listComercial = jdbcTemplate.query(
                "SELECT * FROM comercial",
                (rs, rowNum) -> new Comercial(rs.getInt("id"), 
                							  rs.getString("nombre"), 
                							  rs.getString("apellido1"),
                							  rs.getString("apellido2"), 
                							  rs.getBigDecimal("comisión"),
												rs.getString("email")
				)
                						 	
        );
		
		log.info("Devueltos {} registros.", listComercial.size());
		
        return listComercial;
	}

	@Override
	public Optional<Comercial> find(int id) {
		// TODO Auto-generated method stub

		Comercial come = jdbcTemplate
				.queryForObject("SELECT * FROM comercial WHERE id = ?"
				, (rs, rowNum) -> new Comercial(rs.getInt("id"),
								rs.getString("nombre"),
								rs.getString("apellido1"),
								rs.getString("apellido2"),
								rs.getBigDecimal("comisión"),
								rs.getString("email")),
						id
		);
		if (come != null) {
			log.info("Comercial no encontrado.");
			return Optional.of(come);
		} else {
			return Optional.empty();
		}
	}

	@Override
	public void update(Comercial comercial) {
		// TODO Auto-generated method stub
		int rows = jdbcTemplate.update("""
					UPDATE comercial SET
					                    nombre = ?,
					                    apellido1 = ?,
					                    apellido2 = ?,
					                    comisión = ?,
                    					email = ?
						WHERE id = ?
					""", comercial.getNombre()
				, comercial.getApellido1()
				, comercial.getApellido2()
				, comercial.getComision()
				, comercial.getEmail()
				, comercial.getId());
				log.info("Actualizado {}", rows);
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
	int rows = jdbcTemplate.update("DELETE FROM comercial WHERE id = ?", id);
		log.info("Eliminado {}", rows);
	}
}
