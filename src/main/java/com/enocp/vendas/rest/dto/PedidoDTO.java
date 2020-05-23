package com.enocp.vendas.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PedidoDTO {
    @NotNull(message = "Informe o Código do cliente")
    private Integer cliente;
    @NotNull(message = "Campo total do pedido é obrigatorio   ")
    private BigDecimal total;

    private List<ItemPedidoDTO> items;

}
