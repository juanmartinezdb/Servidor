package org.iesbelen.controlador;

import java.util.List;

import jakarta.validation.Valid;
import org.iesbelen.exception.MiExcepcion;
import org.iesbelen.modelo.Partido;
import org.iesbelen.service.PartidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
//Se puede fijar ruta base de las peticiones de este controlador.
//Los mappings de los métodos tendrían este valor /partidos como
//prefijo.
//@RequestMapping("/partidos")
public class PartidoController {

    @Autowired
    private PartidoService partidoService;

    //@RequestMapping(value = "/partidos", method = RequestMethod.GET)
    //equivalente a la siguiente anotación

    @GetMapping({"/partidos"}) //cundo se pone mas de una ruta se pone con {} como objeto
    public String listar(Model model) {

        List<Partido> listaPartidos =  partidoService.listAll();
        model.addAttribute("listaPartidos", listaPartidos);

        return "partido/partidos";

    }

    @GetMapping("/partidos/{id}")
    public String detalle(Model model, @PathVariable Integer id ) {

        Partido partido = partidoService.one(id);
        model.addAttribute("partido", partido);

        return "partido/detalle-partido";

    }

    @GetMapping("/partidos/crear")
    public String crear(Model model) {

        Partido partido = new Partido();
        model.addAttribute("partido", partido);

        return "partido/crear-partido";

    }

    @GetMapping("/partidos/editar/{id}")
    public String editar(Model model, @PathVariable Integer id) {

        Partido partido = partidoService.one(id);
        model.addAttribute("partido", partido);

        return "partido/editar-partido";

    }

    @PostMapping("/partidos/crear")
    public String submitCrear(@Valid @ModelAttribute Partido partido, BindingResult bindingResulted, Model model) {

        if (bindingResulted.hasErrors()) {
            model.addAttribute("partido", partido);

            return "partido/crear-partido";

        }
        partidoService.newPartido(partido);

        return ("redirect:/partidos") ;

    }

    @PostMapping("/partidos/editar/{id}")
    public String submitEditar(@Valid @ModelAttribute Partido partido, BindingResult bindingResulted, Model model) {
        if (bindingResulted.hasErrors()) {
            model.addAttribute("partido", partido);

            return "partido/editar-partido";

        }
        partidoService.replacePartido(partido);

        return ("redirect: /partidos");
    }

    @PostMapping("/partidos/borrar/{id}")
    public RedirectView submitBorrar(@PathVariable Integer id) {

        partidoService.deletePartido(id);

        return new RedirectView("/partidos");
    }
    ///////////////////////////////////EXCEPCIONES
    //Excepcion de Runtime
    @GetMapping("/partidos/error")
    public String RunTimeErrorEnPartidos() {
        throw new RuntimeException("Error de prueba en partidos");
    }

    //Excepcion declarada directamente en controlador sin pasar por el ControllerAdvice
    //van seguidos junto el getmapping y el exceptionhandler
    @GetMapping("/partidos/error2")
    public String RunTimeErrorEnPartidos2() throws MiExcepcion {
        throw new MiExcepcion();
    }

    @ExceptionHandler
    public  String miExcepcionDesdeController(Model model, MiExcepcion miExcepcion){
        model.addAttribute("traza", ("lanzado desde el controller de Partido"+miExcepcion.getMessage()));
        return  "errores/error-mi-excepcion";
    }

}