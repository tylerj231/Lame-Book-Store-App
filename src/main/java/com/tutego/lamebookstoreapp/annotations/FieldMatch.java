package com.tutego.lamebookstoreapp.annotations;

import com.tutego.lamebookstoreapp.validators.PasswordMatchesValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordMatchesValidator.class)
public @interface FieldMatch {
    String message() default "Passwords do not match";
    Class<?> [] groups() default {};
    Class<? extends Payload> [] payload() default {};
}
