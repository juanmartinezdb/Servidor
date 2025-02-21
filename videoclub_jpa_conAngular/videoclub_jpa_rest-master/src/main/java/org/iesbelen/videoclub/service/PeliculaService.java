package org.iesbelen.videoclub.service;

import org.iesbelen.videoclub.domain.Categoria;
import org.iesbelen.videoclub.exception.PeliculaNotFoundException;
import org.iesbelen.videoclub.repository.CategoriaRepository;
import org.iesbelen.videoclub.repository.PeliculaRepository;
import org.iesbelen.videoclub.domain.Pelicula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class PeliculaService {

    @Autowired
    private final PeliculaRepository peliculaRepository;

    @Autowired
    private final CategoriaService categoriaService;

    public PeliculaService(PeliculaRepository peliculaRepository, CategoriaService categoriaService) {
        this.peliculaRepository = peliculaRepository;
        this.categoriaService = categoriaService;
    }

    public List<Pelicula> all() {
        return this.peliculaRepository.findAll();
    }

    public Map<String, Object> all(int pagina, int tamanio) {
        Pageable paginado = PageRequest.of(pagina, tamanio, Sort.by("idPelicula").ascending());

        Page<Pelicula> pageAll = this.peliculaRepository.findAll(paginado);

        Map<String, Object> response = new HashMap<>();

        response.put("peliculas", pageAll.getContent());
        response.put("currentPage", pageAll.getNumber());
        response.put("totalPages", pageAll.getTotalPages());
        response.put("totalElements", pageAll.getTotalElements());
        return response;
    }

    public Map<String, Object> all(String[] paginacion) {
        Pageable paginado = PageRequest.of(Integer.parseInt(paginacion[0]),Integer.parseInt(paginacion[1]), Sort.by("idPelicula").ascending());

        Page<Pelicula> pageAll = this.peliculaRepository.findAll(paginado);

        Map<String, Object> response = new HashMap<>();

        response.put("peliculas", pageAll.getContent());
        response.put("currentPage", pageAll.getNumber());
        response.put("totalPages", pageAll.getTotalPages());
        response.put("totalElements", pageAll.getTotalElements());
        return response;
    }

    public Pelicula save(Pelicula pelicula) {
        return this.peliculaRepository.save(pelicula);
    }

    public Pelicula one(Long id) {
        return this.peliculaRepository.findById(id)
                .orElseThrow(() -> new PeliculaNotFoundException(id));
    }

    public Pelicula replace(Long id, Pelicula pelicula) {

        return this.peliculaRepository.findById(id).map
                        ( p -> (id.equals(pelicula.getIdPelicula())  ?
                                this.peliculaRepository.save(pelicula) : null))
                .orElseThrow(() -> new PeliculaNotFoundException(id));

    }

    public void delete(Long id) {
        this.peliculaRepository.findById(id).map(p -> {this.peliculaRepository.delete(p);
                                                        return p;})
                .orElseThrow(() -> new PeliculaNotFoundException(id));
    }

    public boolean addCategoriaToPelicula(Long idPelicula, Long idCategoria) {
        boolean res = false;
        Categoria categoria = categoriaService.one(idCategoria);
        Pelicula pelicula =  this.one(idPelicula);

        res = pelicula.getCategorias().add(categoria) && categoria.getPeliculas().add(pelicula);

        if (res){
            this.peliculaRepository.save(pelicula);
        }
        return res;


    }

}
