package mk.ukim.finki.wp.lab.repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import mk.ukim.finki.wp.lab.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.service.ArtistService;
import org.springframework.stereotype.Repository;

@Repository
public class ArtistRepository {

    public List<Artist> findAll() {
        return DataHolder.lista_artisti;
    }



    public Optional<Artist> findById(Long id) {
        return DataHolder.lista_artisti.stream().filter(artist -> artist.getId().equals(id)).findFirst();
    }

}
