package com.pqt.forcadevendas.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice(basePackages="com.pqt.forcadevendas")
public class GlobalExceptionHandler {

	@ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    JsonApiError handleException(Exception ex) {
        return new JsonApiError(ex.getMessage(), "Ops, um erro inesperado aconteceu. Tente novamente mais tarde");
    }
	
	@ExceptionHandler
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ResponseBody
    JsonApiError handleException(BadCredentialsException ex) {
        return new JsonApiError(ex.getMessage(), "Credenciais informadas s�o inv�lidas.");
    }
	
	@ExceptionHandler
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    @ResponseBody
    JsonApiError handleException(HttpMessageNotReadableException ex) {
        return new JsonApiError(ex.getMessage(), "O conte�do da requisi��o � inv�lido. Revise os dados fornecidos.");
    }
}
