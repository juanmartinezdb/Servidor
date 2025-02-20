package org.iesbelen.videoclub.controller;


import lombok.extern.slf4j.Slf4j;
import org.iesbelen.videoclub.domain.Categoria;
import org.iesbelen.videoclub.service.CategoriaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api/v3/categorias")
public class CategoriaV1Controller {

    private final CategoriaService categoriaService;

    public CategoriaV1Controller(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    // Endpoint para obtener todas las categorías sin filtros
    @GetMapping(value = {"", "/"}, params = {"!buscar", "!ordenar"})
    public List<Categoria> all() {
        log.info("Accediendo a todas las peliculas");
        return this.categoriaService.all();
    }

    // Endpoint para obtener categorías con filtros opcionales de búsqueda y ordenación
    @GetMapping(value = {"", "/"})
    public List<Categoria> all(
            @RequestParam("buscar") Optional<String> buscarOptional,
            @RequestParam("ordenar") Optional<String> ordenarOptional) {

        log.info("Accediendo a todas las películas con filtro buscar: {} y ordenar: {}",
                buscarOptional.orElse("VOID"),
                ordenarOptional.orElse("VOID"));

        return this.categoriaService.allByQueryFilters(buscarOptional, ordenarOptional);
    }
}