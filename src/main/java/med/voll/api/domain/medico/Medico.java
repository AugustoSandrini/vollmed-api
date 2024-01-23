package med.voll.api.domain.medico;

import jakarta.persistence.*;
import lombok.*;
import med.voll.api.domain.endereco.Endereco;

@Table(name = "medicos")
@Entity(name = "Medico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String crm;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded
    private Endereco endereco;

    private Boolean ativo;

    public Medico(DadosCadastroMedicos dados) {
        this.ativo = true;
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.crm = dados.crm();
        this.especialidade = dados.especialidade();
        this.endereco = new Endereco(dados.endereco());
    }

    public void atualizarInformacoes(DadosAtualizacaoMedicos dadosAtualizacaoMedicos) {

        this.nome = atualizarPropriedade(dadosAtualizacaoMedicos.nome(), this.nome);
        this.telefone = atualizarPropriedade(dadosAtualizacaoMedicos.telefone(), this.telefone);

        if(dadosAtualizacaoMedicos.endereco() != null) {
            if(this.endereco == null) {
                this.endereco = new Endereco();
            }
            this.endereco.atualizarInformacoes(dadosAtualizacaoMedicos.endereco());
        }
    }

    private String atualizarPropriedade(String novoValor, String valorAntigo) {
        return (novoValor != null) ? novoValor : valorAntigo;
    }

    public void excluir() {
        this.ativo = false;
    }
}
