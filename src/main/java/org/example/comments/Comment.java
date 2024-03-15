package org.example.comments;

import org.example.annotations.NoForbiddenWords;

public record Comment (long id, @NoForbiddenWords(words = {"kill", "hurt"}) String text) {

}
