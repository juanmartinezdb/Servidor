package org.iesbelen.videoclub.controller;

import lombok.extern.slf4j.Slf4j;
import org.iesbelen.videoclub.domain.Categoria;
import org.iesbelen.videoclub.domain.Pelicula;
import org.iesbelen.videoclub.repository.CategoriaRepository;
import org.iesbelen.videoclub.service.CategoriaService;
import org.iesbelen.videoclub.service.PeliculaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/categorias")
public class CategoriaController {
    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }


    ///////////////////////////////////GETS///////////////////////////////////////////////
    @GetMapping(value = {"", "/"}, params = {"!buscar", "!ordenar !busqueda"})
    public List<Categoria> all() {
        log.info("Accediendo a todas las peliculas");
        return this.categoriaService.all();
    }
    @GetMapping(value = {"/busqueda"}, params = {"!buscar", "!ordenar"})
    public ResponseEntity<List<Categoria>> all(@RequestParam (value= "busqueda", required = false) String[] busqueda){
        log.info("Accediendo a todas las peliculas por nombre y orden");

        List<Categoria> categrias = this.categoriaService.getByNombre(busqueda);
        return ResponseEntity.ok(categrias);
    }

    @GetMapping(value = {"", "/"}, params={"!busqueda"})
    public List<Categoria> all(
            @RequestParam("buscar") Optional<String> buscarOptional,
            @RequestParam("ordenar") Optional<String> ordenarOptional) {

        log.info("Accediendo a todas las categorias con filtro buscar: {} y ordenar: {}",
                buscarOptional.orElse("VOID"),
                ordenarOptional.orElse("VOID"));

        return this.categoriaService.allByQueryFilters(buscarOptional, ordenarOptional);
    }

    @GetMapping("/{id}/numeroPeliculas")
    public int getNumeroPeliculas(@PathVariable Long id) {
        log.info("Accediendo a todas las peliculas");
        return this.categoriaService.one(id).getPeliculas().size();

    }

    @GetMapping("{id}")
    public Categoria one(@PathVariable Long id) {
        return  this.categoriaService.one(id);
    }

    ///////////////////////////////////POST/////////////////////////////////////////////

    @PostMapping({"", "/"})
    public Categoria newCategoria(@RequestBody Categoria categoria) {
        return this.categoriaService.save(categoria);
    }


    ///////////////////////////////////PUT/////////////////////////////////////////////
    @PutMapping("/{id}")
    public Categoria replaceCategoria(@PathVariable("id") Long id, @RequestBody Categoria categoria) {
        return  this.categoriaService.replace(id, categoria);
    }



    ///////////////////////////////////DELETE/////////////////////////////////////////////
    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        this.categoriaService.delete(id);
    }
}
