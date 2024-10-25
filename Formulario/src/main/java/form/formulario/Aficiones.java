package form.formulario;

public class Aficiones {
    Boolean cine;
    Boolean literatura;
    Boolean tebeos;
    Boolean deporte;
    Boolean musica;
    Boolean television;

    public Aficiones(String cine, String literatura, String tebeos, String deporte, String musica, String television) {
        this.cine = cine==null ? false : true;
        this.literatura = literatura==null ? false : true;
        this.tebeos = tebeos==null ? false : true;
        this.deporte = deporte==null ? false : true;
        this.musica = musica==null ? false : true;
        this.television = television==null ? false : true;
    }

    @Override
    public String toString() {
        return "Aficiones:" +
                "<br>cine=" + cine +
                "<br>literatura=" + literatura +
                "<br>tebeos=" + tebeos +
                "<br>deporte=" + deporte +
                "<br>musica=" + musica +
                "<br>television=" + television;
    }
}
