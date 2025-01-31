package org.iesbelen.modelo;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//La anotación @Data de lombok proporcionará el código de:
//getters/setters, toString, equals y hashCode
//propio de los objetos POJOS o tipo Beans
@Data
//Para generar un constructor con lombok con todos los args
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {
	
	private long id;

	@NotBlank(message = "Por favor, introduzca nombre.")
	@Size(max=30, message = "Nombre como máximo de 30 caracteres.")
	private String nombre;

	@NotBlank(message = "Por favor, introduzca un apellido.")
	@Size(max=30, message = "Apellido como máximo de 30 caracteres.")
	private String apellido1;

	private String apellido2;

	@NotBlank(message = "Por favor, introduzca una ciudad.")
	@Size(max=50, message = "Ciudad como máximo de 50 caracteres.")
	private String ciudad;

	@Min(value=100, message = "La categoría debe ser un numero de al menos de 100.")
	@Max(value=10000, message = "La categoría no debe ser mayor de 1000.")
	private int categoria;
	
}
