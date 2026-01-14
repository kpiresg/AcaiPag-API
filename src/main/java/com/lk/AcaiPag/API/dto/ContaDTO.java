package com.lk.AcaiPag.API.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lk.AcaiPag.API.model.Conta;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ContaDTO {

  private Long id;

  @NotBlank
  private String titular;

  @NotNull
  @PositiveOrZero
  private BigDecimal valor;

  @NotBlank
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private String senha;

  public ContaDTO(Conta conta) {
    this.id = conta.getId();
    this.titular = conta.getTitular();
    this.valor = conta.getValor();
    this.senha = conta.getSenha();
  }

}
