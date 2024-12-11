package mk.ukim.finki.wp.lab.service.implement;

import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;
import mk.ukim.finki.wp.lab.repository.SongRepository;
import mk.ukim.finki.wp.lab.service.SongService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongServiceImp implements SongService {
    private final SongRepository songRepository;

    public SongServiceImp(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    @Override
    public List<Song> listSongs() {
        return songRepository.findAll();
    }

    //@Override
    //public Artist addArtistToSong(Artist artist, Song song) {
    //    return songRepository.addArtistToSong(artist, song);
    //}

    @Override
    public Song findByTrackId(String trackId) {
//        return songRepository.findById(trackId);
        return new Song();
    }
}