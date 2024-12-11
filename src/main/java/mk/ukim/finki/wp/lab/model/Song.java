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
@Entity
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String trackId;
    private String title;
    private String genre;
    private int releaseYear;

    //@ManyToMany(mappedBy = "song")
    //private List<Artist> performers;

    @ManyToOne()
    private Album album;

    public Song(String trackId, String title, String genre, int releaseYear, Album album) {
        this.trackId = trackId;
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        //this.performers = new ArrayList<>();
        this.album = album;
    }

    public Song(){}

    //public void addPerformer(Artist performer) {
    //    performers.add(performer);
    //}

}