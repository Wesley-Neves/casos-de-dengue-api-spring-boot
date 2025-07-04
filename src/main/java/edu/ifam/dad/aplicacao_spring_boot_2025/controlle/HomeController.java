package edu.ifam.dad.aplicacao_spring_boot_2025.controlle;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping
    public String init(){
        return "Web service Restful executando";
    }
}
