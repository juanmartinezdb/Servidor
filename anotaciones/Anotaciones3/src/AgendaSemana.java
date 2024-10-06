<<<<<<< HEAD
import java.util.ArrayList;
import java.util.List;

@TareaNota(
        titulo = "platos",
        descripcion = "fregar cacharos",
        dia = "lunes",
        hora = 16
)
@TareaNota(
        titulo = "ropa",
        descripcion = "lavar y tender la ropa",
        dia = "lunes",
        hora = 6
)

@TareaNota(
        titulo = "compra",
        descripcion = "revisar lista",
        dia = "miercoles",
        hora = 18
)

@TareaNota(
        titulo = "limpieza",
        descripcion = "limpiar el salón",
        dia = "jueves",
        hora = 11
)

@TareaNota(
        titulo = "taller",
        descripcion = "llevar el coche al taller",
        dia = "viernes",
        hora = 9
)

@TareaNota(
        titulo = "mordisquitos",
        descripcion = "sacar al bicho a dar una vuelta",
        dia = "sabado",
        hora = 17
)

@TareaNota(
        titulo = "caos",
        descripcion = "organizar papeles del escritorio",
        dia = "domingo",
        hora = 14
)
public class AgendaSemana {
    private List<Tarea> tareas;

    public AgendaSemana() {
        tareas = new ArrayList<Tarea>();
    }


    //CARGADOR DE CONTEXTO
    public void cargadorDeContexto() {
        Class<AgendaSemana> claseAgendaSemana = AgendaSemana.class;

        TareaNota[] tareasYaAgendadas = claseAgendaSemana.getAnnotationsByType(TareaNota.class);
        for (TareaNota t : tareasYaAgendadas) {
            this.tareas.add(new Tarea(t.titulo(), t.descripcion(), t.dia(), t.hora()));
        }
        this.tareas.sort(null);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Tareas de la semana: {\n");
        for (Tarea t : tareas) {
            sb.append(t.toString());
            sb.append("\n");
        }
        sb.append("}\n");
        return sb.toString();

    }


}
=======
import java.util.ArrayList;
import java.util.List;

@TareaNota(
        titulo = "platos",
        descripcion = "fregar cacharos",
        dia = "lunes",
        hora = 16
)
@TareaNota(
        titulo = "ropa",
        descripcion = "lavar y tender la ropa",
        dia = "lunes",
        hora = 6
)

@TareaNota(
        titulo = "compra",
        descripcion = "revisar lista",
        dia = "miercoles",
        hora = 18
)

@TareaNota(
        titulo = "limpieza",
        descripcion = "limpiar el salón",
        dia = "jueves",
        hora = 11
)

@TareaNota(
        titulo = "taller",
        descripcion = "llevar el coche al taller",
        dia = "viernes",
        hora = 9
)

@TareaNota(
        titulo = "mordisquitos",
        descripcion = "sacar al bicho a dar una vuelta",
        dia = "sabado",
        hora = 17
)

@TareaNota(
        titulo = "caos",
        descripcion = "organizar papeles del escritorio",
        dia = "domingo",
        hora = 14
)
public class AgendaSemana {
    private List<Tarea> tareas;

    public AgendaSemana() {
        tareas = new ArrayList<Tarea>();
    }


    //CARGADOR DE CONTEXTO
    public static AgendaSemana cargadorDeContexto() {
        AgendaSemana agenda = new AgendaSemana();

        Class<AgendaSemana> claseAgendaSemana = AgendaSemana.class;

        TareaNota[] tareasYaAgendadas = claseAgendaSemana.getAnnotationsByType(TareaNota.class);
        for (TareaNota t : tareasYaAgendadas) {
            agenda.tareas.add(new Tarea(t.titulo(), t.descripcion(), t.dia(), t.hora()));
        }
        agenda.tareas.sort(null);
        return agenda;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Tareas de la semana: {\n");
        for (Tarea t : tareas) {
            sb.append(t.toString());
            sb.append("\n");
        }
        sb.append("}\n");
        return sb.toString();

    }


}
>>>>>>> bbb6114a5767b1720f7869d2d6227480050ac369
