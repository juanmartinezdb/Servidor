package org.iesbelen.videoclub.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="pelicula")
@Data
@AllArgsConstructor
@NoArgsConstructor

@ToString
@EqualsAndHashCode( of = "idPelicula")
public class Pelicula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_pelicula")
    private long idPelicula;

    private String titulo;

    private String descripcion;

    @Column(name = "anyo_lanzamiento")
    @JsonFormat(pattern = "yyyy",  shape = JsonFormat.Shape.STRING)
    private Date anyoLanzamiento;

    @ManyToOne()
    @JoinColumn(name = "id_idioma", nullable = false)
    private Idioma idioma;

    private int duracion;

    @ManyToMany (fetch = FetchType.EAGER)
    @JoinTable(
            name = "pelicula_categoria",
            joinColumns = @JoinColumn(name = "id_pelicula", referencedColumnName = "id_pelicula"),
            inverseJoinColumns = @JoinColumn(name = "id_categoria", referencedColumnName = "id_categoria"))
    @JsonIgnore
    Set<Categoria> categorias = new HashSet<>();

}
