package com.lk.AcaiPag.API.exception;

public class ContaNotFoundException extends RuntimeException {

  public ContaNotFoundException(String message) {
    super(message);
  }

  public ContaNotFoundException() {
    super("Nenhuma conta foi encontrada!");
  }
}
