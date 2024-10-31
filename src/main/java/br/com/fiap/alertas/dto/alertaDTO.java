package br.com.fiap.alertas.dto;


import br.com.fiap.alertas.model.StatusAlerta;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class alertaDTO {

    private Long idAlerta;

    @NotNull(message = "Número do alerta não pode ser nulo")
    @Min(value = 0, message = "Número do alerta deve ser um número inteiro positivo")
    private Long numeroAlerta;

    @NotNull(message = "Nome do alerta não pode ser nulo")
    @Size(max = 25, message = "Nome do alerta deve ter no máximo 25 caracteres")
    private String localAlerta;

    @NotNull(message = "Status de Alerta não pode ser nulo")
    private StatusAlerta statusAlerta;

    @NotNull(message = "Data de alerta não pode ser nula")
    private LocalDate dataAlerta;

}
