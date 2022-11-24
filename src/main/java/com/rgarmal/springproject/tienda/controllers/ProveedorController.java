package com.rgarmal.springproject.tienda.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.rgarmal.springproject.tienda.model.Proveedor;

@Controller
@RequestMapping("proveedores")
public class ProveedorController {

    @RequestMapping(value = "/listaProveedores")
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("proveedores", getProveedores());
        modelAndView.setViewName("proveedores/listaProveedores");
        return modelAndView;
    }

    private List<Proveedor> getProveedores() {
        ArrayList<Proveedor> proveedores = new ArrayList<Proveedor>();
        proveedores.add(new Proveedor(1,"Francisco","Linares Barragán"));
        proveedores.add(new Proveedor(2,"Juan","Linares"));
        proveedores.add(new Proveedor(3,"Manuel","Padilla"));
        proveedores.add(new Proveedor(4,"Andres","Férnandez"));
        return proveedores;
    }
    
}
