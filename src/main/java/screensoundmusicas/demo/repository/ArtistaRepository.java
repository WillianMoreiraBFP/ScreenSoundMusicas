package screensoundmusicas.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import screensoundmusicas.demo.model.Artista;

public interface ArtistaRepository extends JpaRepository<Artista,Long> {
}
