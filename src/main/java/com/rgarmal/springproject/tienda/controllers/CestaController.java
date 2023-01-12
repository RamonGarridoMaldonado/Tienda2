package com.rgarmal.springproject.tienda.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.rgarmal.springproject.tienda.model.Cliente;
import com.rgarmal.springproject.tienda.model.DetallePedido;
import com.rgarmal.springproject.tienda.model.Pedido;
import com.rgarmal.springproject.tienda.model.Producto;
import com.rgarmal.springproject.tienda.services.ClientesServices;
import com.rgarmal.springproject.tienda.services.ProductosServices;

@Controller
@RequestMapping("cesta")
public class CestaController {

    @Autowired
    ClientesServices clientesServices;
    @Autowired
    ProductosServices productosServices;

    @RequestMapping(value = { "/pedido" })
    public ModelAndView guardarUsuario(@RequestParam(name = "codigo", required = true) int codigo, Model model,
            HttpSession session) {

        Cliente cliente = clientesServices.findById(codigo);
        session.setAttribute("cliente", cliente);

        Pedido pedido = new Pedido();
        pedido.setCliente(cliente);
        session.setAttribute("pedido", pedido);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("cesta/carrito");
        return modelAndView;
    }

    @RequestMapping(value = { "/carrito" })
    public ModelAndView verCarrito(Model model, HttpSession session) {

        // Pedido pedido = (Pedido) session.getAttribute("pedido");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("cesta/carrito");
        // modelAndView.addObject("pedido", pedido);
        return modelAndView;
    }

    @GetMapping(value = "/insertarAlCarrito/{codigo}")
    public ModelAndView insertarAlCarrito(@PathVariable(name = "codigo", required = true) int codigo,
            HttpSession session) {

        Producto producto = productosServices.findById(codigo);

        Pedido pedido = (Pedido) session.getAttribute("pedido");

        if (pedido == null) {
            pedido = new Pedido();
        }

        if (pedido.getDetallePedido() == null) {
            List<DetallePedido> detallePedidos = new ArrayList<DetallePedido>();
            pedido.setDetallePedido(detallePedidos);
        }

        DetallePedido productoActual = new DetallePedido();
        int cantidad = 1;
        productoActual.setProducto(producto);
        productoActual.setCantidad(cantidad);
        productoActual.setSubtotal(cantidad * producto.getPrecio());
        pedido.getDetallePedido().add(productoActual);

        session.setAttribute("pedido", pedido);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("cesta/carrito");
        return modelAndView;
    }

    

}
