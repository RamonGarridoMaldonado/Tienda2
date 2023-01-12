package com.rgarmal.springproject.tienda.dao;

import java.util.List;

import com.rgarmal.springproject.tienda.model.DetallePedido;
import com.rgarmal.springproject.tienda.model.Pedido;

public interface DetallePedidoDAO {

    public void insert(Pedido pedido, DetallePedido detallePedido);

    public List<DetallePedido> findDetalle(Pedido pedido);

}