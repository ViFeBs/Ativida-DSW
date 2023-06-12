package br.senac.tads.dsw.musicas.controller;

import java.util.List;
import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;


import br.senac.tads.dsw.musicas.model.MusicaDTO;
import br.senac.tads.dsw.musicas.service.MusicaService;

@RestController
@RequestMapping("/musica")
public class MusicaController {
    
    @Autowired
    private MusicaService service;

    @GetMapping
    public List<MusicaDTO> findAll(){
        return service.findAll();
    }

    @PostMapping
    public ResponseEntity<Void> addNew(@RequestBody @Valid MusicaDTO dados){
        service.addNew(dados);
        URI location = ServletUriComponentsBuilder
        .fromCurrentRequest().path("/{titulo}")
        .buildAndExpand(dados.titulo()).toUri();
        return ResponseEntity.created(location).build();
    }
}
