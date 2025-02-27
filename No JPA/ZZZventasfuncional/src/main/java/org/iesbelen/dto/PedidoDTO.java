package org.iesbelen.dto;


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
    private long idCliente;
    private int idComercial;
    private String nombreCliente;

    // Getters y Setters explícitos
    public String getNombreCliente() {
        return nombreCliente;
    }
    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }
}
