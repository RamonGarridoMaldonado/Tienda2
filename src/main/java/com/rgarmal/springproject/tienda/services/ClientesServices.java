package com.rgarmal.springproject.tienda.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.rgarmal.springproject.tienda.model.Cliente;

public interface ClientesServices {
    

    public Page<Cliente> findAll(Pageable page);
    public Cliente findById(int codigo);
    public void insert(Cliente cliente);
    public void update(Cliente cliente);
    public void delete(int codigo);
}
