package prueba.demothymeleaf.modelo;

public class Libro {
    private String titulo;
    private String autor;
    private String editorial;
    private Integer id;

public Libro(String titulo, String autor, String editorial) {
    this.titulo = titulo;
    this.autor = autor;
    this.editorial = editorial;
}
    public Libro(Integer id, String titulo, String autor, String editorial) {
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.id = id;
    }
public String getTitulo() {
    return titulo;
}
public void setTitulo(String titulo) {
    this.titulo = titulo;
}
public String getAutor() {
    return autor;
}
public void setAutor(String autor) {
    this.autor = autor;

}
public String getEditorial() {
    return editorial;
}

public void setEditorial(String editorial) {
    this.editorial = editorial;

}
public Integer getId() {
    return id;
}
public void setId(Integer id) {
    this.id = id;
}

}
