package edu.ifam.dad.aplicacao_spring_boot_2025.service;

import edu.ifam.dad.aplicacao_spring_boot_2025.model.LocalInternacao;
import edu.ifam.dad.aplicacao_spring_boot_2025.repository.LocalInternacaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocalInternacaoService {

    private final LocalInternacaoRepository localInternacaoRepository;


    public LocalInternacaoService(LocalInternacaoRepository localInternacaoRepository) {
        this.localInternacaoRepository = localInternacaoRepository;
    }

    public List<LocalInternacao> listarTodos(){
        return localInternacaoRepository.findAll();
    }
}
