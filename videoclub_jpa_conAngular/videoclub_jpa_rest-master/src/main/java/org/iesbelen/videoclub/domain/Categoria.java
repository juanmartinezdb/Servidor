package org.iesbelen.videoclub.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.NaturalId;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "categoria")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode( of = "nombre")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private long idCategoria;

    @NaturalId
    private String nombre;

    @ManyToMany(
            mappedBy = "categorias")
    @ToString.Exclude
//    @JsonIgnore
    Set<Pelicula> peliculas = new HashSet<>();



}