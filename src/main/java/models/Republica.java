package models;

import com.api.controlerepublica.requestdto.RepublicaRequestDTO;
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
@Table(name = "db_republica")
public class Republica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_republica", nullable = false, unique = true, updatable = false)
    private long idRepublica;

    @Column(name = "nome_republica", nullable = false)
    private String nomeRepublica;

    @OneToMany(mappedBy = "republica", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pessoa> pessoa;

    @OneToMany(mappedBy = "republica", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ConviteRepublica> convites;

    /*Construtor para enviar uma requisição */
    public Republica(RepublicaRequestDTO data) {
        this.nomeRepublica = data.nomeRepublica();
    }

}
