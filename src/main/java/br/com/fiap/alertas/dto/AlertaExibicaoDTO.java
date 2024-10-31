package br.com.fiap.alertas.dto;

import br.com.fiap.alertas.model.Alerta;
import br.com.fiap.alertas.model.StatusAlerta;

import java.time.LocalDate;

public record AlertaExibicaoDTO(
        Long idAlerta,
        Long numeroAlerta,
        String localAlerta,
        StatusAlerta statusAlerta,
        LocalDate dataAlerta
) {
    public AlertaExibicaoDTO(Alerta alerta) {
        this(
                alerta.getIdAlerta(),
                alerta.getNumeroAlerta(),
                alerta.getLocalAlerta(),
                alerta.getStatusAlerta(),
                alerta.getDataAlerta()
        );
    }
}
