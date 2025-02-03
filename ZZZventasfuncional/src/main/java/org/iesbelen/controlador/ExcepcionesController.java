package org.iesbelen.controlador;

import org.iesbelen.exception.MiExcepcion;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExcepcionesController {
    @ExceptionHandler(RuntimeException.class)
    public ModelAndView handleRuntimeException(RuntimeException e) {
        ModelAndView mv = new ModelAndView("error");
        mv.addObject("mensaje", e.getMessage());
        return mv;
    }

    @ExceptionHandler(MiExcepcion.class)
    public ModelAndView handleMiException(MiExcepcion e) {
        ModelAndView mv = new ModelAndView("error");
        mv.addObject("mensaje", e.getMessage());
        return mv;
    }
}
