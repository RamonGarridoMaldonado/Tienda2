package com.rgarmal.springproject.tienda.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.rgarmal.springproject.tienda.model.Pedido;


public interface PedidosDAO {

    public Page<Pedido> findAll(Pageable page);

    public Pedido findById(int codigo);

    public void insert(Pedido pedido);

    public void update(Pedido pedido);

    public void updateImageView(Pedido pedido);

    public Pedido findLast();

    public void delete(int codigo);
}
