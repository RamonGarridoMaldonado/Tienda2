package com.rgarmal.springproject.tienda.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.rgarmal.springproject.tienda.dao.ClientesDAO;
import com.rgarmal.springproject.tienda.dao.PedidosDAO;
import com.rgarmal.springproject.tienda.model.Cliente;
import com.rgarmal.springproject.tienda.model.Pedido;
import com.rgarmal.springproject.tienda.services.ClientesServices;
import com.rgarmal.springproject.tienda.services.PedidosServices;

@Service
public class PedidosServicesImpl implements PedidosServices {

    @Autowired
    PedidosDAO pedidosDAO;

    @Override
    public Page<Pedido> findAll(Pageable page) {
        return pedidosDAO.findAll(page);
    }

    @Override
    public Pedido findById(int codigo) {
        return pedidosDAO.findById(codigo);

    }

    @Override
    public void insert(Pedido pedido) {
        pedidosDAO.insert(pedido);        
    }

    @Override
    public void update(Pedido pedido) {
        pedidosDAO.update(pedido);        
    }

    @Override
    public Pedido findLast() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void delete(int codigo) {
        pedidosDAO.delete(codigo);        
    }
}
