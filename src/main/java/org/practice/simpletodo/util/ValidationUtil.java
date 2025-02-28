package org.practice.simpletodo.util;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.springframework.context.annotation.Configuration;

import java.util.Set;

@Configuration
public class ValidationUtil {
    private static final ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
    private static final Validator validator = validatorFactory.getValidator();

    public Set<ConstraintViolation<Object>> validate(Object o) {
        return validator.validate(o);
    }

    public boolean isValid(Object o) {
        return validator.validate(o).isEmpty();
    }
}
