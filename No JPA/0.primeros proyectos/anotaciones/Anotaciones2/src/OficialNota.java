import java.lang.annotation.*;

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Repeatable(OficialesNota.class)
public @interface OficialNota {
    String nombre();
    String apellido();
    String direccion();
    String dni();
    String telefono();
    int codigoTaller();  // Campo específico para Oficial
    String categoria();  // Campo específico para Oficial
}