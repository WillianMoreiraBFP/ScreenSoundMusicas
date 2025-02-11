package screensoundmusicas.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "musicas")
public class Musica {
    private String nome;
    private String album;
    @ManyToOne
    private Artista artista;

    public Musica() {}

    public Musica(String nome, String album) {
        this.nome = nome;
        this.album = album;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }
}
