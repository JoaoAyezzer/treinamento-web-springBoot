package br.com.sgsistemas.treinamentobackend.service;

import br.com.sgsistemas.treinamentobackend.dto.MercadoDTO;
import br.com.sgsistemas.treinamentobackend.models.Contador;
import br.com.sgsistemas.treinamentobackend.models.Mercado;
import br.com.sgsistemas.treinamentobackend.repositories.MercadoRepository;
import br.com.sgsistemas.treinamentobackend.service.exceptions.DataIntegrityException;
import br.com.sgsistemas.treinamentobackend.service.exceptions.DataIntegrityExceptionID;
import br.com.sgsistemas.treinamentobackend.service.exceptions.ObjectNotfoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MercadoService {

    @Autowired
    MercadoRepository mercadoRepository;

    private final ContadorService contadorService;

    public MercadoService(ContadorService contadorService) {
        this.contadorService = contadorService;
    }

    public List<Mercado> getAll(){
        return mercadoRepository.findAll();
    }

    public Mercado getById(Long id){
        Optional<Mercado> mercado = mercadoRepository.findById(id);
        return mercado.orElseThrow(()-> new ObjectNotfoundException(
                "Objeto nao encontrado! Id: " + id + ", Tipo: " + Mercado.class.getName()
        ));
    }

    public static List<MercadoDTO> fromDTO(List<Mercado> mercados){
        List<MercadoDTO> mercadoDTOS = new ArrayList<>();
        for (Mercado mercado :mercados) {
            MercadoDTO mercadoDTO = new MercadoDTO(mercado);
            mercadoDTOS.add(mercadoDTO);
        }
        return mercadoDTOS;
    }

    public Mercado insertMercado( Mercado mercado ){
        try{
           return mercadoRepository.save(mercado);
        }catch (DataIntegrityViolationException e ){
            throw new DataIntegrityExceptionID("Não é possivel salvar o Mercado pois a campos imvalidos na requisição");

        }
    }

    public Mercado updateMercado(Mercado mercado){
        getById(mercado.getId());
        try{
            return mercadoRepository.save(mercado);
        }catch (DataIntegrityViolationException e ){
            throw new DataIntegrityExceptionID("Não é possivel salvar o Mercado pois a campos imvalidos na requisição");

        }
    }
    public void deleteMercado(Long id){
        getById(id);
        try {
            mercadoRepository.deleteById(id);
        }catch (DataIntegrityViolationException e){
            throw new DataIntegrityException("Não é poossivel excluir um Veiculo que possui associações!");
        }
    }

    public Mercado fromDTO(MercadoDTO mercadoDTO){

        Contador contador = ( mercadoDTO.getContadorID() == null ) ? null : contadorService.getById(mercadoDTO.getContadorID());

        return new Mercado(mercadoDTO.getNomeFantasia(), mercadoDTO.getCnpj(), mercadoDTO.getRazaoSocial(), mercadoDTO.getResponsavel(), contador);
    }
}
