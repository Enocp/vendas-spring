package com.enocp.vendas.rest.dto;

import com.enocp.vendas.validation.NotEmptyList;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PedidoDTO {
    @NotNull(message = "{campo.codigo-cliente.obrgatorio}")
    private Integer cliente;
    @NotNull(message = "{campo.total-pedido.obrgatorio }")
    private BigDecimal total;

    @NotEmptyList(message = "{campo.items-pedido.obrgatorio}")
    private List<ItemPedidoDTO> items;

}
