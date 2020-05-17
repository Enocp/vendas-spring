package com.enocp.vendas.domain.repositorio;

import com.enocp.vendas.domain.entity.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

public interface Clientes extends JpaRepository<Cliente, Integer> {


    List<Cliente> findByNomeLike(String nomme);

   // List<Cliente> findByNomeOrId(String nomme, Integer id);
    boolean existsByNome(String nome);

}
