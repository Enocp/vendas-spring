package com.enocp.vendas.domain.entity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Pedidos extends JpaRepository <Pedido, Integer> {
}
