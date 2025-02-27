package org.iesbelen.modelo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDTO {

    private int id;
    private double total;
    private Date fecha;
    private long id_cliente;
    private int id_comercial;

    private String nombre_cliente;
}
