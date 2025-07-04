package edu.ifam.dad.aplicacao_spring_boot_2025.service;

import edu.ifam.dad.aplicacao_spring_boot_2025.model.Evolucao;
import edu.ifam.dad.aplicacao_spring_boot_2025.repository.EvolucaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvolucaoService {

    private final EvolucaoRepository evolucaoRepository;


    public EvolucaoService(EvolucaoRepository evolucaoRepository) {
        this.evolucaoRepository = evolucaoRepository;
    }

    public List<Evolucao> listarTodos(){
        return evolucaoRepository.findAll();
    }
}
