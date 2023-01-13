package com.rgarmal.springproject.tienda.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.rgarmal.springproject.tienda.dao.ClientesDAO;
import com.rgarmal.springproject.tienda.dao.DetallePedidoDAO;
import com.rgarmal.springproject.tienda.dao.PedidosDAO;
import com.rgarmal.springproject.tienda.model.Cliente;
import com.rgarmal.springproject.tienda.model.DetallePedido;
import com.rgarmal.springproject.tienda.model.Pedido;
import com.rgarmal.springproject.tienda.services.ClientesServices;
import com.rgarmal.springproject.tienda.services.PedidosServices;

@Service
public class PedidosServicesImpl implements PedidosServices{

    @Autowired
    PedidosDAO pedidosDAO;

    @Autowired
    DetallePedidoDAO detallePedidoDAO;

    @Autowired
    ClientesDAO clientesDAO;

    @Override
    public Page<Pedido> findAll(Pageable pageable) {
        return pedidosDAO.findAll(pageable);
    }

    @Override
    public Pedido find(int codigo) {
        Pedido pedido = pedidosDAO.findById(codigo);

        Cliente cliente = clientesDAO.findById(pedido.getCliente().getCodigo());

        pedido.setCliente(cliente);

        List<DetallePedido> detalle = detallePedidoDAO.findDetalle(pedido);
        pedido.setDetallePedidos(detalle);
        
        return pedido;
    }

    @Override
    public void save(Pedido pedido) {
        
        pedidosDAO.insert(pedido);

        List<DetallePedido> detallePedidos = pedido.getDetallePedidos();
        for (DetallePedido detallePedido : detallePedidos) {
            detallePedidoDAO.insert(pedido, detallePedido);
        }

    }

    // @Override
    // public void update(Pedido pedido) {
    //     pedidosDAO.update(pedido);
    // }

    @Override
    public void delete(int codigo) {
        pedidosDAO.delete(codigo);        
    }
    
}