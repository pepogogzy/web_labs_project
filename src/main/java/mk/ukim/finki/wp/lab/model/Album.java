package mk.ukim.finki.wp.lab.model;


import lombok.Data;
import lombok.Getter;

@Getter
@Data
public class Album {

    private Long id;
    private String name;
    private String genre;
    private String releaseYear;

    public Album(Long id, String name, String genre, String releaseYear) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.releaseYear = releaseYear;
    }
}
