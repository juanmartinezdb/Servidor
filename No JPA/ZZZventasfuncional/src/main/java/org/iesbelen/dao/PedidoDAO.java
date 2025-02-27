package org.iesbelen.dao;

import org.iesbelen.modelo.Pedido;
import org.iesbelen.dto.PedidoDTO;

import java.util.List;
import java.util.Optional;


public interface PedidoDAO {

    public Integer totalPedidos();
    public List<Pedido> getAll();
    public Optional<List<PedidoDTO>> findByComercialDTO(int id_comercial);
    public List<Pedido> findByComercial(int id_comercial);
}
