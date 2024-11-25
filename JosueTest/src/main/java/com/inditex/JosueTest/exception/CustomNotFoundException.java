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
public class CustomNotFoundException extends RuntimeException{
    private HttpStatus status;
    private String code;
    private String level;
    private String msg;



    @Autowired
    private MessageSource messageSource;

    public  CustomNotFoundException(String errorName){
        super(errorName);
        this.status = HttpStatus.NOT_FOUND;
    }

    public  CustomNotFoundException(String code,String level,String msg){
        this.status = HttpStatus.NOT_FOUND;
        this.code = code;
        this.level = level;
        this.msg = msg;
    }
}
