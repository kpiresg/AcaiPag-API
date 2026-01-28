package com.lk.AcaiPag.API.exception;

public class ContaEqualsException extends RuntimeException {

  public ContaEqualsException(String message) {
    super(message);
  }

  public ContaEqualsException() {
    super("Não pode realizar uma requisição para sua própria conta.");
  }
}
