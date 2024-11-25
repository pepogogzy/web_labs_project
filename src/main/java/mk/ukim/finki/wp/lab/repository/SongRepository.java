package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab.model.Song;
import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.service.SongService;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SongRepository {

    public List<Song> findAll() {
        return DataHolder.lista_pesni;
    }

    public Song findByTrackId(String trackId) {
        return DataHolder.lista_pesni.stream().filter(song -> song.getTrackId().equals(trackId)).findFirst().orElse(null);
    }



    public Artist addArtistToSong(Artist artist, Song song) {
        song.getPerformers().add(artist);
        return artist;
    }
}
