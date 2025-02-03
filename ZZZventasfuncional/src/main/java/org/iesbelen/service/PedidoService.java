package org.iesbelen.service;

import org.iesbelen.dao.ClienteDAO;
import org.iesbelen.dao.ComercialDAO;
import org.iesbelen.dao.PedidoDAO;
import org.iesbelen.dto.PedidoDTO;
import org.iesbelen.mapstruct.PedidoMapper;
import org.iesbelen.modelo.Cliente;
import org.iesbelen.modelo.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class PedidoService {

    @Autowired
    private PedidoDAO pedidoDAO;

    @Autowired
    private ClienteDAO clienteDAO;

    @Autowired
    private PedidoMapper pedidoMapper;

    public List<PedidoDTO> listarPedidosDTO(int idComercial) {

    List<Cliente> clientes = clienteDAO.getAll();
    List<Pedido> pedidos = pedidoDAO.findByComercial(idComercial);

        Map<Long, String> clienteNombreMap = clientes.stream()
                .collect(Collectors.toMap(Cliente::getId, Cliente::getNombre));

        return pedidos.stream()
                .map(p-> pedidoMapper.pedidoToPedidoDTO(p, clienteNombreMap.getOrDefault(p.getIdCliente(), "fulanito")))
                .collect(Collectors.toList());
    }

    public  Integer pedidosTotales(){
        Integer total =  pedidoDAO.totalPedidos();
        return total;
    }

    public BigDecimal porcentajePedidos(int total, int parcial) {
        return BigDecimal.valueOf((parcial/total)*100);
    }

}

