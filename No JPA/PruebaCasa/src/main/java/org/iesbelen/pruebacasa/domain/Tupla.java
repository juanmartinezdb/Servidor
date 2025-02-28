package org.iesbelen.pruebacasa.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = "id")
public class Tupla {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int ammount;

    @ManyToOne()
    @JoinColumn(name = "id_order", nullable = false)
    private Order order;

    @ManyToOne()
    @JoinColumn(name = "id_product")
    private Product product;


}
