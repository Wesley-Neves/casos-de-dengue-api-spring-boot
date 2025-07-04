package edu.ifam.dad.aplicacao_spring_boot_2025.controlle;


import edu.ifam.dad.aplicacao_spring_boot_2025.model.Sintoma;
import edu.ifam.dad.aplicacao_spring_boot_2025.repository.SintomaRepository;
import edu.ifam.dad.aplicacao_spring_boot_2025.service.SintomaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sintomas")
@CrossOrigin(origins = "*")
public class SintomaController {


    @Autowired
    private SintomaRepository sintomaRepository;

    private final SintomaService sintomaService;

    public SintomaController(SintomaService sintomaService) {
        this.sintomaService = sintomaService;
    }


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Sintoma>> listarTodos(){
        List<Sintoma> sintomas = sintomaRepository.findAll();
        if (!sintomas.isEmpty()){
            return new ResponseEntity<>(sintomas, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
