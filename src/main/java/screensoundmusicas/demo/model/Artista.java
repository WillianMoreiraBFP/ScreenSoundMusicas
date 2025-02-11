package screensoundmusicas.demo.model;


import jakarta.persistence.*;

@Entity
@Table(name = "cantores")
public class Artista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String nome;
    private

    public Artista() {
    }


}
