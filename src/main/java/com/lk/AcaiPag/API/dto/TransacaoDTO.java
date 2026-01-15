package com.lk.AcaiPag.API.dto;

import com.lk.AcaiPag.API.model.Conta;
import com.lk.AcaiPag.API.model.Transacao;
import jakarta.persistence.ManyToOne;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class TransacaoDTO {
  private Long idOrigem;
  private String titularOrigem;
  private Long idDestino;
  private String titularDestino;
  private BigDecimal valor;

  public TransacaoDTO(Transacao transacao) {
    this.idOrigem = transacao.getContaOrigem().getId();
    this.titularOrigem = transacao.getContaOrigem().getTitular();
    this.idDestino = transacao.getContaDestino().getId();
    this.titularDestino = transacao.getContaDestino().getTitular();
    this.valor = transacao.getValor();
  }

}
