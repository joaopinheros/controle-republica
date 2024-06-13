package models;

import com.api.controlerepublica.requestdto.DespesasRequestDTO;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode

@Entity
@Table(name = "db_despesas")
public class Despesas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_despesa", nullable = false, unique = true, updatable = false)
    private long idDespesa;

    @Column(name = "titulo_despesa", nullable = false)
    private String tituloDespesa;
    @Column(name = "valor", nullable = false)
    private double valor;
    @Column(name = "prazo_vencimento", nullable = false)
    private LocalDate prazoVencimento;
    @Column(name = "status", nullable = false)
    private boolean status;

    @ManyToOne
    @JoinColumn(name = "pessoa_id", referencedColumnName = "id_pessoa")
    private Pessoa pessoa;

    public Despesas(DespesasRequestDTO data) {
        this.tituloDespesa = data.tituloDespesa();
        this.valor = data.valor();
        this.prazoVencimento = data.prazoVencimento();
        this.status = data.status();
        this.pessoa = data.pessoa();
    }
}
