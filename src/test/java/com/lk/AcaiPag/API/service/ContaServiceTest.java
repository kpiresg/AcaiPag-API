package com.lk.AcaiPag.API.service;

import static org.junit.jupiter.api.Assertions.*;

import com.lk.AcaiPag.API.dto.ContaDTO;
import com.lk.AcaiPag.API.model.Conta;
import com.lk.AcaiPag.API.repository.ContaRepository;
import java.math.BigDecimal;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ContaServiceTest {

  @InjectMocks
  private ContaService contaService;

  @Mock
  private ContaRepository contaRepository;

  @Test
  @DisplayName("Teste se esta criando conta")
  void testVerificarSeEstaCriandoConta() {
    ContaDTO contaDTO = new ContaDTO(
        "Kauan",
        BigDecimal.valueOf(100),
        "123");

    Conta conta = new Conta(contaDTO);
    conta.setId(1l);

    Mockito.when(contaRepository.save(Mockito.any(Conta.class))).thenReturn(conta);
    ContaDTO resultado = contaService.addConta(contaDTO);

    assertNotNull(resultado);
    assertEquals(1l, resultado.getId());
    assertEquals("Kauan", resultado.getTitular());
    Mockito.verify(contaRepository, Mockito.times(1)).save(Mockito.any(Conta.class));
  }

  @Test
  @DisplayName("Teste achar conta pelo id")
  void testVerificarContaPeloId() {
    Conta conta = new Conta(
        1l,
        "Kauan",
        BigDecimal.valueOf(10),
        "123");

    Mockito.when(contaRepository.findById(Mockito.anyLong()))
        .thenReturn(Optional.of(conta));

    ContaDTO contaDTO = contaService.getContaById(1l);

    assertNotNull(contaDTO);
    assertEquals(1l, contaDTO.getId());
    Mockito.verify(contaRepository, Mockito.times(1)).findById(Mockito.anyLong());

  }
}