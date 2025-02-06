import java.lang.annotation.*;

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Repeatable(EmpleadosNota.class)
public @interface EmpleadoNota {
    String nombre();
    String apellidos();
    String direccion();
    String dni();
    String telefono();
    String clase(); // "Directivo", "Tecnico", "Oficial"
}

