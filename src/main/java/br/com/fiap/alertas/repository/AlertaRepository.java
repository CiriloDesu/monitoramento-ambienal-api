package br.com.fiap.alertas.repository;

import br.com.fiap.alertas.model.Alerta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlertaRepository extends JpaRepository<Alerta, Long> {
}
