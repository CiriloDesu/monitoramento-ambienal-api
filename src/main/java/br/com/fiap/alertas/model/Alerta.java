package br.com.fiap.alertas.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "tbl_alertas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Alerta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_alerta")
    private Long idAlerta;

    @Column(name = "numero_alerta")
    @NotNull
    @Positive
    private Long numeroAlerta;

    @Column(name = "local_alerta")
    private String localAlerta;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_alerta")
    private StatusAlerta statusAlerta;

    @Column(name = "data_alerta")
    private LocalDate dataAlerta;

}
