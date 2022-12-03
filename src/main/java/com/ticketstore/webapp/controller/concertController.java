package com.ticketstore.webapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ticketstore.webapp.Dao.ConcertDao;
import com.ticketstore.webapp.Dao.VenueDao;
import com.ticketstore.webapp.model.Concert;
import com.ticketstore.webapp.model.Venue;

@Controller
public class concertController {

    @Autowired
    ConcertDao dao;

    @Autowired
    VenueDao venueDao;

    @RequestMapping("/")
    public String concertView(Model model) {
        List<Concert> listConcerts = dao.test();
        model.addAttribute("listConcerts", listConcerts);
        return "indexConcert";
    }

    public boolean namechecker(String concert_name) {
        List<Concert> listConcerts = dao.test();
        for (Concert concert : listConcerts) {
            if (concert.getConcert_name().equals(concert_name)) {
                return false;
            }
        }
        return true;
    }

    @RequestMapping(value = "/insertConcert", method = RequestMethod.POST)
    public String insertConcert(@ModelAttribute("concert") Concert concert) {
        System.out.println(concert.getThedate());
        System.out.println(concert.getConcert_name());
        if (dao.insertConcert(concert.getConcert_name(), concert.getThedate(), concert.getVenue_id())) {
            return "redirect:/insert_concert/insert_artist";
        }
        return "redirect:/insert_concert";

    }

    @RequestMapping("/insert_concert")
    public String insertConcertPage(Model model) {
        Concert concert = new Concert();
        List<Venue> listVenues = venueDao.List();
        model.addAttribute("concert", concert);
        model.addAttribute("venues", listVenues);
        return ("insert_concert");
    }

}
