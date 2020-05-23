package com.enocp.vendas.exception;

public class PedidoNaoEncontradooException extends RuntimeException {
    public PedidoNaoEncontradooException() {
        super("Pediddo não encontrado");
    }
}
