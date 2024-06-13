package models;

import com.api.controlerepublica.requestdto.TarefaRequestDTO;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode

@Entity
@Table(name = "db_tarefas")
public class Tarefas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tarefa", nullable = false, unique = true, updatable = false)
    private long idTarefa;

    @Column(name = "titulo_tarefa", nullable = false)
    private String tituloTarefa;
    @Column(name = "data_realizacao", nullable = false)
    private LocalDate dataRealizacao;
    @Column(name = "status", nullable = false)
    private boolean status;
    @Column(name = "descricao_tarefa", nullable = false)
    private String descricaoTarefa;

    @ManyToOne
    @JoinColumn(name = "pessoa_id", referencedColumnName = "id_pessoa")
    private Pessoa pessoa;

    /*Construtor para enviar uma requisição */
    public Tarefas(TarefaRequestDTO data) {
        this.tituloTarefa = data.tituloTarefa();
        this.dataRealizacao = data.dataRealizacao();
        this.status = data.status();
        this.descricaoTarefa = data.descricaoTarefa();
        this.pessoa = data.pessoa();
    }
}
