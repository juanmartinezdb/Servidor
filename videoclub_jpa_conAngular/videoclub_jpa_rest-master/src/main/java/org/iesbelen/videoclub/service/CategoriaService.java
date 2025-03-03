package org.iesbelen.videoclub.service;

import org.iesbelen.videoclub.domain.Categoria;
import org.iesbelen.videoclub.domain.Pelicula;
import org.iesbelen.videoclub.exception.CategoriaNotFoundException;
import org.iesbelen.videoclub.repository.CategoriaCustomRepository;
import org.iesbelen.videoclub.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private CategoriaCustomRepository categoriaCustomRepository;


    public CategoriaService(CategoriaRepository categoriaRepository, CategoriaCustomRepository categoriaCustomRepository) {
        this.categoriaRepository = categoriaRepository;
        this.categoriaCustomRepository = categoriaCustomRepository;

    }

    public List<Categoria> all() {
        return categoriaRepository.findAll();
    }

    public Categoria save(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }
    public Categoria one(long id) {
        return this.categoriaRepository.findById(id)
                .orElseThrow(()-> new CategoriaNotFoundException(id));
    }
    public void delete(long id) {
        this.categoriaRepository.findById(id).map(p -> {
            this.categoriaRepository.delete(p);
            return p;
        }).orElseThrow(()-> new CategoriaNotFoundException(id));
    }

    public Categoria replace(Long id, Categoria categoria) {
        return this.categoriaRepository.findById(id).map
                ( p -> (id.equals(categoria.getIdCategoria()) ?
                this.categoriaRepository.save(categoria): null))
                .orElseThrow(() -> new CategoriaNotFoundException(id));
    }

//    ESTO ESTA MAL ARREGLAR
    public List<Pelicula> peliculasByCategoria(long id) {
        return this.categoriaRepository.getByIdCategoria(id);
    }

    public List<Categoria> allByQueryFilters(Optional<String> buscarOptional, Optional<String> ordenarOptional) {
        return  this.categoriaCustomRepository.queryCustomCategoria(buscarOptional, ordenarOptional);
    }
}
