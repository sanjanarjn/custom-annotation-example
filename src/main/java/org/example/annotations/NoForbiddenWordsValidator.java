package org.example.annotations;

import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

@Component
public class NoForbiddenWordsValidator {

    public boolean validate(Object obj) throws IllegalAccessException {
        for (Field field : obj.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(NoForbiddenWords.class)) {
                field.setAccessible(true);
                String value = (String) field.get(obj);
                for (String word : field.getAnnotation(NoForbiddenWords.class).words()) {
                    if (value != null && value.toLowerCase().contains(word.toLowerCase())) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
