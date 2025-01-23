package org.iesbelen.dao;

import lombok.extern.slf4j.Slf4j;
import org.iesbelen.modelo.Pedido;
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
    public Optional<List<Pedido>> find(int id_comercial) {

        List<Pedido> pedComercial = jdbcTemplate.query(
                "select * from pedidos where id_comercial = ?",
                (rs, rowNum) -> new Pedido(
                        rs.getInt("id"),
                        rs.getInt("total"),
                        rs.getDate("fecha"),
                        rs.getInt("id_cliente"),
                        rs.getInt("id_comercial")
                )
        );
        log.info("Pedidos por Comercial: {}", pedComercial.size());
        if (pedComercial.isEmpty()) {
            return Optional.empty();
        } else {
            return Optional.of(pedComercial);
        }
    }
}
