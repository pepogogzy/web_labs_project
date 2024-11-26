package mk.ukim.finki.wp.lab.web;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.ukim.finki.wp.lab.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.service.implement.ArtistServiceImp;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;
import java.util.List;

@WebServlet(name="SearchArtistServlet", urlPatterns = {"/search-artist"})
public class SearchArtistServlet extends HttpServlet {

    private final ArtistServiceImp artistService;
    private final SpringTemplateEngine templateEngine;

    public SearchArtistServlet(ArtistServiceImp artistService, SpringTemplateEngine templateEngine) {
        this.artistService = artistService;
        this.templateEngine = templateEngine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Artist> artistList;
        artistList = artistService.listArtists();



        IWebExchange iWebExchange = JakartaServletWebApplication
                .buildApplication(req.getServletContext())
                .buildExchange(req, resp);
        WebContext context = new WebContext(iWebExchange);
        context.setVariable("artistList", artistList);
        templateEngine.process("artistsList.html", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String trackId;
        List<Artist> artistList;
        artistList = artistService.listArtists();

        if (req.getParameter("songRadio") != null) {
            trackId = req.getParameter("songRadio");
        } else {
            trackId = "-";
        }

        String srch=req.getParameter("sstring");
        String res = "";
        for(Artist a : DataHolder.lista_artisti){
            System.out.println(srch);
            System.out.println(a.getFirstName());
            if (srch.equals( a.getFirstName()) || srch.contains( a.getLastName()) || srch.contains( a.getBio())){
                    res = a.getId() + " " + a.getFirstName() + " " + a.getLastName() + " " + a.getBio();
                    break;
                }
                else{
                    res = "Artist not found";
                }
            }


        IWebExchange iWebExchange = JakartaServletWebApplication
                .buildApplication(req.getServletContext())
                .buildExchange(req, resp);
        WebContext context = new WebContext(iWebExchange);
        context.setVariable("trackId", trackId);
        context.setVariable("artistList", artistList);
        context.setVariable("searched_artist", res);
        templateEngine.process("artistsList.html", context, resp.getWriter());
    }

}