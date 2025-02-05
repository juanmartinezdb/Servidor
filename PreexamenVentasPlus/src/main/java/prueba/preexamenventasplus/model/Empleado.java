package prueba.preexamenventasplus.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Empleado {

    private int id;

    @NotBlank(message = "{error.nombre}")
    private String nombre;

    @NotBlank(message = "{error.apellido}")
    private String apellido;

    @NotBlank(message = "{error.email.vacio}")
    @Email (message = "{error.email.formato}", regexp="^[a-zA-Z0-9._-]+@[a-zA-Z0-9-]+\\.[a-zA-Z.]{2,5}" )
    private String email;

    private String telefono;

}
