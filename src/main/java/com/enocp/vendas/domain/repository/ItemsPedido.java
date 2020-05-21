package com.enocp.vendas.domain.repository;

import com.enocp.vendas.domain.entity.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemsPedido extends JpaRepository <ItemPedido, Integer> {
}
