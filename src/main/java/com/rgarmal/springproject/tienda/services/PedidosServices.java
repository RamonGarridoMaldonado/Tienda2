package com.rgarmal.springproject.tienda.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import com.rgarmal.springproject.tienda.model.Pedido;

public interface PedidosServices {

    public Page<Pedido> findAll(Pageable page);
    public Pedido find(int codigo);
    public void save(Pedido pedido);
    // public void update(Pedido producto);
    public void delete(int codigo);

}
