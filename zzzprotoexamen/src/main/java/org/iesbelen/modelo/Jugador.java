package org.iesbelen.modelo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Jugador {

    private int id;

    @NotBlank(message = "Por favor, el campo no puede estar vacio.")
    @Size(max = 50)
    private String nombre;

    @NotBlank(message = "Por favor, el campo no puede estar vacio.")
    @Pattern(regexp = "^(Portero|Defensa|Centrocampista|Delantero)$")
    private String posicion;

    @NotNull(message = "no puede ser nulo")
    //Personalizado Años de 2000 a 2028
    private LocalDate fechaFichaje;

    @NotBlank(message = "Por favor, el campo no puede estar vacio.")
    //Personalizada debe equistir en la tabla equipos
    private String equipo;

}
