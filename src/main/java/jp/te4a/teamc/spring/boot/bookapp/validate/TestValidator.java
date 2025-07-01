package jp.te4a.teamc.spring.boot.bookapp.validate;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class TestValidator implements ConstraintValidator<TestValid, String> {
    String param;

    @Override
    public void initialize(TestValid nv) {
        param = nv.param();
    }

    @Override
    public boolean isValid(String in, ConstraintValidatorContext cxt) {
        if (in == null) {
            return false;
        }
        System.out.println(in.equals(param));
        return !in.equals(param);
    }

}
