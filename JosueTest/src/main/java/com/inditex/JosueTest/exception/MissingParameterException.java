package com.inditex.JosueTest.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;

@Getter
@Setter
public class MissingParameterException {

    String code;
    String level;
    String msg;


    public  MissingParameterException(String code,String level,String msg){
        this.code = code;
        this.level = level;
        this.msg = msg;
    }
}
