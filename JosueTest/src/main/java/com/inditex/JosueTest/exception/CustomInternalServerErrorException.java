package com.inditex.JosueTest.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomInternalServerErrorException extends RuntimeException{
    HttpStatus status;
    private String code;
    private String level;
    private String msg;
    @Autowired
    private MessageSource messageSource;

    public CustomInternalServerErrorException(String errorName){
        super(errorName);
        this.status = HttpStatus.INTERNAL_SERVER_ERROR;
    }

    public  CustomInternalServerErrorException(String code,String level,String msg){
        this.status = HttpStatus.INTERNAL_SERVER_ERROR;
        this.code = code;
        this.level = level;
        this.msg = msg;
    }
}
