package br.senac.tads.dsw.musicas.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.senac.tads.dsw.musicas.database.MusicaRepository;
import br.senac.tads.dsw.musicas.model.Musica;
import br.senac.tads.dsw.musicas.model.MusicaDTO;

@Service
public class MusicaService {
    @Autowired
    private MusicaRepository repository;

    private MusicaDTO builDto(Musica entity){
        MusicaDTO dto = new MusicaDTO(entity.getTitulo(), entity.getArtista(), entity.getDtLancamento());
        return dto;
    }

    private Musica buildEntity(MusicaDTO dto){
        Musica entity = new Musica();
        entity.setTitulo(dto.titulo());
        entity.setArtista(dto.artista());
        entity.setDtLancamento(dto.dtLancamento());
        return entity;
    }

    @Transactional(readOnly = true)
    public List<MusicaDTO> findAll(){
        List<Musica> entities;
        entities = repository.findAll();
        List<MusicaDTO> result = new ArrayList<>();
        for(Musica entity: entities){
            MusicaDTO dto = builDto(entity);
            result.add(dto);
        } 
        return result;
    }

    @Transactional
    public void addNew(MusicaDTO dados) {
        Musica entity = buildEntity(dados);
        repository.save(entity);
    }

}
