package com.lk.AcaiPag.API.service;

import com.lk.AcaiPag.API.dto.ContaDTO;
import com.lk.AcaiPag.API.model.Conta;
import com.lk.AcaiPag.API.repository.ContaRepository;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ContaService {

  @Autowired
  private ContaRepository contaRepository;

  @Transactional
  public ContaDTO addConta(ContaDTO contaDto) {
    Conta novaConta = new Conta(contaDto);
    Conta contaSalva = contaRepository.save(novaConta);

    return new ContaDTO(contaSalva);
  }

  public ContaDTO getContaById(Long id) {
    Conta conta = this.contaRepository.findById(id).get();
    ContaDTO contaDTO = new ContaDTO(conta);
    return contaDTO;
  }

  public List<ContaDTO> getAll() {
    List <ContaDTO> contaDTOList = new ArrayList<>();
    for(Conta conta : this.contaRepository.findAll()) {
      ContaDTO contaDTO = new ContaDTO(conta);
      contaDTOList.add(contaDTO);
    }
    return contaDTOList;
  }

  @Transactional
  public ContaDTO updateValor(Long id, BigDecimal novoValor) {
    Conta conta = contaRepository.findById(id).get();
    conta.setValor(novoValor);
    contaRepository.save(conta);

    return new ContaDTO(conta);
  }

  @Transactional
  public void deleteContaById(Long id) {
    contaRepository.deleteById(id);
  }


}
