package com.rgarmal.springproject.tienda.dao.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.lang.Nullable;

import com.rgarmal.springproject.tienda.model.Producto;

public class ProductoMapper implements org.springframework.jdbc.core.RowMapper<Producto> {

    @Override
    @Nullable
    public Producto mapRow(ResultSet rs, int rowNum) throws SQLException {
        Producto producto = new Producto();
        producto.setCodigo(rs.getInt("codigo"));
        producto.setNombre(rs.getString("nombre"));
        producto.setDescripcion(rs.getString("descripcion"));
        producto.setPrecio(rs.getFloat("precio"));
        return producto;
    }

}
