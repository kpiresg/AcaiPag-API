package com.lk.AcaiPag.API.controller;

import com.lk.AcaiPag.API.dto.TransacaoDTO;
import com.lk.AcaiPag.API.service.TransacaoService;
import jakarta.validation.Valid;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {

  private TransacaoService transacaoService;

  @Autowired
  public TransacaoController(TransacaoService transacaoService) {
    this.transacaoService = transacaoService;
  }

  @PostMapping("/realizarTransacao/{idOrigem}/{idDestino}")
  public ResponseEntity<TransacaoDTO> realizarTransacao(
      @PathVariable Long idOrigem,
      @PathVariable Long idDestino,
      @RequestBody @Valid TransacaoDTO valor) {
    BigDecimal valorFinal = valor.getValor();
    TransacaoDTO transacaoDto = transacaoService.realizarTransacao(idOrigem, idDestino, valorFinal);
    return new ResponseEntity<>(transacaoDto, HttpStatus.OK);
  }

  @GetMapping("/consultarTransacao/{id}")
  public ResponseEntity<TransacaoDTO> consultarTransacao(@PathVariable Long id) {
    TransacaoDTO transacaoDTO = transacaoService.consultarTransacao(id);
    return new ResponseEntity<>(transacaoDTO, HttpStatus.OK);
  }
}
