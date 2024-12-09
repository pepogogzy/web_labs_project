package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab.model.Song;
import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.service.SongService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {

    @Query(value = "SELECT * FROM Song", nativeQuery = true)
    List<Song> findAll();

    @Query(value = "SELECT * FROM Song WHERE trackId == :tid", nativeQuery = true)
    Song findAllByTrackId(@Param("tid") String trackId);


    Artist addArtistToSong(Artist artist, Song song);

    List<Song> findAllByAlbum_Id(Long albumId);
}
