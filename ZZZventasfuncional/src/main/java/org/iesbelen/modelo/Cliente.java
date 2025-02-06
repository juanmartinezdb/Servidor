package org.iesbelen.modelo;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.iesbelen.validator.RangoCategoria;
import org.iesbelen.validator.RangoCategoriaPlus;

//La anotación @Data de lombok proporcionará el código de:
//getters/setters, toString, equals y hashCode
//propio de los objetos POJOS o tipo Beans
@Data
//Para generar un constructor con lombok con todos los args
@AllArgsConstructor
@NoArgsConstructor
@Builder // Cliente.builder().atrib("").atrib2("").build();
public class Cliente {
	
	private long id;

	@NotBlank(message = "Por favor, introduzca nombre.")
//	@Size(min=4, message = "Nombre al menos de {min} caracter${max>1 ? 'es' : ''}. Ha introducido '${validatedValue}'.")
//	@Size(max=10, message = "Nombre como máximo de {max} caracteres.")
	@Size(max=30, message = "Nombre como máximo de 30 caracteres.")
	private String nombre;

	@NotBlank(message = "Por favor, introduzca un apellido.")
	@Size(max=30, message = "Apellido como máximo de 30 caracteres.")
	private String apellido1;

	private String apellido2;

	@NotBlank(message = "Por favor, introduzca una ciudad.")
	@Size(max=50, message = "Ciudad como máximo de 50 caracteres.")
	private String ciudad;

//	@Min(value=100, message = "La categoría debe ser un numero de al menos de 100.")
//	@Max(value=10000, message = "La categoría no debe ser mayor de 1000.")
//	@RangoCategoria()
	@RangoCategoriaPlus(value = {100,200,300,400,500,600,700,800,900,1000}, min = 200, max = 900)
	private int categoria;

	@NotBlank(message = "Por favor, introduzca email.")
	@Email(message = "Formato de email incorrecto", regexp="^[a-zA-Z0-9._-]+@[a-zA-Z0-9-]+\\.[a-zA-Z.]{2,5}")
	private String email;
	
}
