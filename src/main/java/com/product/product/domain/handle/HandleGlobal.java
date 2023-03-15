package com.product.product.domain.handle;

import com.product.product.domain.exception.DeleteException;
import com.product.product.domain.exception.MessageException;
import com.product.product.domain.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HandleGlobal {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<MessageException> notFoundException(NotFoundException msg){
        HttpStatus status = HttpStatus.NOT_FOUND;
        MessageException err = new MessageException(System.currentTimeMillis(),status.value(),"404",msg.getMessage());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(DeleteException.class)
    public ResponseEntity<MessageException> deleteException(DeleteException msg){
        HttpStatus status = HttpStatus.BAD_REQUEST;
        MessageException err = new MessageException(System.currentTimeMillis(),status.value(),"400",msg.getMessage());
        return ResponseEntity.status(status).body(err);
    }
}
