package org.iesbelen.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.Set;

public class RangoCategoriaValidator implements ConstraintValidator<RangoCategoria, Integer> {

    private static final Set<Integer> CATEGORIAS_VALIDAS = Set.of(100, 200, 300, 400, 500, 600, 700, 800, 1000);

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        return value != null && CATEGORIAS_VALIDAS.contains(value);
    }
}
