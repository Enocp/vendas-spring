package com.enocp.vendas.controller.rest;

import com.enocp.vendas.exception.PedidoNaoEncontradooException;
import com.enocp.vendas.exception.RegraNegocioException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppliationControllerAdvice {

    @ExceptionHandler(RegraNegocioException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErros handleRegraNegocioExceptiion(RegraNegocioException ex){
        String mensagemErro = ex.getMessage();
        return  new ApiErros(mensagemErro);
    }

    @ExceptionHandler(PedidoNaoEncontradooException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiErros handlePedidoNotFoundException(PedidoNaoEncontradooException ex){
        return  new ApiErros(ex.getMessage());

    }

}

