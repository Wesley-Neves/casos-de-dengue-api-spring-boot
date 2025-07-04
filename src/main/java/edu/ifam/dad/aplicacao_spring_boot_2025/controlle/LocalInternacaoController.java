package edu.ifam.dad.aplicacao_spring_boot_2025.controlle;

import edu.ifam.dad.aplicacao_spring_boot_2025.model.LocalInternacao;
import edu.ifam.dad.aplicacao_spring_boot_2025.repository.LocalInternacaoRepository;
import edu.ifam.dad.aplicacao_spring_boot_2025.service.LocalInternacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/localinternacao")
@CrossOrigin(origins = "*")
public class LocalInternacaoController {

    @Autowired
    private final LocalInternacaoRepository localInternacaoRepository;

    private final LocalInternacaoService localInternacaoService;

    public LocalInternacaoController(LocalInternacaoRepository localInternacaoRepository, LocalInternacaoService localInternacaoService) {
        this.localInternacaoRepository = localInternacaoRepository;
        this.localInternacaoService = localInternacaoService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<LocalInternacao>> listarTodos(){
        List<LocalInternacao> localInternacoes = localInternacaoRepository.findAll();
        if (!localInternacoes.isEmpty()){
            return new ResponseEntity<>(localInternacoes, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
