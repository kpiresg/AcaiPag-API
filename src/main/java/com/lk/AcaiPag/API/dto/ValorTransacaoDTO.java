package com.lk.AcaiPag.API.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.math.BigDecimal;

public class ValorTransacaoDTO {

  @NotNull
  @Positive
  private BigDecimal valor;

}
