package br.senac.tads.dsw.musicas.database;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.senac.tads.dsw.musicas.model.Musica;

public interface MusicaRepository extends JpaRepository<Musica, Integer>{
    
    Optional<Musica> findByTitulo(String titulo);

    Optional<Musica> findByTituloIgnoreCase(String titulo);

    boolean existsByTitulo(String titulo);

    void deleteByTitulo(String titulo);
}
