package com.ticketstore.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

import com.ticketstore.webapp.Dao.ArtistDao;
import com.ticketstore.webapp.model.Artist;
import com.ticketstore.webapp.model.Genre;
import com.ticketstore.webapp.Dao.GenreDao;

@Controller
public class ArtisController {

    @Autowired
    ArtistDao dao;

    @Autowired
    GenreDao genreDao;

    @RequestMapping("/insert_concert/insert_artist")
    public String insertArtistPage(Model model) {
        Artist artist = new Artist();
        List<Genre> listGenre = genreDao.listGenre();
        model.addAttribute("artist", artist);
        model.addAttribute("genres", listGenre);
        return ("insert_artist");
    }

    @RequestMapping("/insert_concert/insert_artist/another")
    public String another() {
        return ("another");
    }

    @RequestMapping(value = "/insertArtist", method = RequestMethod.POST)
    public String insertArtist(@ModelAttribute("artist") Artist artist) {
        dao.insertArtist(artist.getArtist_name(), artist.getGenre_id());

        return "redirect:/insert_concert/insert_artist/another";
    }

}
