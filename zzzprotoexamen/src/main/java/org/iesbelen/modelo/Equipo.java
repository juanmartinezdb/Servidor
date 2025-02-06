package org.iesbelen.modelo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Equipo {

    @NotBlank(message = "Por favor, el campo no puede estar vacio.")
    private String nombreEquipo;

    @Size(max = 50, message = "maximo 50")
    private String ciudad;

    @NotNull(message = "no puede ser nulo")
    //@RangoCreacion Personalizada entre 1900 y Hoy
    private LocalDate fechaCreacion;

    @NotBlank(message = "Por favor, el campo no puede estar vacio.")
    // Puede que no funcione si no se hace validacion y ya @Pattern(regexp = "^(La liga|Premier League|Serie A|Bundesliga|Ligue 1|Eredivisie|Primeira Liga)$")
    private String liga;

    @NotBlank(message = "Por favor, el campo no puede estar vacio.")
    @Size(max = 100, message = "maximo 100")
    private String estadio;
}
