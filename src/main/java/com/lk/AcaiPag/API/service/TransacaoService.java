package com.lk.AcaiPag.API.service;

import com.lk.AcaiPag.API.dto.TransacaoDTO;
import com.lk.AcaiPag.API.exception.ContaNotFoundException;
import com.lk.AcaiPag.API.exception.SaldoInsuficienteException;
import com.lk.AcaiPag.API.model.Conta;
import com.lk.AcaiPag.API.model.Transacao;
import com.lk.AcaiPag.API.repository.ContaRepository;
import com.lk.AcaiPag.API.repository.TransacaoRepository;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransacaoService {

  private final TransacaoRepository transacaoRepository;

  private final ContaRepository contaRepository;

  @Autowired
  public TransacaoService(TransacaoRepository transacaoRepository, ContaRepository contaRepository) {
    this.transacaoRepository = transacaoRepository;
    this.contaRepository = contaRepository;
  }

  @Transactional
  public TransacaoDTO realizarTransacao(Long idOrigem, Long idDestino, BigDecimal valor) {
    Conta contaOrigem = contaRepository.findById(idOrigem)
        .orElseThrow(() -> new ContaNotFoundException("Conta de Origem não encontrada"));

    Conta contaDestino = contaRepository.findById(idDestino)
        .orElseThrow(() -> new ContaNotFoundException("Conta de Destino não encontrada"));

    if (valor.compareTo(contaOrigem.getValor()) > 0) {
      throw new SaldoInsuficienteException();
    } else {
      contaOrigem.setValor(contaOrigem.getValor().subtract(valor));
      contaDestino.setValor(contaDestino.getValor().add(valor));

      Transacao transacao = new Transacao(contaOrigem, contaDestino, valor);
      Transacao transacaoSalva = transacaoRepository.save(transacao);
      TransacaoDTO transacaoDto = new TransacaoDTO(transacaoSalva);
      return transacaoDto;
    }
  }

}
