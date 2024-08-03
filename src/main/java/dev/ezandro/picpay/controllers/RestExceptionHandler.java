package dev.ezandro.picpay.controllers;

import dev.ezandro.picpay.exceptions.PicPayException;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(value = PicPayException.class)
    public ProblemDetail handlePicPayException(PicPayException picPayException) {
        return picPayException.toProblemDetail();
    }
}