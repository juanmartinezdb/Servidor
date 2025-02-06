import java.util.ArrayList;
import java.util.List;

@DirectivoNota(
        nombre = "Mengano",
        apellido = "García",
        direccion = "Calle Falsa 1, Malaga",
        dni = "12345678A",
        telefono = "123456789",
        codigoDespacho = 101
)
@TecnicoNota(
        nombre = "Mengana",
        apellido = "Martínez",
        direccion = "Calle Falsa 2, Malaga",
        dni = "12345678B",
        telefono = "123456780",
        codigoTaller = 202,
        perfil = "Informática"
)
@OficialNota(
        nombre = "Perico",
        apellido = "Palotes",
        direccion = "Calle Falsa 3, Malaga",
        dni = "12345678C",
        telefono = "234567890",
        codigoTaller = 303,
        categoria = "B"
)
public class Empresa {

    private String nombre;
    private List<Empleado> empleados;

    public Empresa(String nombre) {
        this.nombre = nombre;
        this.empleados = new ArrayList<>();
    }

        //CARGADOR DE CONTEXTO
        public static Empresa cargadorDeContexto(String nombre) {
        Empresa empresa = new Empresa(nombre);

        // Sacamos la clase de la empresa para referirnos a ella despues **Esto me resulta muy complicado y no lo entiendo bien**
        //Class<Empresa> claseEmpresa = Empresa.class;

        // Pillamos las notas en un array
        //EmpleadoNota[] empleadosAnotados = claseEmpresa.getAnnotationsByType(EmpleadoNota.class);

        DirectivoNota[] directivosAnotados = Empresa.class.getAnnotationsByType(DirectivoNota.class);
        TecnicoNota[] tecnicosAnotados = Empresa.class.getAnnotationsByType(TecnicoNota.class);
        OficialNota[] oficialesAnotados = Empresa.class.getAnnotationsByType(OficialNota.class);

            // Recorremos el array para procesas todas las notas que teniamos puestas
            for (DirectivoNota e : directivosAnotados) {
                empresa.empleados.add(new Directivo(e.nombre() , e.apellido(), e.direccion(), e.dni(), e.telefono(), e.codigoDespacho()));
            }
            for (TecnicoNota e : tecnicosAnotados) {
                empresa.empleados.add(new Tecnico(e.nombre() , e.apellido(), e.direccion(), e.dni(), e.telefono(), e.codigoTaller(), e.perfil()));
            }
            for (OficialNota e : oficialesAnotados) {
                empresa.empleados.add(new Oficial(e.nombre() , e.apellido(), e.direccion(), e.dni(), e.telefono(), e.codigoTaller(), e.categoria()));
            }

        return empresa;
    }

    @Override
    public String toString() {
        String cadena = "Empresa: "+nombre+"\n";
        for (Empleado e : empleados) {
            cadena += e.toString() + "\n";
        }
        return cadena;
    }


}
