package org.iesbelen.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RangoCategoriaPlusValidator implements ConstraintValidator<RangoCategoriaPlus, Integer> {

    private Set<Integer> categoriasValidas;

    @Override
    public void initialize(RangoCategoriaPlus constraintAnnotation) {
        categoriasValidas = IntStream.of(constraintAnnotation.value())
                .boxed()
                .collect(Collectors.toSet());
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        return value != null && categoriasValidas.contains(value);
    }
}
