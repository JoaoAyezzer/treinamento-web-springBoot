package br.com.sgsistemas.treinamentobackend.controllers;

import br.com.sgsistemas.treinamentobackend.dto.ContadorDTO;
import br.com.sgsistemas.treinamentobackend.dto.ContadorReadDTO;
import br.com.sgsistemas.treinamentobackend.models.Contador;
import br.com.sgsistemas.treinamentobackend.service.ContadorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "v1/contador")
public class ContadorController {

    private final ContadorService contadorService;

    public ContadorController( ContadorService contadorService) {
        this.contadorService = contadorService;
    }
    @GetMapping
    public ResponseEntity<List<ContadorDTO>> getAllContadores(){
        List<ContadorDTO> contadorDTOS = contadorService.getAll()
                .stream()
                .map(ContadorDTO::new)
                .collect( Collectors.toList() );
        return ResponseEntity.ok().body(contadorDTOS);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ContadorReadDTO> getById(@PathVariable Long id){
        ContadorReadDTO contadorDTO = new ContadorReadDTO(contadorService.getById(id));
        return ResponseEntity.ok().body(contadorDTO);
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody ContadorDTO contadorDTO){
        Contador contador = contadorService.fromDTO(contadorDTO);
        contador = contadorService.insertContador( contador );
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(contador.getCpf())
                .toUri();
        return ResponseEntity.created(uri).build();
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> updateManutencao(@RequestBody ContadorDTO contadorDTO, @PathVariable Long id){
        Contador contador = contadorService.fromDTO(contadorDTO);
        contador.setId(id);
        contador = contadorService.updateContador(contador);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping(value = "/{id}" )
    public  ResponseEntity<Void> deleteManutencao(@PathVariable Long id){
        contadorService.deleteContador(id);
        return ResponseEntity.noContent().build();
    }
}
