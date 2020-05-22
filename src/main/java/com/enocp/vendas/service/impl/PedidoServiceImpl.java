package com.enocp.vendas.service.impl;

import com.enocp.vendas.domain.repository.Pedidos;
import com.enocp.vendas.service.PedidoService;
import org.springframework.stereotype.Service;

@Service
public class PedidoServiceImpl  implements PedidoService {

    private Pedidos repository;

    public PedidoServiceImpl(Pedidos repository) {
        this.repository = repository;
    }

}
