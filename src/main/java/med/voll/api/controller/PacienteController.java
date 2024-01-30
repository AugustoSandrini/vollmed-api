package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.domain.paciente.DadosListagemPacientes;
import med.voll.api.domain.paciente.Paciente;
import med.voll.api.domain.paciente.PacienteRepository;
import med.voll.api.domain.paciente.*;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository pacienteRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<Object> cadastrarPaciente(@RequestBody @Valid DadosCadastroPaciente dadosCadastroPaciente, UriComponentsBuilder uriBuilder){
        Paciente paciente = new Paciente(dadosCadastroPaciente);
        pacienteRepository.save(paciente);

        URI uri = uriBuilder.path("/pacientes/{id}").buildAndExpand(paciente.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoPaciente(paciente));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemPacientes>> listarPacientes(@PageableDefault(size = 10, sort = {"nome"})Pageable paginacao){
        var page = pacienteRepository.findAllByAtivoTrue(paginacao).map(DadosListagemPacientes::new);

        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<Object> atualizarPaciente(@RequestBody @Valid DadosAtualizacaoPacientes dadosAtualizacaoPacientes){
        var paciente = pacienteRepository.getReferenceById(dadosAtualizacaoPacientes.id());
        paciente.atualizarInformacoes(dadosAtualizacaoPacientes);

        return ResponseEntity.ok(new DadosDetalhamentoPaciente(paciente));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Object> excluirPaciente(@PathVariable Long id) {
        var paciente = pacienteRepository.getReferenceById(id);
        paciente.excluir();

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> detalharPaciente(@PathVariable Long id) {
        var paciente = pacienteRepository.getReferenceById(id);

        return ResponseEntity.ok(new DadosDetalhamentoPaciente(paciente));
    }
}
