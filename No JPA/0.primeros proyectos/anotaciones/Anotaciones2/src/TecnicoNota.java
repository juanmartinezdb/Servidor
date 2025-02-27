import java.lang.annotation.*;

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Repeatable(TecnicosNota.class)
public @interface TecnicoNota {
    String nombre();
    String apellido();
    String direccion();
    String dni();
    String telefono();
    int codigoTaller();   // Campo específico para Técnico
    String perfil();      // Campo específico para Técnico
}