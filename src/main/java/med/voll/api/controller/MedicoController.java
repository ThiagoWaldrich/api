package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.medico.DadosCadastroMedico;
import med.voll.api.medico.DadosListagemMedico;
import med.voll.api.medico.Medico;
import med.voll.api.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;


    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados){
        medicoRepository.save(new Medico(dados));
    }

    @GetMapping
    public Page<DadosListagemMedico> listar(@PageableDefault(page = 0, size = 10, sort = {"nome"}) Pageable paginacao){
        return medicoRepository.findAll(paginacao).map(DadosListagemMedico::new);
        //crie o construtor para DadosListagemMedico
        //http://localhost:8080/medicos?size=1 requisição para retornar apenas o primeiro registro
        // http://localhost:8080/medicos?size=1&page=1 requisição para retornar a pagina 0, 1, 2, 3 ...

    }
}
