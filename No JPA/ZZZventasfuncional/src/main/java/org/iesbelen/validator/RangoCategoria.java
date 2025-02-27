package org.iesbelen.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = RangoCategoriaValidator.class)
@Documented
public @interface RangoCategoria {

    String message() default "{error.rangocategoria}"; // Mensaje de error

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}