package org.iesbelen.videoclub.exception;

public class CategoriaNotFoundException extends RuntimeException {
    public CategoriaNotFoundException(Long id) {
        super("Categoria no encontrda con la id: "+id);
    }
}
