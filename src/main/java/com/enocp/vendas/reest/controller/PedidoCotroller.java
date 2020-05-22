package com.enocp.vendas.reest.controller;

import com.enocp.vendas.service.PedidoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoCotroller {
    private PedidoService service ;

    public PedidoCotroller(PedidoService service){
        this.service = service;
    }

}
