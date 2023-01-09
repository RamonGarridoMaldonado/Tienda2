package com.rgarmal.springproject.tienda.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.*;

import com.rgarmal.springproject.tienda.model.Producto;
import com.rgarmal.springproject.tienda.services.ProductosServices;

@Controller
@RequestMapping("productos")
public class ProductoController {

    @Autowired
    ProductosServices productosServices;

    @Value("${pagination.size}")
    int sizePage;

    /*
     * @RequestMapping(value = "/list")
     * public ModelAndView list() {
     * ModelAndView modelAndView = new ModelAndView();
     * 
     * List<Producto> productos = productosServices.findAll();
     * 
     * modelAndView.addObject("productos", productos);
     * modelAndView.setViewName("productos/list");
     * return modelAndView;
     * }
     */

    @GetMapping(value = "/list")
    public ModelAndView list(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:list/1/codigo/asc");
        return modelAndView;
    }

    @GetMapping(value = "/list/{numPage}/{fieldSort}/{directionSort}")
    public ModelAndView listPage(Model model,
            @PathVariable("numPage") Integer numPage,
            @PathVariable("fieldSort") String fieldSort,
            @PathVariable("directionSort") String directionSort) {

        Pageable pageable = PageRequest.of(numPage - 1, sizePage,
                directionSort.equals("asc") ? Sort.by(fieldSort).ascending() : Sort.by(fieldSort).descending());

        Page<Producto> page = productosServices.findAll(pageable);

        List<Producto> productos = page.getContent();

        ModelAndView modelAndView = new ModelAndView("productos/list");
        modelAndView.addObject("productos", productos);

        modelAndView.addObject("numPage", numPage);
        modelAndView.addObject("totalPages", page.getTotalPages());
        modelAndView.addObject("totalElements", page.getTotalElements());

        modelAndView.addObject("fieldSort", fieldSort);
        modelAndView.addObject("directionSort", directionSort.equals("asc") ? "asc" : "desc");

        return modelAndView;
    }

    @RequestMapping(value = "/modificarProducto")
    public ModelAndView edit(
            @RequestParam(name = "codigo", required = true) int codigo,boolean carrito) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("producto", productosServices.findById(codigo));
        modelAndView.addObject("carrito", carrito);
        modelAndView.setViewName("productos/edit");
        return modelAndView;
    }

    @PostMapping(value = "/edit")
    public ModelAndView editCliente(Producto producto, @RequestParam("file") MultipartFile imagen) throws IOException {
        ModelAndView modelAndView = new ModelAndView();

        producto.setImg(imagen.getBytes());
        productosServices.update(producto);

        modelAndView.setViewName("redirect:modificarProducto?codigo=" + producto.getCodigo());
        return modelAndView;
    }

    @RequestMapping(value = "/borrar")
    public ModelAndView delete(
            @RequestParam(name = "codigo", required = true) int codigo) {

        productosServices.delete(codigo);
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("redirect:list/1/codigo/asc");
        return modelAndView;
    }

    @RequestMapping(value = { "/nuevoProducto" })
    public ModelAndView nuevo() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("productos/nuevoProducto");
        return modelAndView;
    }

    @PostMapping(value = "/new")
    public ModelAndView saveCliente(Producto producto, @RequestParam("file") MultipartFile imagen) throws IOException {
        ModelAndView modelAndView = new ModelAndView();
        producto.setImg(imagen.getBytes());
        productosServices.insert(producto);

        // producto = productosServices.findLast();

        modelAndView.setViewName("redirect:modificarProducto?codigo=" + producto.getCodigo());
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
