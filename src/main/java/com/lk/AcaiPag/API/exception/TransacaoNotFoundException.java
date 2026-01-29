package com.lk.AcaiPag.API.exception;

public class TransacaoNotFoundException extends RuntimeException {

  public TransacaoNotFoundException(String message) {
    super(message);
  }

  public TransacaoNotFoundException() {
    super("Transacao não encontrada.");
  }
}
