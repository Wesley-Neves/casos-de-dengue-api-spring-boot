package edu.ifam.dad.aplicacao_spring_boot_2025.controlle;


import edu.ifam.dad.aplicacao_spring_boot_2025.model.Evolucao;
import edu.ifam.dad.aplicacao_spring_boot_2025.repository.EvolucaoRepository;
import edu.ifam.dad.aplicacao_spring_boot_2025.service.EvolucaoService;
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
@RequestMapping("/api/evolucoes")
@CrossOrigin(origins = "*")
public class EvolucaoController {


    @Autowired
    private EvolucaoRepository evolucaoRepository;

    private final EvolucaoService evolucaoService;

    public EvolucaoController(EvolucaoService evolucaoService) {
        this.evolucaoService = evolucaoService;
    }


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Evolucao>> listarTodos(){
        List<Evolucao>evolucoes = evolucaoRepository.findAll();
        if (!evolucoes.isEmpty()){
            return new ResponseEntity<>(evolucoes, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
