package br.com.fiap.alertas.service;

import br.com.fiap.alertas.dto.alertaDTO;
import br.com.fiap.alertas.dto.AlertaExibicaoDTO;
import br.com.fiap.alertas.exception.AlertaNaoEncotradoException;
import br.com.fiap.alertas.model.Alerta;
import br.com.fiap.alertas.repository.AlertaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlertaService {

    @Autowired
    private AlertaRepository alertaRepository;

    public AlertaExibicaoDTO criar(alertaDTO alertaDTO) {
        Alerta alerta = new Alerta();
        BeanUtils.copyProperties(alertaDTO, alerta);
        Alerta alertaCriada = alertaRepository.save(alerta);

        return new AlertaExibicaoDTO(alertaCriada);
    }

    public AlertaExibicaoDTO buscarPorId(Long numeroAlerta) {
        Optional<Alerta> alertaOptional = alertaRepository.findById(numeroAlerta);

        if (alertaOptional.isPresent()) {
            return new AlertaExibicaoDTO(alertaOptional.get());
        } else {
            throw new AlertaNaoEncotradoException("Alerta não encontrado!");
        }
    }

    public List<AlertaExibicaoDTO> listarTodosAlertas() {
        return alertaRepository
                .findAll()
                .stream()
                .map(AlertaExibicaoDTO::new)
                .toList();
    }

    public void excluir(Long numeroAlerta) {
        Optional<Alerta> alertaOptional = alertaRepository.findById(numeroAlerta);

        if (alertaOptional.isPresent()) {
            alertaRepository.delete(alertaOptional.get());
        } else {
            throw new RuntimeException("Alerta não encontrado!");
        }
    }

    public AlertaExibicaoDTO atualizar(alertaDTO alertaDTO) {
        Optional<Alerta> alertaOptional = alertaRepository.findById(alertaDTO.getNumeroAlerta());

        if (alertaOptional.isPresent()) {
            Alerta alerta = new Alerta();
            BeanUtils.copyProperties(alertaDTO, alerta);
            Alerta alertaAtualizada = alertaRepository.save(alerta);

            return new AlertaExibicaoDTO(alertaAtualizada);

        } else {
            throw new RuntimeException("Alerta não encontrado!");
        }
    }

}













