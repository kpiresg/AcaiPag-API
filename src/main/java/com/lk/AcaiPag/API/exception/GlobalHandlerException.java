package com.lk.AcaiPag.API.exception;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@RestControllerAdvice
public class GlobalHandlerException {

  @ExceptionHandler(NoResourceFoundException.class)
  public ResponseEntity<String> handleNoResourceFoundException(NoResourceFoundException ex) {
    String message = "404 NOT FOUND - Endpoint não encontrado\nVerifique a URL";
    return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(ContaNotFoundException.class)
  public ResponseEntity<String> handlerContaNotFound(ContaNotFoundException e) {
    String mensagem = e.getMessage();
    return new ResponseEntity<>(mensagem, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<Map<String, String>> handlerDadosVazio(MethodArgumentNotValidException e) {
    Map<String, String> erros = new HashMap<>();

    e.getBindingResult().getFieldErrors().forEach(erro -> {
      erros.put(erro.getField(), erro.getDefaultMessage());
    });

    return new ResponseEntity<>(erros, HttpStatus.BAD_REQUEST);
  }
}
