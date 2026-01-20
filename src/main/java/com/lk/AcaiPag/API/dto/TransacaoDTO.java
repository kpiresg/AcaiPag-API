package com.lk.AcaiPag.API.dto;

import com.lk.AcaiPag.API.model.Transacao;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class TransacaoDTO {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private Long idOrigem;
  private String titularOrigem;
  private Long idDestino;
  private String titularDestino;

  @NotNull
  @PositiveOrZero
  private BigDecimal valor;

  public TransacaoDTO(Transacao transacao) {
    this.id = transacao.getId();
    this.idOrigem = transacao.getContaOrigem().getId();
    this.titularOrigem = transacao.getContaOrigem().getTitular();
    this.idDestino = transacao.getContaDestino().getId();
    this.titularDestino = transacao.getContaDestino().getTitular();
    this.valor = transacao.getValor();
  }

}
