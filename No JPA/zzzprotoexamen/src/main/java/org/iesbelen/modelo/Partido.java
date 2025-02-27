package org.iesbelen.modelo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Partido {
    private int idPartido;

    @NotBlank(message = "Por favor, el campo no puede estar vacio.")
    //@rango de años entre el 2000 y 2030
    private LocalDate fechaPartido;

    @NotBlank(message = "Por favor, el campo no puede estar vacio.")
    //debe existir en equipos
    private String equipoLocal;

    @NotBlank(message = "Por favor, el campo no puede estar vacio.")
    //debe existir en equipos
    //no puede ser igual que equipolocal.
    private String equipoVisitante;

    @NotNull(message = "no puede ser nulo")
    //debe pertecer al equipo local
    private String jugadorDestacado;
}
