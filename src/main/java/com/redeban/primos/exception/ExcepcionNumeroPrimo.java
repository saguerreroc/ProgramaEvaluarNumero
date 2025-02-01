package com.redeban.primos.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ExcepcionNumeroPrimo extends RuntimeException{

    private static final long serialVersionUID = -5778897315177742714L;

    private final String code;

    private final HttpStatus codeHttp;

    public ExcepcionNumeroPrimo(String code, HttpStatus codeHttp, String message) {
        super(message);
        this.code = code;
        this.codeHttp = codeHttp;
    }
}
