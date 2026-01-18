package com.lk.AcaiPag.API.service;

import static org.junit.jupiter.api.Assertions.*;

import com.lk.AcaiPag.API.exception.ContaNotFoundException;
import com.lk.AcaiPag.API.exception.SaldoInsuficienteException;
import com.lk.AcaiPag.API.model.Conta;
import com.lk.AcaiPag.API.repository.ContaRepository;
import com.lk.AcaiPag.API.repository.TransacaoRepository;
import java.math.BigDecimal;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class TransacaoServiceTest {

  @InjectMocks
  TransacaoService transacaoService;

  @Mock
  ContaRepository contaRepository;

  @Test
  @DisplayName("Teste de Conta nao Encontrada")
  void testeDeContaNaoEncontradaException() {
    Mockito.when(contaRepository.findById(Mockito.anyLong())).thenReturn(Optional.empty());
    assertThrows(ContaNotFoundException.class,
        () -> transacaoService.realizarTransacao(
            1l,
            2l,
            BigDecimal.valueOf(10)));
  }

  @Test
  @DisplayName("Teste de Saldo Insuficiente")
  void testeDeSaldoInsuficienteException() {

    Mockito.when(contaRepository.findById(Mockito.anyLong()))
        .thenReturn(Optional.of(
        new Conta(
            1l,
            "kauan",
            BigDecimal.valueOf(1),
            "123")));

    assertThrows(SaldoInsuficienteException.class,
        () ->  transacaoService.realizarTransacao(
            1l,
            2l,
            BigDecimal.valueOf(2)));
  }

}