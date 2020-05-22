package com.enocp.vendas.service;

import com.enocp.vendas.domain.entity.Pedido;
import com.enocp.vendas.rest.dto.PedidoDTO;

public interface PedidoService {
    Pedido salvar(PedidoDTO dto);


}

