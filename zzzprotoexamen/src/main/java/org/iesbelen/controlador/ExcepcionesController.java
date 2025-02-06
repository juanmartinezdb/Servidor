package org.iesbelen.controlador;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExcepcionesController {

    // Manejo de MiExcepcion (excepción personalizada)
//    @ExceptionHandler(MiExcepcion.class)
//    public String handleMiExcepcion(Model model, MiExcepcion e) { //aqui pongo la excepcion que he definido en exception
//        model.addAttribute("traza", e.getMessage());
//        return "errores/error-mi-excepcion"; // Página de error específica del error
//    }

    // Manejo de RuntimeException (errores no chequeados)
//    @ExceptionHandler(RuntimeException.class)
//    public String handleRuntimeException(Model model, RuntimeException e) {
//        model.addAttribute("traza", e.getMessage());
//        return "errores/error"; // Página de error genérica
//    }
}
