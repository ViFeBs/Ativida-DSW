package br.senac.tads.dsw.musicas.model;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

public record MusicaDTO(
    @NotBlank(message = "Preencha o titulo da musica")
    @Size(max = 100)
    String titulo,

    @NotBlank(message = "Preencha o nome do artista")
    @Size(max = 50)
    String artista,

    @PastOrPresent
    LocalDate dtLancamento
) {
    
}
