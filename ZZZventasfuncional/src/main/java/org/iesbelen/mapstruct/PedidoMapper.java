package org.iesbelen.mapstruct;

import org.iesbelen.dto.PedidoDTO;
import org.iesbelen.modelo.Pedido;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PedidoMapper {

    @Mapping(target = "nombreCliente", source = "nombreClienteIn")
    PedidoDTO pedidoToPedidoDTO(Pedido pedido, String nombreClienteIn);

    Pedido pedidoDTOToPedido(PedidoDTO pedido);
}
