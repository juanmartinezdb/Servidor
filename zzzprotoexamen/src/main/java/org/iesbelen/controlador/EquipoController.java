package org.iesbelen.controlador;

import java.util.List;

import jakarta.validation.Valid;
import org.iesbelen.exception.MiExcepcion;
import org.iesbelen.modelo.Equipo;
import org.iesbelen.service.EquipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
//Se puede fijar ruta base de las peticiones de este controlador.
//Los mappings de los métodos tendrían este valor /equipos como
//prefijo.
@RequestMapping("/equipos")
public class EquipoController {

    @Autowired
    private EquipoService equipoService;

    //@RequestMapping(value = "/equipos", method = RequestMethod.GET)
    //equivalente a la siguiente anotación

    @GetMapping({""}) //cundo se pone mas de una ruta se pone con {} como objeto
    public String listar(Model model) {

        List<Equipo> listaEquipos =  equipoService.listAll();
        model.addAttribute("listaEquipos", listaEquipos);

        return "equipo/equipos";

    }

    @GetMapping("/{id}")
    public String detalle(Model model, @PathVariable String id ) {

        Equipo equipo = equipoService.one(id);
        model.addAttribute("equipo", equipo);

        return "equipo/detalle-equipo";

    }

    @GetMapping("/crear")
    public String crear(Model model) {

        Equipo equipo = new Equipo();
        model.addAttribute("equipo", equipo);

        return "equipo/crear-equipo";

    }

    @GetMapping("/editar/{id}")
    public String editar(Model model, @PathVariable String id) {

        Equipo equipo = equipoService.one(id);
        model.addAttribute("equipo", equipo);

        return "equipo/equipo-editar";

    }

    @PostMapping("/crear")
    public String submitCrear(@Valid @ModelAttribute Equipo equipo, BindingResult bindingResulted, Model model) {

        if (bindingResulted.hasErrors()) {
            model.addAttribute("equipo", equipo);

            return "equipo/crear-equipo";

        }
        equipoService.newEquipo(equipo);

        return ("redirect:/equipos") ;

    }

    @PostMapping("/editar/{nombreEquipo}")
    public String submitEditar(@PathVariable String nombreEquipo,
                               @Valid @ModelAttribute Equipo equipo,
                               BindingResult bindingResulted,
                               Model model) {
        if (bindingResulted.hasErrors()) {
            model.addAttribute("equipo", equipo);
            return "equipo-editar";
        }

        equipoService.replaceEquipo(equipo);
        return "redirect:/equipos"; // Sin espacio extra
    }


    @PostMapping("/borrar/{id}")
    public RedirectView submitBorrar(@PathVariable String id) {

        equipoService.deleteEquipo(id);

        return new RedirectView("/equipos");
    }
    ///////////////////////////////////EXCEPCIONES
    //Excepcion de Runtime
    @GetMapping("/error")
    public String RunTimeErrorEnEquipos() {
        throw new RuntimeException("Error de prueba en equipos");
    }

    //Excepcion declarada directamente en controlador sin pasar por el ControllerAdvice
    //van seguidos junto el getmapping y el exceptionhandler
    @GetMapping("/error2")
    public String RunTimeErrorEnEquipos2() throws MiExcepcion {
        throw new MiExcepcion();
    }

    @ExceptionHandler
    public  String miExcepcionDesdeController(Model model, MiExcepcion miExcepcion){
        model.addAttribute("traza", ("lanzado desde el controller de Equipo"+miExcepcion.getMessage()));
        return  "errores/error-mi-excepcion";
    }

}