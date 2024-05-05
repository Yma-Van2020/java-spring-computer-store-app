package com.example.demo.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 *
 *
 *
 */
@Constraint(validatedBy = {BelowPartsMinInvValidator.class})
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidBelowPartsMinInv {
    String message() default "Adding and updating products lowers the part inventory below the minimum.";
    Class<?> [] groups() default {};
    Class<? extends Payload> [] payload() default {};

}