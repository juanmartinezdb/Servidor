package org.iesbelen.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.iesbelen.modelo.Jugador;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PartidoDTO {

    private int idPartido;
    private LocalDate fechaPartido;
    private String equipoLocal;
    private String equipoVisitante;
    private String jugadorDestacado;

    private List<Jugador> jugadores;
    private int totalGoles;

}
