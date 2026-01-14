package com.lk.AcaiPag.API.model;

import jakarta.persistence.Entity;
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

  @ManyToOne
  private Conta contaOrigem;

  @ManyToOne
  private Conta contaDestino;

  private BigDecimal valor;



}
