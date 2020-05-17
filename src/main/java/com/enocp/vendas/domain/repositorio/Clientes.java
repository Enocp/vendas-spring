package com.enocp.vendas.domain.repositorio;

import com.enocp.vendas.domain.entity.Cliente;
import org.hibernate.sql.Select;
import org.hibernate.sql.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class Clientes {

    @Autowired
    private EntityManager enteityManager;

    @Transactional
    public Cliente salvar (Cliente cliente) {
       enteityManager.persist(cliente);
        return cliente;
    }
    @Transactional
    public Cliente atualizar (Cliente cliente){
        enteityManager.merge(cliente);
        return cliente;
    }

    @Transactional
    public void deletar(Cliente cliente){
      if (!enteityManager.contains(cliente)){
          cliente = enteityManager.merge((cliente));
      }
      enteityManager.remove(cliente);
    }

    @Transactional
    public void deletar(Integer id){
        Cliente cliente = enteityManager.find(Cliente.class, id);
        deletar(cliente);
    }

    @Transactional(readOnly = true)
    public List<Cliente> buscarPorNome(String nome){
        String jpql = "select c from Cliente c where  c.nome like : nome ";
       TypedQuery<Cliente> query =  enteityManager.createQuery(jpql, Cliente.class);
       query.setParameter("nome", "%" + "%");
       return query.getResultList();
    }

    @Transactional
    public List<Cliente> obterTodos(){
        return enteityManager
                .createQuery("from Cliente", Cliente.class)
                .getResultList();
    }

}
