package com.rgarmal.springproject.tienda.dao.impl;

import java.util.List;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.rgarmal.springproject.tienda.dao.ProductosDAO;
import com.rgarmal.springproject.tienda.model.Producto;

public class ProductosDAOimpl extends JdbcDaoSupport implements ProductosDAO{

    @Override
    public List<Producto> findAll() {
        
        return null;
    }

    @Override
    public Producto findById(int codigo) {
        
        return null;
    }

    @Override
    public void insert(Producto producto) {
        
        
    }

    @Override
    public void update(Producto producto) {
        
        
    }

    @Override
    public void delete(int codigo) {
        
        
    }
    
}
