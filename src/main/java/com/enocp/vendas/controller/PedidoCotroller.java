package com.enocp.vendas.controller;

import com.enocp.vendas.domain.entity.Pedido;
import com.enocp.vendas.rest.dto.PedidoDTO;
import com.enocp.vendas.service.PedidoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import static org.springframework.http.HttpStatus.*;



@RestController
@RequestMapping("/api/pedidos")
public class PedidoCotroller {
    private PedidoService service ;

    public PedidoCotroller(PedidoService service){
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public Integer save(@RequestBody PedidoDTO dto){
        Pedido pedido = service.salvar(dto);
        return pedido.getId();
    }
    public void testarDevTools(){

    }

}
