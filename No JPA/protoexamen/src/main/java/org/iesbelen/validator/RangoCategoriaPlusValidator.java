package org.iesbelen.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RangoCategoriaPlusValidator implements ConstraintValidator<RangoCategoriaPlus, Integer> {

    private Set<Integer> categoriasValidas;
    private int min;
    private int max;

    @Override
    public void initialize(RangoCategoriaPlus constraintAnnotation) {
        categoriasValidas = Arrays.stream(constraintAnnotation.value())
                .boxed() // IntStream ➝ Stream<Integer>
                 .collect(Collectors.toSet());

        min = constraintAnnotation.min();
        max = constraintAnnotation.max();

    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {

        context.disableDefaultConstraintViolation(); // Deshabilitamos el que tiene

        if (value < min) {
            context.buildConstraintViolationWithTemplate("El valor debe ser mayor o igual a " + min)
                    .addConstraintViolation();
            return false;
        }

        if (value > max) {
            context.buildConstraintViolationWithTemplate("El valor debe ser menor o igual a " + max)
                    .addConstraintViolation();
            return false;
        }

        if (!categoriasValidas.contains(value)) {
            context.buildConstraintViolationWithTemplate("El valor no está permitido. Debe ser uno de: " + categoriasValidas)
                    .addConstraintViolation();
            return false;
        }

        return true;
    }
}
