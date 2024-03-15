package org.example.comments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    @Autowired
    private CommentValidator validator;

    public void addComment(Comment comment) throws IllegalAccessException {
        if(!validator.validate(comment)) {
            throw new RuntimeException("Invalid comment");
        }
        // Add comment to db
    }
}
