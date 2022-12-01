package com.rgarmal.springproject.tienda.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.rgarmal.springproject.tienda.dao.ProductosDAO;
import com.rgarmal.springproject.tienda.model.Producto;
import com.rgarmal.springproject.tienda.services.ProductosServices;

@Service
public class ProductosServicesImpl implements ProductosServices {

    @Autowired
    ProductosDAO productosDAO;

    @Override
    public Page<Producto> findAll(Pageable page) {
        return productosDAO.findAll(page);
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

        if (producto.getImg() != null && producto.getImg().length > 0) {
            productosDAO.updateImageView(producto);
        }
    }

    @Override
    public void delete(int codigo) {
        productosDAO.delete(codigo);
    }

    @Override
    public Producto findLast() {
        return productosDAO.findLast();
    }

}
