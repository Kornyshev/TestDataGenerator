package com.epam.TestDataManagementTool.controllers;

import com.epam.TestDataManagementTool.db.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @Autowired
    CustomersRepository customersRepository;

    @GetMapping("/")
    String getAllData(Model model) {
        model.addAttribute("title","");
        model.addAttribute("customersList", customersRepository.findAll());
        return "table";
    }

}
