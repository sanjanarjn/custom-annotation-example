package org.example.comments;

import org.example.annotations.NoForbiddenWordsValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommentValidator {

    @Autowired
    private NoForbiddenWordsValidator noForbiddenWordsValidator;

    public boolean validate(Comment comment) throws IllegalAccessException {
        return noForbiddenWordsValidator.validate(comment);
    }
}
