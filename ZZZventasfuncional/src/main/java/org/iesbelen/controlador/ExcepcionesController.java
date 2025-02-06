package org.iesbelen.controlador;


import org.iesbelen.exception.MiExcepcion;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;


@ControllerAdvice //solo una clase puede tener el controller advice
public class ExcepcionesController {

    //  MiExcepcion (excepción personalizada)
    @ExceptionHandler(MiExcepcion.class)
    public String handleMiExcepcion(Model model, MiExcepcion e) { //aqui pongo la excepcion que he definido en exception
        model.addAttribute("traza", e.getMessage());
        return "errores/error-mi-excepcion"; // Página de error específica del error
    }

    // RuntimeException (errores no chequeados)
    @ExceptionHandler(RuntimeException.class)
    public String handleRuntimeException(Model model, RuntimeException e) {
        model.addAttribute("traza", e.getMessage());
        return "errores/error"; // Página de error genérica
    }

    @ExceptionHandler(NoResourceFoundException.class)
    public String handleNoResourceFound(Model model, NoResourceFoundException e) {
        model.addAttribute("traza", e.getMessage());
        return "errores/error-404";
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public String handleForeignKeyViolation(Model model, DataIntegrityViolationException e) {
        model.addAttribute("traza", "No se puede borrar este registro porque está siendo utilizado en otra tabla.");
        return "errores/error-fk"; // Página personalizada para errores de FK
    }

}
