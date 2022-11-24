package com.rgarmal.springproject.tienda.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import java.util.*;

import com.rgarmal.springproject.tienda.model.Producto;
import com.rgarmal.springproject.tienda.services.ProductosServices;

@Controller
@RequestMapping("productos")
public class ProductoController {

    @Autowired
    ProductosServices productosServices;

    @RequestMapping(value = "/list")
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("productos", productosServices.findAll());
        modelAndView.setViewName("productos/list");
        return modelAndView;
    }

    @RequestMapping(value = "/modificarProducto")
    public ModelAndView edit(
            @RequestParam(name = "codigo", required = true) int codigo) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("producto", productosServices.findById(codigo));
        modelAndView.setViewName("productos/edit");
        return modelAndView;
    }

    @PostMapping(value = "/edit")
    public ModelAndView editCliente(Producto producto) {
        ModelAndView modelAndView = new ModelAndView();

        productosServices.update(producto);
        List<Producto> productos = productosServices.findAll();

        modelAndView.addObject("productos", productos);
        modelAndView.setViewName("productos/list");
        return modelAndView;
    }

    @RequestMapping(value = "/borrar")
    public ModelAndView delete(
            @RequestParam(name = "codigo", required = true) int codigo) {

        productosServices.delete(codigo);
        List<Producto> productos = productosServices.findAll();
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("productos", productos);
        modelAndView.setViewName("productos/list");
        return modelAndView;
    }

    @RequestMapping(value = { "/nuevoProducto" })
    public ModelAndView nuevo() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("productos/nuevoProducto");
        return modelAndView;
    }

    @PostMapping(value = "/new")
    public ModelAndView saveCliente(Producto producto) {
        ModelAndView modelAndView = new ModelAndView();
        productosServices.insert(producto);

        List<Producto> productos = productosServices.findAll();
        
        modelAndView.addObject("productos", productos);
        modelAndView.setViewName("productos/list");
        return modelAndView;
    }

    /*
     * @GetMapping(path = { "/producto" })
     * public ModelAndView producto(@RequestParam(name = "codigo", required = true)
     * int codigo) {
     * ModelAndView modelAndView = new ModelAndView();
     * modelAndView.addObject("producto", getProducto(codigo));
     * modelAndView.setViewName("producto");
     * return modelAndView;
     * }
     * 
     * @GetMapping(path = { "/producto/{codigo}" })
     * public ModelAndView product(@PathVariable(name = "codigo", required = true)
     * int codigo) {
     * ModelAndView modelAndView = new ModelAndView();
     * modelAndView.addObject("producto", getProducto(codigo));
     * modelAndView.setViewName("producto");
     * return modelAndView;
     * }
     */

    /*
     * private Producto getProducto(int codigo) {
     * List<Producto> productos = productosServices.findAll();
     * int indexOf = productos.indexOf(new Producto(codigo));
     * 
     * return productos.get(indexOf);
     * }
     */

    /*
     * private List<Producto> getProductos() {
     * ArrayList<Producto> productos = new ArrayList<Producto>();
     * productos.add(new Producto(0, "Hamburguesa", "La hamburguesa esta muy rica",
     * "/img/hamburguesa.jpg"));
     * productos.add(new Producto(1, "pizza", "La pizza esta muy rica",
     * "/img/pizza.jpg"));
     * productos.add(new Producto(2, "perrito caliente",
     * "los hot-dog estan muy ricos", "/img/perrito-caliente.jpg"));
     * productos.add(new Producto(3, "coca cola", "La coca-cola esta muy rica",
     * "/img/cocacola.jpg"));
     * return productos;
     * }
     */
}
