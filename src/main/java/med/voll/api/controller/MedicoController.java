package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<Object> cadastrarMedico(@RequestBody @Valid DadosCadastroMedicos dadosCadastroMedicos, UriComponentsBuilder uriBuilder){
        var medico = new Medico(dadosCadastroMedicos);
        medicoRepository.save(medico);

        var uri = uriBuilder.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoMedico(medico));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemMedicos>> listarMedicos(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
       var page = medicoRepository.findAllByAtivoTrue(paginacao).map(DadosListagemMedicos::new);

       return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<Object> atulizarMedico(@RequestBody @Valid DadosAtualizacaoMedicos dadosAtualizacaoMedicos){
        var medico = medicoRepository.getReferenceById(dadosAtualizacaoMedicos.id());
        medico.atualizarInformacoes(dadosAtualizacaoMedicos);

        return ResponseEntity.ok(new DadosDetalhamentoMedico(medico));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Object> excluirMedico(@PathVariable Long id){
        var medico = medicoRepository.getReferenceById(id);
        medico.excluir();

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> detalharMedico(@PathVariable Long id){
        var medico = medicoRepository.getReferenceById(id);

        return ResponseEntity.ok(new DadosDetalhamentoMedico(medico));
    }
}
