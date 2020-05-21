package com.enocp.vendas.reest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api/cliente")
public class ClienteController {

    @RequestMapping(
            value = "/hello/{nome}",
            method = RequestMethod.POST,
            consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"}
     )
    @ResponseBody
    public String helloCLiente( @PathVariable("nome") String nomeCliente) {

        return  String.format("Hello %s ", nomeCliente);
    }
}
