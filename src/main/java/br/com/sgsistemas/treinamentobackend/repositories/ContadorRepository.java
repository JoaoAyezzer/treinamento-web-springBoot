package br.com.sgsistemas.treinamentobackend.repositories;

import br.com.sgsistemas.treinamentobackend.models.Contador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContadorRepository extends JpaRepository<Contador, Long> {
}
