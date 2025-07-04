package edu.ifam.dad.aplicacao_spring_boot_2025.repository;

import edu.ifam.dad.aplicacao_spring_boot_2025.model.Sintoma;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SintomaRepository extends JpaRepository<Sintoma, Long> {
}
