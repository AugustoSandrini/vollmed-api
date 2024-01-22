package med.voll.api.paciente;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.endereco.Endereco;

@Table(name = "pacientes")
@Entity(name = "Paciente")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Paciente {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String cpf;
    @Embedded
    private Endereco endereco;

    private Boolean ativo;

    public Paciente(DadosCadastroPaciente dados) {
        this.ativo = true;
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.cpf = dados.cpf();
        this.endereco = new Endereco(dados.endereco());
    }

    public void atualizarInformacoes(DadosAtualizacaoPacientes dadosAtualizacaoPacientes) {

        this.nome = atualizaPropriedade(dadosAtualizacaoPacientes.nome(), this.nome);
        this.telefone = atualizaPropriedade(dadosAtualizacaoPacientes.telefone(), this.telefone);

        if(dadosAtualizacaoPacientes.endereco() != null) {
            if(this.endereco == null) {
                this.endereco = new Endereco();
            }
            this.endereco.atualizarInformacoes(dadosAtualizacaoPacientes.endereco());
        }
    }

    private String atualizaPropriedade(String novoValor, String valorAntigo) {
        return (novoValor != null) ? novoValor : valorAntigo;
    }

    public void excluir() {
        this.ativo = false;
    }
}
