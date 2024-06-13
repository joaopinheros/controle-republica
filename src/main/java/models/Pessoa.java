package models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "db_pessoa")
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pessoa", nullable = false, unique = true, updatable = false)
    private long idPessoa;

    @Column(name = "nome_pessoa", nullable = false)
    private String nomePessoa;
    @Column(name = "foto_perfil", nullable = false)
    private String fotoPerfil;

    @OneToOne(mappedBy = "pessoa", cascade = CascadeType.ALL)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "republica_id", referencedColumnName = "id_republica")
    private Republica republica;

    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Despesas> despesas;

    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Tarefas> tarefas;

    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Notificacao> notificacoes;

    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<ConviteRepublica> convites;
}
