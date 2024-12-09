package mk.ukim.finki.wp.lab.repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import mk.ukim.finki.wp.lab.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.service.ArtistService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Long> {

    List<Artist> findAll();



    Optional<Artist> findById(Long id);

}
