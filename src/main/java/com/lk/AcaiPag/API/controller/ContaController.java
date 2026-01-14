package com.lk.AcaiPag.API.controller;

import com.lk.AcaiPag.API.model.Conta;
import com.lk.AcaiPag.API.service.ContaService;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
  public Conta addConta(@RequestBody Conta conta) {
    return contaService.addConta(conta);
  }

  @GetMapping("/get/{id}")
  public Conta getContaById(@PathVariable Long id) {
    return contaService.getContaById(id);
  }

  @GetMapping("/getAll")
  public List getAll() {
    return contaService.getAll();
  }

  @PatchMapping("/updateSaldo/{id}")
  public Conta updateConta(@PathVariable Long id, @RequestBody BigDecimal novoValor) {
    return contaService.updateValor(id, novoValor);
  }

  @DeleteMapping("/delete/{id}")
  public void deleteContaById(@PathVariable Long id) {
    contaService.deleteContaById(id);
  }

}
