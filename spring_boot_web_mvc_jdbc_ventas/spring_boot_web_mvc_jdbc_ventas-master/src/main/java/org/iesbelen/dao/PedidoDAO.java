package org.iesbelen.dao;

import org.iesbelen.modelo.Cliente;
import org.iesbelen.modelo.Pedido;
import org.iesbelen.modelo.PedidoDTO;

import java.util.List;
import java.util.Optional;


public interface PedidoDAO {

    public Integer totalPedidos();
    public List<Pedido> getAll();
    public Optional<List<PedidoDTO>> findByComercial(int id_comercial);
}
