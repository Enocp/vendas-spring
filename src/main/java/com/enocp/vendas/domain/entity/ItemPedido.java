package com.enocp.vendas.domain.entity;

public class ItemPedido {
    private Integer id;
    private Pedido pedido;
    private Produto produdo;
    private Integer quantidade;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Produto getProdudo() {
        return produdo;
    }

    public void setProdudo(Produto produdo) {
        this.produdo = produdo;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}
