package br.com.sgsistemas.treinamentobackend.repositories;

import br.com.sgsistemas.treinamentobackend.models.Mercado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MercadoRepository extends JpaRepository<Mercado, Long> {
}
