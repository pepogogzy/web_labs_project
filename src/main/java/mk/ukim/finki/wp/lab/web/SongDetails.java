package mk.ukim.finki.wp.lab.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;
import mk.ukim.finki.wp.lab.service.implement.ArtistServiceImp;
import mk.ukim.finki.wp.lab.service.implement.SongServiceImp;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;

@WebServlet(name = "SongDetails", urlPatterns = "/songs/song-details")
public class SongDetails extends HttpServlet {
    private final SpringTemplateEngine templateEngine;
    private final SongServiceImp songService;
    private final ArtistServiceImp artistService;

    public SongDetails(SpringTemplateEngine templateEngine, SongServiceImp songService, ArtistServiceImp artistService) {
        this.templateEngine = templateEngine;
        this.songService = songService;
        this.artistService = artistService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Song s = songService.listSongs().stream().findFirst().orElse(null);

        IWebExchange iWebExchange = JakartaServletWebApplication
                .buildApplication(req.getServletContext())
                .buildExchange(req, resp);
        WebContext context = new WebContext(iWebExchange);
        context.setVariable("entity", s);
        templateEngine.process("songDetails.html", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String trackId = req.getParameter("trackId");
        String artistId = req.getParameter("artistId");
        Song s = songService.listSongs().stream().findFirst().orElse(null);

        if (trackId != null && artistId != null) {
            s = songService.findByTrackId(trackId);
            Artist a = artistService.findById(Long.valueOf(artistId));
            s.addPerformer(a);
        }

        IWebExchange iWebExchange = JakartaServletWebApplication
                .buildApplication(req.getServletContext())
                .buildExchange(req, resp);
        WebContext context = new WebContext(iWebExchange);
        context.setVariable("entity", s);
        templateEngine.process("songDetails.html", context, resp.getWriter());
    }
}