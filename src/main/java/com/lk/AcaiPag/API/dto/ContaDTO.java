package com.lk.AcaiPag.API.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.lk.AcaiPag.API.model.Conta;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ContaDTO {

  private Long id;
  private String titular;
  private BigDecimal valor;

  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private String senha;

  public ContaDTO(Conta conta) {
    this.id = conta.getId();
    this.titular = conta.getTitular();
    this.valor = conta.getValor();
    this.senha = conta.getSenha();
  }

}
