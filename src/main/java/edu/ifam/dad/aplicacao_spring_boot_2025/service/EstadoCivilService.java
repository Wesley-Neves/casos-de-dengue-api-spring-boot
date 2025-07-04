package edu.ifam.dad.aplicacao_spring_boot_2025.service;

import edu.ifam.dad.aplicacao_spring_boot_2025.model.EstadoCivil;
import edu.ifam.dad.aplicacao_spring_boot_2025.repository.EstadoCivilRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoCivilService {

    private final EstadoCivilRepository estadoCivilRepository;

    public EstadoCivilService(EstadoCivilRepository estadoCivilRepository) {
        this.estadoCivilRepository = estadoCivilRepository;
    }

    public List<EstadoCivil> listarTodos(){
        return estadoCivilRepository.findAll();
    }
}
