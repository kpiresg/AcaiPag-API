package com.lk.AcaiPag.API.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateSaldoDTO {

  @NotNull
  @PositiveOrZero
  private BigDecimal valor;

}
