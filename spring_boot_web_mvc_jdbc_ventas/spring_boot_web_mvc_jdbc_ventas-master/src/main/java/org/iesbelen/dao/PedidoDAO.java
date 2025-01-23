package org.iesbelen.dao;

import org.iesbelen.modelo.Cliente;
import org.iesbelen.modelo.Pedido;

import java.util.List;
import java.util.Optional;


public interface PedidoDAO {

    public List<Pedido> getAll();
    public Optional<List<Pedido>> find(int id_comercial);
}
