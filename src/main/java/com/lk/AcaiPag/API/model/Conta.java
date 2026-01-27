package com.lk.AcaiPag.API.model;

import com.lk.AcaiPag.API.dto.ContaDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_conta")
@Getter
@Setter
@NoArgsConstructor
public class Conta {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String titular;

  private BigDecimal valor;

  private String senha;

  public Conta(ContaDTO contaDTO) {
    this.titular = contaDTO.getTitular();
    this.valor = contaDTO.getValor();
    this.senha = contaDTO.getSenha();
  }

  public Conta(Long id, String titular, BigDecimal valor, String senha) {
    this.id = id;
    this.senha = senha;
    this.titular = titular;
    this.valor = valor;
  }
}
