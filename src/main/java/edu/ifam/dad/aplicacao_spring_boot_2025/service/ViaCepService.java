package edu.ifam.dad.aplicacao_spring_boot_2025.service;


import edu.ifam.dad.aplicacao_spring_boot_2025.dto.ViaCepResponseDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ViaCepService {


    private final RestTemplate restTemplate;


    public ViaCepService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ViaCepResponseDTO buscarEnderecoPorCep(String cep){
        String url = "https://viacep.com.br/ws/"+ cep+"/json/";
        return restTemplate.getForObject(url, ViaCepResponseDTO.class);
    }

}
