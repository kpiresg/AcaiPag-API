package com.lk.AcaiPag.API.service;

import com.lk.AcaiPag.API.model.Conta;
import com.lk.AcaiPag.API.repository.ContaRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class ContaService {

  @Autowired
  private ContaRepository contaRepository;

  public Conta addConta(Conta conta) {
    return contaRepository.save(conta);
  }

  public Conta getContaById(Long id) {
    return contaRepository.findById(id).get();
  }

  public Conta updateConta(Conta conta) {
    return contaRepository.save(conta);
  }

  public void deleteContaById(Long id) {
    contaRepository.deleteById(id);
  }


}
