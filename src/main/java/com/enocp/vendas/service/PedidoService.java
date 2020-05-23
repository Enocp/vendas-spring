package com.enocp.vendas.service;

import com.enocp.vendas.domain.entity.Pedido;
import com.enocp.vendas.rest.dto.PedidoDTO;

import java.util.Optional;

public interface PedidoService {
    Pedido salvar(PedidoDTO dto);

   Optional<Pedido>  obterPedidoCompleto(Integer id);

}

