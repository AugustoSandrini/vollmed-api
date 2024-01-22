package med.voll.api.endereco;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.function.Supplier;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

    private String logradouro;
    private String bairro;
    private String cep;
    private String numero;
    private String complemento;
    private String cidade;
    private String uf;

    public Endereco(DadosEndereco dados) {
        this.logradouro = dados.logradouro();
        this.bairro = dados.bairro();
        this.cep = dados.cep();
        this.numero = dados.numero();
        this.complemento = dados.complemento();
        this.cidade = dados.cidade();
        this.uf = dados.uf();
    }

    public void atualizarInformacoes(DadosEndereco dadosEndereco) {
        atualizarPropriedadeEndereco(dadosEndereco::logradouro, () -> this.logradouro = dadosEndereco.logradouro());
        atualizarPropriedadeEndereco(dadosEndereco::bairro, () -> this.bairro = dadosEndereco.bairro());
        atualizarPropriedadeEndereco(dadosEndereco::cep, ()-> this.cep = dadosEndereco.cep());
        atualizarPropriedadeEndereco(dadosEndereco::numero, () -> this.numero = dadosEndereco.numero());
        atualizarPropriedadeEndereco(dadosEndereco::complemento, () -> this.complemento = dadosEndereco.complemento());
        atualizarPropriedadeEndereco(dadosEndereco::cidade, () ->  this.cidade = dadosEndereco.cidade());
        atualizarPropriedadeEndereco(dadosEndereco::uf, () -> this.uf = dadosEndereco.uf());
    }

    private void atualizarPropriedadeEndereco(Supplier<String> getter, Runnable setter){
        String valor = getter.get();
        if (valor != null) {
            setter.run();
        }
    }
}
