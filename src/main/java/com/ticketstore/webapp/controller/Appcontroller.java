package com.ticketstore.webapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ticketstore.webapp.Dao.CustomerDao;
import com.ticketstore.webapp.model.Customer;

@Controller
public class Appcontroller {
    @Autowired
    private CustomerDao dao;

    @RequestMapping("/user")
    public String view(Model model) {
        List<Customer> listCustomers = dao.test();
        model.addAttribute("listCustomers", listCustomers);
        return "index";
    }

    @RequestMapping("/signup")
    public String signupPage(Model model) {
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return ("signup");
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String signup(@ModelAttribute("customer") Customer customer) {
        if (customer.getCustomer_name().equals("") || customer.getEmail().equals("")
                || customer.getUser_name().equals("") || customer.getPassword().equals("")) {
            return "redirect:/signup";
        }

        boolean test = dao.signup(customer.getCustomer_name(), customer.getEmail(), customer.getUser_name(),
                customer.getPassword());
        if (test == true) {
            return "redirect:/";
        } else {
            return "redirect:/signup";
        }
    }

}
