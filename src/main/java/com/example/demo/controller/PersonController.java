package com.example.demo.controller;

import com.example.demo.entity.PersonForm;
import com.example.demo.repository.PersonFormRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
@RequestMapping("/persons")
public class PersonController implements WebMvcConfigurer {

    private PersonFormRepository personFormRepository;
    public PersonController(PersonFormRepository personFormRepository){
       this.personFormRepository = personFormRepository;
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/persons/create/results").setViewName("persons/results");
    }


    @GetMapping("")
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("persons", personFormRepository.findAll());
        modelAndView.setViewName("persons/list.html");
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView create(PersonForm personForm){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("dto", new PersonForm());
        modelAndView.addObject("method", "post");
        modelAndView.setViewName("persons/form");
        return modelAndView;
    }

    @PostMapping("/create")
    public String checkPersonInfo(@Valid PersonForm personForm, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "persons/form";
        }

        personFormRepository.save(personForm);
        return "redirect:/persons/create/results";
    }
}
