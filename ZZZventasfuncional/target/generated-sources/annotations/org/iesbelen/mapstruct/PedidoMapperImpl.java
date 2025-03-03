package org.iesbelen.mapstruct;

import javax.annotation.processing.Generated;
import org.iesbelen.dto.PedidoDTO;
import org.iesbelen.modelo.Pedido;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-06T12:22:51+0100",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.4 (Oracle Corporation)"
)
@Component
public class PedidoMapperImpl implements PedidoMapper {

    @Override
    public PedidoDTO pedidoToPedidoDTO(Pedido pedido, String nombreClienteIn) {
        if ( pedido == null && nombreClienteIn == null ) {
            return null;
        }

        PedidoDTO pedidoDTO = new PedidoDTO();

        if ( pedido != null ) {
            pedidoDTO.setId( pedido.getId() );
            pedidoDTO.setTotal( pedido.getTotal() );
            pedidoDTO.setFecha( pedido.getFecha() );
            pedidoDTO.setIdCliente( pedido.getIdCliente() );
            pedidoDTO.setIdComercial( pedido.getIdComercial() );
        }
        pedidoDTO.setNombreCliente( nombreClienteIn );

        return pedidoDTO;
    }

    @Override
    public Pedido pedidoDTOToPedido(PedidoDTO pedido) {
        if ( pedido == null ) {
            return null;
        }

        Pedido pedido1 = new Pedido();

        pedido1.setId( pedido.getId() );
        pedido1.setTotal( pedido.getTotal() );
        pedido1.setFecha( pedido.getFecha() );
        pedido1.setIdCliente( pedido.getIdCliente() );
        pedido1.setIdComercial( pedido.getIdComercial() );

        return pedido1;
    }
}
