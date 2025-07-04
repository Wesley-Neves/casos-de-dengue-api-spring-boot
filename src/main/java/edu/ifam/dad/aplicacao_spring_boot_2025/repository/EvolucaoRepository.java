package edu.ifam.dad.aplicacao_spring_boot_2025.repository;

import edu.ifam.dad.aplicacao_spring_boot_2025.model.Evolucao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EvolucaoRepository extends JpaRepository<Evolucao, Long> {
}
