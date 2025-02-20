package org.iesbelen.videoclub.controller;

import org.iesbelen.videoclub.exception.CategoriaNotFoundException;
import org.iesbelen.videoclub.exception.IdiomaNotFoundException;
import org.iesbelen.videoclub.exception.PeliculaNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {

    @ResponseBody
    @ExceptionHandler(PeliculaNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String peliculaNotFoundHandler(PeliculaNotFoundException peliculaNotFoundException) {
        return peliculaNotFoundException.getMessage();
    }
    @ResponseBody
    @ExceptionHandler(CategoriaNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String categoriaNotFoundHandler(CategoriaNotFoundException categoriaNotFoundException) {
        return categoriaNotFoundException.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(IdiomaNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String idiomaNotFoundHandler(IdiomaNotFoundException idiomaNotFoundException) {
        return idiomaNotFoundException.getMessage();
    }
}
