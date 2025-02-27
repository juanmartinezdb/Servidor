package org.iesbelen.controlador;

import java.util.List;

import jakarta.validation.Valid;
import org.iesbelen.exception.MiExcepcion;
import org.iesbelen.modelo.Jugador;
import org.iesbelen.service.JugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
//Se puede fijar ruta base de las peticiones de este controlador.
//Los mappings de los métodos tendrían este valor /jugadores como
//prefijo.
@RequestMapping("/jugadores")
public class JugadorController {

    @Autowired
    private JugadorService jugadorService;

    //@RequestMapping(value = "/jugadores", method = RequestMethod.GET)
    //equivalente a la siguiente anotación

    @GetMapping({""}) //cundo se pone mas de una ruta se pone con {} como objeto
    public String listar(Model model) {

        List<Jugador> listaJugadors =  jugadorService.listAll();
        model.addAttribute("listaJugadors", listaJugadors);

        return "jugador/jugadores";

    }

    @GetMapping("/{id}")
    public String detalle(Model model, @PathVariable Integer id ) {

        Jugador jugador = jugadorService.one(id);
        model.addAttribute("jugador", jugador);

        return "jugador/detalle-jugador";

    }

    @GetMapping("/crear")
    public String crear(Model model) {

        Jugador jugador = new Jugador();
        model.addAttribute("jugador", jugador);

        return "jugador/crear-jugador";

    }

    @GetMapping("/editar/{id}")
    public String editar(Model model, @PathVariable Integer id) {

        Jugador jugador = jugadorService.one(id);
        model.addAttribute("jugador", jugador);

        return "jugador/editar-jugador";

    }

    @PostMapping("/crear")
    public String submitCrear(@Valid @ModelAttribute Jugador jugador, BindingResult bindingResulted, Model model) {

        if (bindingResulted.hasErrors()) {
            model.addAttribute("jugador", jugador);

            return "jugador/crear-jugador";

        }
        jugadorService.newJugador(jugador);

        return ("redirect:/jugadores") ;

    }

    @PostMapping("/editar/{id}")
    public String submitEditar(@Valid @ModelAttribute Jugador jugador, BindingResult bindingResulted, Model model) {
        if (bindingResulted.hasErrors()) {
            model.addAttribute("jugador", jugador);

            return "jugador/editar-jugador";

        }
        jugadorService.replaceJugador(jugador);

        return ("redirect: /jugadores");
    }

    @PostMapping("/borrar/{id}")
    public RedirectView submitBorrar(@PathVariable Integer id) {

        jugadorService.deleteJugador(id);

        return new RedirectView("/jugadores");
    }
    ///////////////////////////////////EXCEPCIONES
    //Excepcion de Runtime
    @GetMapping("/error")
    public String RunTimeErrorEnJugadors() {
        throw new RuntimeException("Error de prueba en jugadores");
    }

    //Excepcion declarada directamente en controlador sin pasar por el ControllerAdvice
    //van seguidos junto el getmapping y el exceptionhandler
    @GetMapping("/error2")
    public String RunTimeErrorEnJugadors2() throws MiExcepcion {
        throw new MiExcepcion();
    }

    @ExceptionHandler
    public  String miExcepcionDesdeController(Model model, MiExcepcion miExcepcion){
        model.addAttribute("traza", ("lanzado desde el controller de Jugador"+miExcepcion.getMessage()));
        return  "errores/error-mi-excepcion";
    }

}