package com.lk.AcaiPag.API.dto;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ContaDTO {

  private Long id;
  private String nome;
  private BigDecimal valor;
  private String senha;

  public ContaDTO(Long id, String nome, BigDecimal valor, String senha) {
    this.id = id;
    this.nome = nome;
    this.valor = valor;
    this.senha = senha;
  }

}
