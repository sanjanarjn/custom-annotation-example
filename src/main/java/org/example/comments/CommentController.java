package org.example.comments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping
    public ResponseEntity<?> addComment(@RequestBody Comment comment) throws IllegalAccessException {
        commentService.addComment(comment);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
