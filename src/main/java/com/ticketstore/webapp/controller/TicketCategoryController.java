package com.ticketstore.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ticketstore.webapp.model.TicketCategory;
import com.ticketstore.webapp.Dao.ConcertDao;
import com.ticketstore.webapp.Dao.TicketCategoryDao;
import com.ticketstore.webapp.model.Concert;

import java.util.List;

@Controller
public class TicketCategoryController {
    @Autowired
    private TicketCategoryDao dao;

    @Autowired
    private ConcertDao concertDao;

    @RequestMapping("/insert_ticket_category")
    public String insertTicketCategoryPage(Model model) {
        TicketCategory ticketCategory = new TicketCategory();
        List<Concert> listConcert = concertDao.listConcert();

        model.addAttribute("ticketCategory", ticketCategory);
        model.addAttribute("concerts", listConcert);
        return ("insert_ticket_category");
    }

    @RequestMapping(value = "/insertTicketCategory", method = RequestMethod.POST)
    public String insertTicketCategory(@ModelAttribute("ticketCategory") TicketCategory ticketCategory) {
        dao.insertTicketCategory(ticketCategory.getDesctiption(), ticketCategory.getPrice(),
                ticketCategory.getConcert_id(), ticketCategory.getStock());
        return "redirect:/";
    }

}
