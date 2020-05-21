package com.enocp.vendas.reest.controller;

import ch.qos.logback.core.net.server.Client;
import com.enocp.vendas.domain.entity.Cliente;
import com.enocp.vendas.domain.repository.Clientes;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
//@RequestMapping("/api/clientes")
public class ClienteController {

    public ClienteController(Clientes clientes) {
        this.clientes = clientes;
    }

    private Clientes clientes;

    @GetMapping("/api/clientes/{id}")
    @ResponseBody
    public ResponseEntity getClienteById( @PathVariable  Integer id){
        Optional<Cliente> cliente = clientes.findById(id);

        if(cliente.isPresent()){
          return ResponseEntity.ok(cliente.get());

        }
            return ResponseEntity.notFound().build();
    }
}

