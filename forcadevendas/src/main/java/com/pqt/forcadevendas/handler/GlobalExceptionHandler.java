package com.pqt.forcadevendas.handler;

import java.security.AccessControlException;

import javax.ws.rs.NotFoundException;

import org.hibernate.exception.ConstraintViolationException;
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
        return new JsonApiError("Erro inesperado", ex.getMessage());
    }
	
	@ExceptionHandler
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ResponseBody
    JsonApiError handleException(BadCredentialsException ex) {
        return new JsonApiError("Credenciais informadas são inválidas.", ex.getMessage());
    }
	
	@ExceptionHandler
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ResponseBody
    JsonApiError handleException(HttpMessageNotReadableException ex) {
        return new JsonApiError("O conteúdo da requisição é inválido. Revise os dados fornecidos.", ex.getMessage());
    }
	
	JsonApiError handleException(AccessControlException ex){
		return new JsonApiError("Acesso negado para o recurso.", ex.getMessage());
	}
	
	@ExceptionHandler
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    @ResponseBody
    JsonApiError handleException(ConstraintViolationException ex) {
        return new JsonApiError("O conteúdo da requisição é inválido. Revise os dados fornecidos.", ex.getSQLException().getMessage());
    }
	
	@ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    JsonApiError handleException(NotFoundException ex) {
        return new JsonApiError("Recurso não encontrado.", ex.getMessage());
    }
}
