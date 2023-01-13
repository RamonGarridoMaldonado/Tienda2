package com.rgarmal.springproject.tienda.controllers;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.handler.NoUnboundElementsBindHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.rgarmal.springproject.tienda.model.Cliente;
import com.rgarmal.springproject.tienda.model.DetallePedido;
import com.rgarmal.springproject.tienda.model.LoginUsuario;
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

    @RequestMapping(value = {"nuevaCesta"} )
    public ModelAndView nuevaCesta(@RequestParam(name = "codigo", required = true) int codigo,HttpSession session) {
        
        Cliente cliente = clientesServices.findById(codigo);

            Pedido pedido = (Pedido) session.getAttribute("pedido");
            if(pedido == null){
                pedido = new Pedido();
            }

            pedido.setCliente(cliente);
            session.setAttribute("pedido", pedido);
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("redirect:edit");
            return modelAndView;
    }

    @GetMapping(value = { "/edit" })
    public ModelAndView cesta(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();

        Pedido pedido = (Pedido) session.getAttribute("pedido");

        if(pedido == null) {
            pedido = new Pedido();
        }

        Cliente cliente = pedido.getCliente();


        modelAndView.addObject("cliente", cliente);
        modelAndView.addObject("pedido", pedido);
        modelAndView.setViewName("pedidos/cesta");
        return modelAndView;    
    }

    @GetMapping(value = { "/delete" })
    public ModelAndView delete(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();

        session.setAttribute("pedido", null);

        modelAndView.setViewName("redirect:edit");
        return modelAndView;    
    }

    @GetMapping(value = "/addcesta/{codigo}/{cantidad}")
    public ModelAndView addCliente(
        @PathVariable(name = "codigo", required = true) int codigo, @PathVariable(name = "cantidad", required = true) int cantidad,HttpSession session) {

            Producto producto = productosServices.findById(codigo);

            Pedido pedido = (Pedido) session.getAttribute("pedido");

            if(pedido == null){
                pedido = new Pedido();
            }

            if(pedido.getDetallePedidos() == null){
                List<DetallePedido> detallePedidos = new ArrayList<DetallePedido>();
                pedido.setDetallePedidos(detallePedidos);
            }

            DetallePedido detalle = new DetallePedido();
            detalle.setProducto(producto);
            detalle.setCantidad(cantidad);
            detalle.setSubtotal(cantidad*producto.getPrecio());
            pedido.getDetallePedidos().add(detalle);

            session.setAttribute("pedido", pedido);

            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("redirect:/cesta/edit");
            return modelAndView;
    }
}
