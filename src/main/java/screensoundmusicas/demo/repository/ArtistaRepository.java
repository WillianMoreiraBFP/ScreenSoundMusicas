package screensoundmusicas.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import screensoundmusicas.demo.model.Artista;
import screensoundmusicas.demo.model.Musica;

import java.util.List;

public interface ArtistaRepository extends JpaRepository<Artista,Long> {
    @Query("SELECT a FROM Artista a")
    List<Artista> listarArtistas();
    @Query("SELECT m FROM Musica m ORDER BY m.artista")
    List<Musica> listarMusicas();
    @Query("SELECT m FROM Artista a JOIN a.musicas m WHERE a = :artista")
    List<Musica> listarMusicasPorAtista(Artista artista);
    @Query("SELECT a FROM Artista a WHERE LOWER(a.nome) = LOWER(:nomeArtista)")
    Artista encontraArtista(String nomeArtista);
}
