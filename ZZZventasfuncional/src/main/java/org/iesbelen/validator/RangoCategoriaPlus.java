package org.iesbelen.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = RangoCategoriaPlusValidator.class)
@Documented
public @interface RangoCategoriaPlus {

    int[] value(); // Permite definir valores personalizados

    String message() default "{error.rangocategoria.plus}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
