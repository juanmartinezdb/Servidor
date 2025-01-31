package org.iesbelen.modelo;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comercial {

	private int id;

	@NotBlank(message = "Por favor, introduzca nombre.")
	@Size(max=30, message = "Nombre como máximo de 30 caracteres.")
	private String nombre;

	@NotBlank(message = "Por favor, introduzca un apellido.")
	@Size(max=30, message = "Apellido como máximo de 30 caracteres.")
	private String apellido1;
	private String apellido2;

	@DecimalMin(value="0.276", inclusive=true, message="La comisión no puede ser menor a 0.276")
	@DecimalMax(value="0.946", inclusive=true, message="La comisión no puede ser mayor a 0.946")
	private float comision;

}
