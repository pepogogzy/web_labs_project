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

    @Column(nullable = false)
    private String trackId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String genre;

    @Column(nullable = false)
    private int releaseYear;

    //@ManyToMany(mappedBy = "songs")
    //private List<Artist> performers;

    @ManyToOne
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