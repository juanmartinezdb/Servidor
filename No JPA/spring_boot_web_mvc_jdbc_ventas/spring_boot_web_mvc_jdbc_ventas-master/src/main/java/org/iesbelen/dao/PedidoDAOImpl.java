package org.iesbelen.dao;

import lombok.extern.slf4j.Slf4j;
import org.iesbelen.modelo.Pedido;
import org.iesbelen.modelo.PedidoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Slf4j
@Repository

public class PedidoDAOImpl implements PedidoDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public Integer totalPedidos() {
        Integer totalPedidos = jdbcTemplate.queryForObject("select count(*) from pedido", Integer.class);
        return totalPedidos;
    }

    @Override
    public List<Pedido> getAll() {

        List<Pedido> listaPedidos = jdbcTemplate.query(
                "select * from pedido",
                (rs, rowNum) -> new Pedido(
                        rs.getInt("id"),
                        rs.getInt("total"),
                        rs.getDate("fecha"),
                        rs.getInt("id_cliente"),
                        rs.getInt("id_comercial")
                        )
        );
        log.info("Pedidos: {}", listaPedidos.size());

        return listaPedidos;
    }

    @Override
    public Optional<List<PedidoDTO>> findByComercial(int idComercial) {

        List<PedidoDTO> pedComercial = jdbcTemplate.query(
                "SELECT p.id, p.total, p.fecha, p.id_cliente, p.id_comercial, c.nombre AS cliente_nombre " +
                        "FROM pedido p " +
                        "JOIN cliente c ON p.id_cliente = c.id " +
                        "WHERE p.id_comercial = ?",
                (ps) -> ps.setInt(1, idComercial),
                (rs, rowNum) -> new PedidoDTO( //
                        rs.getInt("id"),
                        rs.getDouble("total"),
                        rs.getDate("fecha"),
                        rs.getLong("id_cliente"),
                        rs.getInt("id_comercial"),
                        rs.getString("cliente_nombre")
                )
        );
        log.info("Pedidos por Comercial con DTO: {}", pedComercial.size());

        if (pedComercial.isEmpty()) {
            return Optional.empty();
        } else {
            return Optional.of(pedComercial);
        }
    }

}
