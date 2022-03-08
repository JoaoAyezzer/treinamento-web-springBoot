package br.com.sgsistemas.treinamentobackend.service;

import br.com.sgsistemas.treinamentobackend.dto.ContadorDTO;
import br.com.sgsistemas.treinamentobackend.dto.MercadoDTO;
import br.com.sgsistemas.treinamentobackend.models.Contador;
import br.com.sgsistemas.treinamentobackend.repositories.ContadorRepository;
import br.com.sgsistemas.treinamentobackend.service.exceptions.DataIntegrityException;
import br.com.sgsistemas.treinamentobackend.service.exceptions.DataIntegrityExceptionID;
import br.com.sgsistemas.treinamentobackend.service.exceptions.ObjectNotfoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContadorService {

    @Autowired
    ContadorRepository contadorRepository;

    public List<Contador> getAll(){
        return contadorRepository.findAll();
    }
    public Contador getById(Long id){
        Optional<Contador> contador = contadorRepository.findById(id);
        return contador.orElseThrow(()-> new ObjectNotfoundException(
                "Objeto nao encontrado! Id: " + id + ", Tipo: " + Contador.class.getName()
        ));
    }

    public Contador insertContador( Contador contador ){
        try{
           return contadorRepository.save(contador);

        }catch (DataIntegrityViolationException e){
            throw new DataIntegrityExceptionID( "nao foi possivel salvar o contador pois há campos invalidos na requisição" );
        }

    }
    public Contador updateContador(Contador contador){
        getById(contador.getId());
        try{
            return contadorRepository.save(contador);

        }catch (DataIntegrityViolationException e){
            throw new DataIntegrityExceptionID( "nao foi possivel salvar o contador pois há campos invalidos na requisição" );
        }
    }
    public void deleteContador(Long id){
        getById(id);
        try {
            contadorRepository.deleteById(id);
        }catch (DataIntegrityViolationException e){
            throw new DataIntegrityException("Não é poossivel excluir um Veiculo que possui associações!");
        }
    }

    public Contador fromDTO(ContadorDTO contadorDTO){
        Contador contador = new Contador(contadorDTO.getCpf(), contadorDTO.getNome(), contadorDTO.getContabilidade(), contadorDTO.getEmail());
        return contador;
    }



}
