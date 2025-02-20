package org.iesbelen.videoclub.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Tarjeta {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private Date caducidad;

    @OneToOne(mappedBy = "tarjeta") //el que pone mappedBy es el que no pilla el campo
    //es decir, que no lo guarda en la base datos lo trae como un TarjetaDTO
    //el mappedBy es el nombre del atributo en la otra entidad.
    private  Socio socio;

}
