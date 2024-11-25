package mk.ukim.finki.wp.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.wp.lab.model.Album;
import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {

    public static List<Artist> lista_artisti = new ArrayList<>();
    public static List<Song> lista_pesni = new ArrayList<>();
    public static List<Album> lista_albumi = new ArrayList<>();

    @PostConstruct
    public void init() {
        lista_artisti.add(new Artist (1L, "Taylor", "Swift", "bio1"));
        lista_artisti.add(new Artist (2L, "David", "Bowie", "bio2"));
        lista_artisti.add(new Artist (3L, "Sabrina", "Carpenter", "bio3"));
        lista_artisti.add(new Artist (4L, "Elvis", "Presly", "bio4"));
        lista_artisti.add(new Artist (5L, "Zach", "Bryan", "bio5"));

        lista_albumi.add(new Album (1L, "Blondie", "Jazz", "1977"));
        lista_albumi.add(new Album (2L, "Rapture", "Pop", "1997"));
        lista_albumi.add(new Album (3L, "Donda", "Rap", "2020"));
        lista_albumi.add(new Album (4L, "a4", "Jazz", "2018"));
        lista_albumi.add(new Album (5L, "a5", "Rap", "2004"));

        lista_pesni.add(new Song("1", "Blinding Lights", "Pop", 2020, lista_albumi.get(0)));
        lista_pesni.add(new Song("2", "Shape of You", "Pop", 2017, lista_albumi.get(0)));
        lista_pesni.add(new Song("3", "Bohemian Rhapsody", "Rock", 1975, lista_albumi.get(1)));
        lista_pesni.add(new Song("4", "Uptown Funk", "Funk", 2014, lista_albumi.get(1)));
        lista_pesni.add(new Song("5", "Rolling in the Deep", "Soul", 2010, lista_albumi.get(2)));

    }

}