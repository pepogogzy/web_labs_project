package mk.ukim.finki.wp.lab.web.controller;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.ukim.finki.wp.lab.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab.model.Album;
import mk.ukim.finki.wp.lab.model.Song;
import mk.ukim.finki.wp.lab.service.AlbumService;
import mk.ukim.finki.wp.lab.service.SongService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/songs")
public class SongController {



    private final SongService songService;
    public SongController(SongService songService) {
        this.songService = songService;
    }

    @GetMapping
    public String getSongsPage(@RequestParam(required = false) String error, Model model){
        return "redirect:/songs/song-details";
    }

    @PostMapping("/add")
    public String saveSong(
            @RequestParam String title,
            @RequestParam String trackId,
            @RequestParam String genre,
            @RequestParam Integer releaseYear,
            @RequestParam Long album_id

    ){
        for(Album a : DataHolder.lista_albumi){
            if (a.getId() == album_id){
                DataHolder.lista_pesni.add(new Song(trackId, title, genre, releaseYear, a));
            }
        }

        return "redirect:/listSongs";

    }

    @GetMapping("/edit-form/{id}")
    public ModelAndView getEditSongForm(@PathVariable String id) throws IOException {
        ModelAndView mav = new ModelAndView("add-song.html");

        for(Song song : DataHolder.lista_pesni){
            if(song.getTrackId().equals(id)){
                List<Album> albums = DataHolder.lista_albumi;

                mav.addObject("title", song.getTitle());
                mav.addObject("trackId", song.getTrackId());
                mav.addObject("genre", song.getGenre());
                mav.addObject("releaseYear", song.getReleaseYear());
                mav.addObject("album", song.getAlbum());
                mav.addObject("albumList", albums);
                mav.addObject("action", "/songs/edit/" + id);


            }
        }

        return mav;
        //return "edit-song";
    }

    @GetMapping("/add-form")
    public ModelAndView getAddSongPage() throws IOException {
        ModelAndView mav = new ModelAndView("add-song.html");

        List<Album> albums = DataHolder.lista_albumi;
        mav.addObject("albumList", albums);
        mav.addObject("action", "/songs/add");


        return mav;
        //return "edit-song";
    }

    @PostMapping("/edit/{songId}")
    public String editSong(@PathVariable String songId,
                @RequestParam String title,
                @RequestParam String trackId,
                @RequestParam String genre,
                @RequestParam Integer releaseYear,
                @RequestParam Long album_id
    ){
        for (Song s : DataHolder.lista_pesni){
            if (Objects.equals(s.getTrackId(), songId)){
                Album al = null;
                System.out.println(s);
                for(Album a : DataHolder.lista_albumi){
                    if (Objects.equals(a.getId(), album_id)){
                        al = a;
                    }
                }

                s.setAlbum(al);

                s.setTitle(title);
                s.setTrackId(trackId);
                s.setGenre(genre);
                s.setReleaseYear(releaseYear);
            }
        }

        return "redirect:/listSongs";

    }

    @GetMapping("/delete/{id}")
    public static String deleteSong(@PathVariable String id){
        System.out.println(id);
        for (Song s : DataHolder.lista_pesni){
            System.out.println(s);
            if (Objects.equals(s.getTrackId(), id)){
                System.out.println(s.getTitle());

                DataHolder.lista_pesni.remove(s);
            }
        }
        return "redirect:/listSongs";

    }

}
