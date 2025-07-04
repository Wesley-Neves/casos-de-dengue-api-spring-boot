package edu.ifam.dad.aplicacao_spring_boot_2025.controlle;


import edu.ifam.dad.aplicacao_spring_boot_2025.dto.CasoDengueDTO;
import edu.ifam.dad.aplicacao_spring_boot_2025.dto.ViaCepResponseDTO;
import edu.ifam.dad.aplicacao_spring_boot_2025.model.CasoDengue;
import edu.ifam.dad.aplicacao_spring_boot_2025.service.CasoDengueService;
import edu.ifam.dad.aplicacao_spring_boot_2025.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/casos")
@CrossOrigin(origins = "*")
public class CasoDengueController {

    private final CasoDengueService casoDengueService;

    @Autowired
    private ViaCepService viaCepService;


    public CasoDengueController(CasoDengueService casoDengueService) {
        this.casoDengueService = casoDengueService;
    }


    //listar cados de dengue
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CasoDengue>> listarTodos(){
        List<CasoDengue> casoDengues = casoDengueService.listarCasos();
        if (!casoDengues.isEmpty()){
            return new ResponseEntity<>(casoDengues, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }


    //buscar caso de dengue pelo ID
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CasoDengue> buscarPorId(@PathVariable Long id){

        Optional<CasoDengue> possivelCasoDengue = casoDengueService.buscarPorId(id);

        if (possivelCasoDengue.isPresent()){
            return new ResponseEntity<>(possivelCasoDengue.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    //criar caso de dengue
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CasoDengue> criar (@RequestBody CasoDengueDTO casoDengueDTO) {
        try {
            CasoDengue casoDengueSalvo = casoDengueService.cadastrarCasoComDTO(casoDengueDTO);
            return new ResponseEntity<>(casoDengueSalvo, HttpStatus.CREATED);
        } catch (IllegalArgumentException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro ao criar caso de dengue: "+ e.getMessage());
        }
    }


    public ResponseEntity<CasoDengue> atualizar(@PathVariable Long id, @RequestBody CasoDengueDTO casoDengueDTO){
        try {
            CasoDengue casoDengueAtualizado = casoDengueService.atualizarCasoComDTO(id, casoDengueDTO);
            return new ResponseEntity<>(casoDengueAtualizado, HttpStatus.OK);
        } catch (IllegalArgumentException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro ao atualizar caso de dengue: "+ e.getMessage());
        }
    }

    //Excluir caso de dengue
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id){
        try {
            casoDengueService.excluirCaso(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (IllegalArgumentException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro ao excluir caso de dengue: " + e.getMessage(), e);
        }
    }

    @GetMapping(value = "viacep/{cep}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ViaCepResponseDTO buscarEnderecoPorCep(@PathVariable String cep){
        return viaCepService.buscarEnderecoPorCep(cep);
    }



}
