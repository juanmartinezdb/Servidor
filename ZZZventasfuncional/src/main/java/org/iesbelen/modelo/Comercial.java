package org.iesbelen.modelo;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

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
	private BigDecimal comision;

	@Email(message = "Formato de email incorrecto", regexp="^[a-zA-Z0-9._-]+@[a-zA-Z0-9-]+\\.[a-zA-Z.]{2,5}")
	@NotBlank(message = "Por favor, introduzca email.")
	private String email;
}
