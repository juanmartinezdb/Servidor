package prueba.preexamenventasplus.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {


        private int idEmpleado;

        @NotBlank(message = "{error.nombre}")
        //unico
        private String username;
@Min(value = 6, message = "{error.password.min}")
        private String password;
//meter una validacion personalizada de Admin, vendedor, etc...
        private String rol;
}
