package com.example.demo.controller;

import com.example.demo.Entity.PersonForm;
import com.example.demo.Repository.FormRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping("")
public class HomeController {

    private FormRepository formRepository;
    public HomeController(FormRepository formRepository){
       this.formRepository = formRepository;
    }
    @GetMapping("")
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("date", formRepository.findAll());
        modelAndView.setViewName("form");
        return modelAndView;
    }
}
