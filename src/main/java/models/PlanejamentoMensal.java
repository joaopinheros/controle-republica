package models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode

@Entity
@Table(name = "db_planejamento_mensal")
public class PlanejamentoMensal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_planejamento", nullable = false, updatable = false, unique = true)
    private long idPlanejamento;
    @Column(name = "mes", nullable = false)
    private int mes;

    @OneToMany
    @JoinColumn(name = "tarefa_id")
    private List<Tarefas> tarefas;

    @OneToMany
    @JoinColumn(name = "despesa_id")
    private List<Despesas> despesas;

    @ManyToOne
    @JoinColumn(name = "republica_id", referencedColumnName = "id_republica")
    private Republica republica;
}
