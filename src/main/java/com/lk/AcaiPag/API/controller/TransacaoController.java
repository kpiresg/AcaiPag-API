package com.lk.AcaiPag.API.controller;

import com.lk.AcaiPag.API.dto.TransacaoDTO;
import com.lk.AcaiPag.API.model.Transacao;
import com.lk.AcaiPag.API.repository.TransacaoRepository;
import com.lk.AcaiPag.API.service.TransacaoService;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {

  @Autowired
  private TransacaoService transacaoService;

  @PostMapping("/realizarTransacao/{idOrigem}/{idDestino}/{valor}")
  public ResponseEntity<TransacaoDTO> realizarTransacao(
      @PathVariable Long idOrigem,
      @PathVariable Long idDestino,
      @PathVariable BigDecimal valor) {
    TransacaoDTO transacaoDto = transacaoService.realizarTransacao(idOrigem, idDestino, valor);
    return new ResponseEntity<>(transacaoDto, HttpStatus.OK);
  }
}
