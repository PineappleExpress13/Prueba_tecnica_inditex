package com.inditex.JosueTest.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @Autowired
    private MessageSource messageSource;

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<MissingParameterException> handleMissingServletRequestParameterException(MissingServletRequestParameterException ex) {
        String paramName = ex.getParameterName();
        String errorCode = messageSource.getMessage("PRICES-F-001.code",new Object[]{},null);
        String errorLvl = messageSource.getMessage("PRICES-F-001.level",new Object[]{},null);
        String errorMsg = messageSource.getMessage("PRICES-F-001.desc",new Object[]{paramName},null);
        MissingParameterException exception = new MissingParameterException(errorCode,errorLvl,errorMsg);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception);
    }

    @ExceptionHandler(CustomNotFoundException.class)
    public ResponseEntity<MissingParameterException> handleCustomNotFoundException(CustomNotFoundException ex) {
        String errorCode = messageSource.getMessage(ex.getMessage()+".code",new Object[]{},null);
        String errorLvl = messageSource.getMessage(ex.getMessage()+".level",new Object[]{},null);
        String errorMsg = messageSource.getMessage(ex.getMessage()+".desc",new Object[]{},null);
        MissingParameterException exception =  new MissingParameterException(errorCode,errorLvl,errorMsg);
        return ResponseEntity.status(((CustomNotFoundException) ex).getStatus()).body(exception);
    }

    @ExceptionHandler(CustomInternalServerErrorException.class)
    public ResponseEntity<CustomInternalServerErrorException> handleCustomInternalServerErrorException(CustomInternalServerErrorException ex) {
        String errorCode = messageSource.getMessage(ex.getMessage()+".code",new Object[]{},null);
        String errorLvl = messageSource.getMessage(ex.getMessage()+".level",new Object[]{},null);
        String errorMsg = messageSource.getMessage(ex.getMessage()+".desc",new Object[]{},null);
        CustomInternalServerErrorException exception = new CustomInternalServerErrorException(errorCode,errorLvl,errorMsg);
        return ResponseEntity.status(((CustomInternalServerErrorException) ex).getStatus()).body(exception);
    }
}