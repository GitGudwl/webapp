package com.ticketstore.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ticketstore.webapp.Dao.GenreDao;
import com.ticketstore.webapp.model.Genre;

@Controller
public class genreController {

    @Autowired
    private GenreDao genreDao;

    @RequestMapping("/insert_genre")
    public String insertGenre(Model model) {
        Genre genre = new Genre();
        model.addAttribute("genre", genre);
        return ("insert_genre");
    }

    @RequestMapping(value = "/insertGenre", method = RequestMethod.POST)
    public String insertGenre(@ModelAttribute("genre") Genre genre) {
        if (genre.getGenre_name().equals("")) {
            return "redirect:/insert_genre";
        }
        genreDao.insertGenre(genre.getGenre_name());

        return "redirect:/";
    }

}