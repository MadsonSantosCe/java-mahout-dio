package com.example.recomendador.controller;

import com.example.recomendador.service.FilmesService;
import org.apache.mahout.cf.taste.common.TasteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping
public class indexController {

    @Autowired
    FilmesService service;

    @GetMapping("/")
    public ModelAndView indexLogin(){
        ModelAndView modelAndView = new ModelAndView("/index");
        modelAndView.addObject("filmes", service.getRecommendations());
        return modelAndView;
    }
}
