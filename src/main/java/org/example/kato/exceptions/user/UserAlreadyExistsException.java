package org.example.kato.exceptions.user;

import lombok.Getter;
import org.example.kato.exceptions.ApplicationException;
import org.springframework.http.HttpStatus;

@Getter
public class UserAlreadyExistsException extends ApplicationException {
    public UserAlreadyExistsException(String message) {
        super(message, HttpStatus.CONFLICT);
    }
}
