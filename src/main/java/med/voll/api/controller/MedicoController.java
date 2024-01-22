package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.medico.DadosCadastroMedicos;
import med.voll.api.medico.DadosListagemMedicos;
import med.voll.api.medico.Medico;
import med.voll.api.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroMedicos dados){
        repository.save(new Medico(dados));
    }

    @GetMapping
    public List<DadosListagemMedicos> listar(){
        //convertendo o retorno de uma lista de medicos para uma lista de DadosListagemMedicos
        return repository.findAll().stream().map(DadosListagemMedicos::new).toList();
    }
}
