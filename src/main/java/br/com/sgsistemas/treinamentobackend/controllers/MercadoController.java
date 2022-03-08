package br.com.sgsistemas.treinamentobackend.controllers;

import br.com.sgsistemas.treinamentobackend.dto.MercadoDTO;
import br.com.sgsistemas.treinamentobackend.models.Mercado;
import br.com.sgsistemas.treinamentobackend.service.MercadoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "v1/mercado")
public class MercadoController {

    private final MercadoService mercadoService;

    public MercadoController(MercadoService mercadoService) {
        this.mercadoService = mercadoService;
    }

    @GetMapping
    public ResponseEntity<List<MercadoDTO>> getAllMercados(){
        List<MercadoDTO> mercadoDTOS = mercadoService.getAll()
                .stream()
                .map(MercadoDTO::new)
                .collect( Collectors.toList() );
        return ResponseEntity.ok().body(mercadoDTOS);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Mercado> getById(@PathVariable Long id){
        return ResponseEntity.ok().body(mercadoService.getById(id));
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody MercadoDTO mercadoDTO){
        Mercado mercado = mercadoService.fromDTO(mercadoDTO);
        mercado = mercadoService.insertMercado( mercado );
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(mercado.getCnpj())
                .toUri();
        return ResponseEntity.created(uri).build();
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> updateMercado(@RequestBody MercadoDTO mercadoDTO, @PathVariable Long id){
        Mercado mercado = mercadoService.fromDTO(mercadoDTO);
        mercado.setId(id);
        mercado = mercadoService.updateMercado(mercado);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping(value = "/{id}" )
    public  ResponseEntity<Void> deleteMercado(@PathVariable Long id){
        mercadoService.deleteMercado(id);
        return ResponseEntity.noContent().build();
    }
}

