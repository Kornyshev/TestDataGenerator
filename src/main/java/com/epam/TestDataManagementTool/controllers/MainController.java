package com.epam.TestDataManagementTool.controllers;

import com.epam.TestDataManagementTool.db.CustomersRepository;
import com.epam.TestDataManagementTool.models.UiRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    @Autowired
    CustomersRepository customersRepository;

    @GetMapping("/")
    public String getIndex(Model model) {
        model.addAttribute("uiRequest", new UiRequest());
        return "index";
    }

    @PostMapping("/generate")
    public ModelAndView generateDatabase(@ModelAttribute("uiRequest") UiRequest uiRequest) {
        ModelAndView modelAndView = new ModelAndView();
        /*
        ProductLine -> Product
        Office -> Employee
        Customer -> Payment
        Order -> OrderDetails
        */

        modelAndView.setViewName("table");
        return modelAndView;
    }

}
