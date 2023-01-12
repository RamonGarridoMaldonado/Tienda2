package com.rgarmal.springproject.tienda.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pedido {

    private int codigo;
    private Cliente cliente;
    private List<DetallePedido> detallePedido;
    private Date fecha;
    private double total;

    public Pedido() {
        this.cliente = new Cliente();
        this.detallePedido = new ArrayList<DetallePedido>();
    }

    public Pedido(int codigo) {
        this.codigo = codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<DetallePedido> getDetallePedido() {
        return detallePedido;
    }

    public void setDetallePedido(List<DetallePedido> detallePedido) {
        this.detallePedido = detallePedido;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getTotalCesta() {
        total = 0;
        for (DetallePedido detalle : this.detallePedido) {
            total += detalle.getCantidad() * detalle.getProducto().getPrecio();
        }
        return total;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + codigo;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Pedido other = (Pedido) obj;
        if (codigo != other.codigo)
            return false;
        return true;
    }

    public double getTotal() {
        return total;
    }

}
