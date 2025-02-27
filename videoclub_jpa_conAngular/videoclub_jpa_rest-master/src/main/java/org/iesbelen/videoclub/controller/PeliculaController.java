package org.iesbelen.videoclub.controller;

import lombok.extern.slf4j.Slf4j;
import org.iesbelen.videoclub.domain.Categoria;
import org.iesbelen.videoclub.domain.Pelicula;
import org.iesbelen.videoclub.service.CategoriaService;
import org.iesbelen.videoclub.service.PeliculaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/peliculas")
public class PeliculaController {
    private final PeliculaService peliculaService;

    public PeliculaController(PeliculaService peliculaService) {
        this.peliculaService = peliculaService;
    }

    ///////////////////////////////////GET/////////////////////////////////////////////

    @GetMapping(value = {"","/"}, params = {"!pagina", "!tamanio"})
    public List<Pelicula> all() {
        log.info("Accediendo a todas las películas");
        return this.peliculaService.all();
    }
//    @GetMapping(value = {"","/"})
//    public ResponseEntity<Map<String, Object>> all(@RequestParam(value = "pagina", defaultValue = "0") int pagina
//    ,@RequestParam(value= "tamanio", defaultValue = "2") int tamanio){
//
//        log.info("Accediendo a todas las películas con paginacion");
//
//
//        Map<String, Object> responseAll = this.peliculaService.all(pagina, tamanio);
//
//        return ResponseEntity.ok(responseAll);
//    }
@GetMapping(value = {"","/"})
public ResponseEntity<Map<String, Object>> all(@RequestParam(value = "paginado", defaultValue = "0") String[] paginacion) {

    log.info("Accediendo a todas las películas con paginacion");


    Map<String, Object> responseAll = this.peliculaService.all(paginacion);

    return ResponseEntity.ok(responseAll);
}



    @GetMapping("/{id}")
    public Pelicula one(@PathVariable("id") Long id) {

        return this.peliculaService.one(id);
    }

    ///////////////////////////////////POST/////////////////////////////////////////////

    @PostMapping({"","/"})
    public Pelicula newPelicula(@RequestBody Pelicula pelicula) {
        return this.peliculaService.save(pelicula);
    }

    @PostMapping("/{id}/add/{idCategoria}")
    public boolean aniadirCategoria(@PathVariable("id") Long id, @PathVariable("idCategoria") Long idCategoria) {
//        Categoria nuevaCategoria = this.categoriaService.one(idCategoria);
//        Pelicula nuevaPelicula = this.peliculaService.one(id);
//        nuevaPelicula.getCategorias().add(nuevaCategoria);

        return this.peliculaService.addCategoriaToPelicula(id, idCategoria);
//        return this.peliculaService.save(nuevaPelicula);
//      return this.peliculaService.replace(nuevaPelicula.getIdPelicula(), nuevaPelicula );
    }


    ///////////////////////////////////PUT/////////////////////////////////////////////

    @PutMapping("/{id}")
    public Pelicula replacePelicula(@PathVariable("id") Long id, @RequestBody Pelicula pelicula) {
        return this.peliculaService.replace(id, pelicula);
    }

    ///////////////////////////////////DELETE/////////////////////////////////////////////

    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deletePelicula(@PathVariable("id") Long id) {
        this.peliculaService.delete(id);
    }


}
