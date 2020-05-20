package com.enocp.vendas.domain.repositorio;

import com.enocp.vendas.domain.entity.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

public interface Clientes extends JpaRepository<Cliente, Integer> {

    @Query(value =" select * from Cliente c where c.nome like '%:nome%' ", nativeQuery =  true)
    List<Cliente> encontrarPorNome( @Param("nome") String nomme);
   // List<Cliente> findByNomeOrId(String nomme, Integer id);

    @Query("delete from Cliente c where c.nome =: nome ")
    @Modifying
    void deleteByNome(String nome);

    boolean existsByNome(String nome);

}
