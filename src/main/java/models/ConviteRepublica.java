package models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode

@Entity
@Table(name = "db_convite_republica")
public class ConviteRepublica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_convite", nullable = false, unique = true, updatable = false)
    private long idConvite;

    @Column(name = "mensagem_convite", nullable = false)
    private String mensagemConvite;

    @ManyToOne
    @JoinColumn(name = "republica_id", referencedColumnName = "id_republica")
    private Republica republica;

    @ManyToOne
    @JoinColumn(name = "pessoa_id", referencedColumnName = "id_pessoa")
    private Pessoa pessoa;
}
