package com.rgarmal.springproject.tienda.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Order;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import com.rgarmal.springproject.tienda.dao.ClientesDAO;
import com.rgarmal.springproject.tienda.dao.PedidosDAO;
import com.rgarmal.springproject.tienda.dao.mappers.ClienteMapper;
import com.rgarmal.springproject.tienda.model.Cliente;
import com.rgarmal.springproject.tienda.model.Pedido;

@Repository
public class PedidosDAOimpl extends JdbcDaoSupport implements PedidosDAO {

    @Autowired
    DataSource dataSource;

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }

    @Override
    public Page<Pedido> findAll(Pageable page) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Pedido findById(int codigo) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void insert(Pedido pedido) {
             
    }

    @Override
    public void update(Pedido pedido) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void updateImageView(Pedido pedido) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Pedido findLast() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void delete(int codigo) {
        // TODO Auto-generated method stub
        
    }

    
}
