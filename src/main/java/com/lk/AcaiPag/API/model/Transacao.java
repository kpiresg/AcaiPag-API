package com.lk.AcaiPag.API.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_transacao")
@Getter
@Setter
@NoArgsConstructor
public class Transacao {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  private Conta contaOrigem;

  @ManyToOne
  private Conta contaDestino;

  private BigDecimal valor;

  public Transacao(Conta contaOrigem, Conta contaDestino, BigDecimal valor) {}

}
