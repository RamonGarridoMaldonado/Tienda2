package com.rgarmal.springproject.tienda.services;

import java.util.List;

import com.rgarmal.springproject.tienda.model.Producto;

public interface ProductosServices {
    
    public List<Producto> findAll();
    public Producto findById(int codigo);
    public void insert(Producto producto);
    public void update(Producto producto);
    public void delete(int codigo);

}
