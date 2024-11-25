package mk.ukim.finki.wp.lab.model;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import mk.ukim.finki.wp.lab.model.Artist;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Getter
@Data
public class Song {

    private String trackId;
    private String title;
    private String genre;
    private int releaseYear;
    private List<Artist> performers;
    private Album album;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Song(String trackId, String title, String genre, int releaseYear, Album album) {
        this.trackId = trackId;
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.performers = new ArrayList<>();
        this.album = album;
    }

    public Song(){}

    public void addPerformer(Artist performer) {
        performers.add(performer);
    }

}