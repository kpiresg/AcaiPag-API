package com.lk.AcaiPag.API.service;

import static org.junit.jupiter.api.Assertions.*;

import com.lk.AcaiPag.API.dto.TransacaoDTO;
import com.lk.AcaiPag.API.exception.ContaEqualsException;
import com.lk.AcaiPag.API.exception.ContaNotFoundException;
import com.lk.AcaiPag.API.exception.SaldoInsuficienteException;
import com.lk.AcaiPag.API.model.Conta;
import com.lk.AcaiPag.API.model.Transacao;
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

  @Mock
  TransacaoRepository transacaoRepository;

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

  @Test
  @DisplayName("Teste atualizar valor ao realizar transacao")
  void testVerificarSeTransacaoOcorreuComSucesso() {
    Conta conta1 = new Conta(1l, "Kauan", BigDecimal.valueOf(100), "123");
    Conta conta2 = new Conta(2l, "Laura", BigDecimal.valueOf(200), "321");
    Mockito.when(contaRepository.findById(1l)).thenReturn(Optional.of(conta1));
    Mockito.when(contaRepository.findById(2l)).thenReturn(Optional.of(conta2));
    Mockito.when(transacaoRepository.save(Mockito.any(Transacao.class)))
        .thenReturn(new Transacao(
            conta1,
            conta2,
            new BigDecimal(50)));

    transacaoService.realizarTransacao(
        1l,
        2l,
        BigDecimal.valueOf(50));

    assertNotNull(conta1.getValor());
    assertEquals(BigDecimal.valueOf(50), conta1.getValor());
    assertEquals(BigDecimal.valueOf(250), conta2.getValor());
  }

  @Test
  @DisplayName("Teste verificar se gerou comprovante")
  void testVerificarSeGerouComprovante() {
    Conta conta1 = new Conta(1l, "Kauan", BigDecimal.valueOf(100), "123");
    Conta conta2 = new Conta(2l, "Laura", BigDecimal.valueOf(200), "321");
    Transacao novaTransacao = new Transacao(conta1, conta2, BigDecimal.valueOf(50));
    novaTransacao.setId(5l);

    Mockito.when(transacaoRepository.save(Mockito.any(Transacao.class))).thenReturn(novaTransacao);

    Mockito.when(contaRepository.findById(1l)).thenReturn(Optional.of(conta1));
    Mockito.when(contaRepository.findById(2l)).thenReturn(Optional.of(conta2));

    TransacaoDTO resultadoDto = transacaoService.realizarTransacao(
        1l,
        2l,
        BigDecimal.valueOf(50));

    assertEquals(BigDecimal.valueOf(50), conta1.getValor());
    assertEquals(BigDecimal.valueOf(250), conta2.getValor());

    assertNotNull(resultadoDto);
    assertEquals(novaTransacao.getId(), resultadoDto.getId());

    Mockito.verify(transacaoRepository, Mockito.times(1)).save(Mockito.any(Transacao.class));
  }

  @Test
  @DisplayName("Teste Conta origem e destino igual Exception")
  void verificarSeLancouExceptionParaMesmaConta() {
    Conta contaOrigem  = new Conta(1l, "Kauan", BigDecimal.valueOf(100), "123");
    Mockito.when(contaRepository.findById(1l)).thenReturn(Optional.of(contaOrigem));

    assertThrows(ContaEqualsException.class, () -> {
      transacaoService.realizarTransacao(1l, 1l, new BigDecimal("100"));
    });

    Mockito.verify(contaRepository,
        Mockito.times(2))
        .findById(Mockito.anyLong());
  }
}