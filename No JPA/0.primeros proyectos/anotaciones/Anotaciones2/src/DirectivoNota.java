import java.lang.annotation.*;

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Repeatable(DirectivosNota.class)
public @interface DirectivoNota {
    String nombre();
    String apellido();
    String direccion();
    String dni();
    String telefono();
    int codigoDespacho() default 0;
}