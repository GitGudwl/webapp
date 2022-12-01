package com.ticketstore.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ticketstore.webapp.Dao.VenueDao;
import com.ticketstore.webapp.model.Venue;

@Controller
public class VenueController {

    @Autowired
    private VenueDao venueDao;

    @RequestMapping("/insert_venue")
    public String insertVenue(Model model) {
        Venue venue = new Venue();
        model.addAttribute("venue", venue);
        return ("insert_venue");
    }

    @RequestMapping(value = "/insertVenue", method = RequestMethod.POST)
    public String insertVenue(@ModelAttribute("venue") Venue venue) {
        if (venue.getVenue_name().equals("") || venue.getCapacity().equals(null) || venue.getLocation().equals("")
                || venue.getType().equals("")) {
            return "redirect:/insert_venue";
        }
        venueDao.insertVenue(venue.getVenue_name(), venue.getLocation(), venue.getType(), venue.getCapacity());

        return "redirect:/";
    }
}
