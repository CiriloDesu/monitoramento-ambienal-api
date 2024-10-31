package br.com.fiap.alertas.controller;

import br.com.fiap.alertas.dto.alertaDTO;
import br.com.fiap.alertas.dto.AlertaExibicaoDTO;
import br.com.fiap.alertas.dto.ErrorResponseDto;
import br.com.fiap.alertas.service.AlertaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/alertas")
public class AlertaController {

    @Autowired
    private AlertaService service;

    @GetMapping("/up")
    public String healthCheck() {
        return "O serviço está UP!";
    }

    @PostMapping
    public ResponseEntity<?> criar(@RequestBody @Valid alertaDTO alertaDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String errorMessage = bindingResult.getAllErrors().stream()
                    .map(error -> {
                        return error.getDefaultMessage();
                    })
                    .collect(Collectors.joining("; "));

            return ResponseEntity.badRequest().body(new ErrorResponseDto(errorMessage));
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(alertaDTO));
    }

    @GetMapping("{idAlerta}")
    public ResponseEntity<AlertaExibicaoDTO> buscarPorId(@PathVariable Long idAlerta){
        return ResponseEntity.ok(service.buscarPorId(idAlerta));
    }

    @GetMapping
    public ResponseEntity<List<AlertaExibicaoDTO>> listarTodosAlertas(){
        return ResponseEntity.ok(service.listarTodosAlertas());
    }

    @DeleteMapping("{idAlerta}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long idAlerta){
        service.excluir(idAlerta);
    }

    @PutMapping
    public AlertaExibicaoDTO atualizar(@RequestBody alertaDTO alertaDTO){
        return service.atualizar(alertaDTO);
    }

}
