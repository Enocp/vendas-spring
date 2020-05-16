package com.enocp.vendas.domain.repositorio;

import com.enocp.vendas.domain.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class Clientes {

    private static String INSERT = "insert into cliente (nome) values (?)";

    @Autowired
    private JdbcTemplate JdbcTemplate;

    public Cliente salvar (Cliente cliente) {
        JdbcTemplate.update(INSERT, new Object[]{cliente.getNome()});
        return cliente;
    }

}
