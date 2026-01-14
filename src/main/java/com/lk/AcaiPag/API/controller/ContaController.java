package com.lk.AcaiPag.API.controller;

import com.lk.AcaiPag.API.dto.ContaDTO;
import com.lk.AcaiPag.API.dto.UpdateSaldoDTO;
import com.lk.AcaiPag.API.model.Conta;
import com.lk.AcaiPag.API.service.ContaService;
import jakarta.validation.Valid;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/conta")
public class ContaController {

  @Autowired
  private ContaService contaService;

  @PostMapping("/add")
  public ResponseEntity<ContaDTO> addConta(@RequestBody @Valid ContaDTO newContaDto) {
    ContaDTO contaDto = contaService.addConta(newContaDto);
    return new ResponseEntity<>(contaDto, HttpStatus.CREATED);
  }

  @GetMapping("/get/{id}")
  public ResponseEntity<ContaDTO> getContaById(@PathVariable Long id) {
    ContaDTO contaDto = contaService.getContaById(id);

    return new ResponseEntity<>(contaDto, HttpStatus.OK);
  }

  @GetMapping("/getAll")
  public ResponseEntity<List> getAll() {
    List<ContaDTO> listContaDto = contaService.getAll();

    return new ResponseEntity<>(listContaDto, HttpStatus.OK);
  }

  @PatchMapping("/updateSaldo/{id}")
  public ResponseEntity<ContaDTO> updateConta(@PathVariable Long id, @Valid @RequestBody UpdateSaldoDTO body) {
    BigDecimal novoValor = body.getValor();
    ContaDTO contaDto = contaService.updateValor(id, novoValor);

    return new ResponseEntity<>(contaDto, HttpStatus.OK);
  }

  @DeleteMapping("/delete/{id}")
  public void deleteContaById(@PathVariable Long id) {
    contaService.deleteContaById(id);
  }

}
