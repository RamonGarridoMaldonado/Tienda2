package com.rgarmal.springproject.tienda.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import com.rgarmal.springproject.tienda.model.Producto;

public interface ProductosServices {

    public Page<Producto> findAll(Pageable page);

    public Producto findById(int codigo);

    public void insert(Producto producto);

    public void update(Producto producto);
    
    public Producto findLast();

    public void delete(int codigo);

}
