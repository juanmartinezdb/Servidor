import java.lang.annotation.*;

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Repeatable(TareasNota.class)
public @interface TareaNota {
    String titulo();
    String descripcion();
    String dia();
    int hora();
}
