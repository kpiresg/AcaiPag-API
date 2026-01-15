package com.lk.AcaiPag.API.exception;

public class SaldoInsuficienteException extends RuntimeException {

  public SaldoInsuficienteException(String message) {
    super(message);
  }

  public SaldoInsuficienteException() {
    super("Saldo insuficiente");
  }
}
