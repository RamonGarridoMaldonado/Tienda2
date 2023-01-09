package com.rgarmal.springproject.tienda.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.rgarmal.springproject.tienda.model.DetallePedido;
import com.rgarmal.springproject.tienda.model.Pedido;
import com.rgarmal.springproject.tienda.model.Producto;

@Controller
@RequestMapping("cesta")
public class PedidoController {

    @RequestMapping(value = { "/pedido" })
    public ModelAndView visualizarCarrito(Model model, HttpSession session,Producto producto) {
        DetallePedido detallePedido = new DetallePedido(9,producto,2);
        session.setAttribute("pedido", detallePedido);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("pedidos/pedido");
        return modelAndView;
    }
}