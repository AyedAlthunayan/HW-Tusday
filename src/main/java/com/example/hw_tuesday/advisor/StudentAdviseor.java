package com.example.hw_tuesday.advisor;

import com.example.hw_tuesday.exception.MessageException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityNotFoundException;
import java.sql.SQLIntegrityConstraintViolationException;

@RestController
public class StudentAdviseor {
    @ExceptionHandler(value = MessageException.class)
    public ResponseEntity<MessageException> apiException(MessageException e){
        String msg=e.getMessage();
        return ResponseEntity.status(400).body(new MessageException(msg));
    }

    @ExceptionHandler(value = SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<MessageException> SQLIntegrityConstraintViolationException(SQLIntegrityConstraintViolationException e){
        String msg=e.getMessage();
        return ResponseEntity.status(400).body(new MessageException(msg));
    }
    @ExceptionHandler(value = EntityNotFoundException.class)
    public ResponseEntity<MessageException> EntityNotFoundException(EntityNotFoundException e) {
        String msg = e.getMessage();
        return ResponseEntity.status(400).body(new MessageException(msg));
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<MessageException> MethodArgumentNotValidException(MethodArgumentNotValidException e) {
        String msg = e.getFieldError().getDefaultMessage();
        return ResponseEntity.status(400).body(new MessageException(msg));
    }


}
