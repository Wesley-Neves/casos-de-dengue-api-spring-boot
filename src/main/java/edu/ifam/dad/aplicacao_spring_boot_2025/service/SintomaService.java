package edu.ifam.dad.aplicacao_spring_boot_2025.service;

import edu.ifam.dad.aplicacao_spring_boot_2025.model.Sintoma;
import edu.ifam.dad.aplicacao_spring_boot_2025.repository.SintomaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SintomaService {

    private final SintomaRepository sintomaRepository;

    public SintomaService(SintomaRepository sintomaRepository){
        this.sintomaRepository = sintomaRepository;
    }

    public List<Sintoma> listarTodos(){
        return sintomaRepository.findAll();
    }
}
