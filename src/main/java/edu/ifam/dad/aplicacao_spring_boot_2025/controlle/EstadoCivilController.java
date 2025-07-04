package edu.ifam.dad.aplicacao_spring_boot_2025.controlle;


import edu.ifam.dad.aplicacao_spring_boot_2025.model.EstadoCivil;
import edu.ifam.dad.aplicacao_spring_boot_2025.repository.EstadoCivilRepository;
import edu.ifam.dad.aplicacao_spring_boot_2025.service.EstadoCivilService;
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
@RequestMapping("/api/estadocivil")
@CrossOrigin(origins = "*")
public class EstadoCivilController {

    @Autowired
    private final EstadoCivilRepository estadoCivilRepository;

    private final EstadoCivilService estadoCivilService;

    public EstadoCivilController(EstadoCivilRepository estadoCivilRepository, EstadoCivilService estadoCivilService) {
        this.estadoCivilRepository = estadoCivilRepository;
        this.estadoCivilService = estadoCivilService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EstadoCivil>> listarTodos(){
        List<EstadoCivil> estadoCivils = estadoCivilRepository.findAll();
        if (!estadoCivils.isEmpty()){
            return new ResponseEntity<>(estadoCivils, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
