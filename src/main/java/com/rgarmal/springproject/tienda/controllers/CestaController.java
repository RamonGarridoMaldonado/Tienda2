package com.rgarmal.springproject.tienda.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.rgarmal.springproject.tienda.model.Pedido;

@Controller
@RequestMapping("cesta")
public class CestaController {

    @GetMapping(value = {"edit"})
    public ModelAndView cesta(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        Pedido pedido = new Pedido();
    }
}
