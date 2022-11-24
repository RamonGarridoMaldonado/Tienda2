package com.rgarmal.springproject.tienda.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.rgarmal.springproject.tienda.model.LoginUsuario;

@Controller
@RequestMapping("login")
public class LoginController {

    @Autowired
    private MessageSource messageSource;

    @GetMapping(value = "/signin")
    public String inicio(Model model) {
        return "signin";
    }

    @PostMapping(value = { "/wellcome" })
    public ModelAndView guardarUsuario(Model model, LoginUsuario usuario, HttpSession session) {

        session.setAttribute("usuario", usuario);
        model.addAttribute("usuario", usuario);

        ModelAndView modelAndView = new ModelAndView();
        String mensaje = messageSource.getMessage("saludar.usuario", new String[] { usuario.getUsuario() },
                LocaleContextHolder.getLocale());
        modelAndView.addObject("greetings", mensaje);
        modelAndView.setViewName("login/wellcome");
        return modelAndView;
    }

    @GetMapping(value = "/logout")
    public String logout( HttpSession session) {
        session.invalidate();
        return "signin";
    }

    @GetMapping(value = "/wellcome")
    public String wellcome(Model model) {
        return "login/wellcome";
    }
}
