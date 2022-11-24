package com.rgarmal.springproject.tienda.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rgarmal.springproject.tienda.dao.ProductosDAO;
import com.rgarmal.springproject.tienda.model.Producto;
import com.rgarmal.springproject.tienda.services.ProductosServices;

@Service
public class ProductosServicesImpl implements ProductosServices {

    @Autowired
    ProductosDAO productosDAO;

    @Override
    public List<Producto> findAll() {
        return productosDAO.findAll();
    }

    @Override
    public Producto findById(int codigo) {
        return productosDAO.findById(codigo);
    }

    @Override
    public void insert(Producto producto) {
        productosDAO.insert(producto);
    }

    @Override
    public void update(Producto producto) {
        productosDAO.update(producto);
    }

    @Override
    public void delete(int codigo) {
        productosDAO.delete(codigo);
    }

}
