package com.enocp.vendas.service.impl;

import com.enocp.vendas.domain.entity.Cliente;
import com.enocp.vendas.domain.entity.ItemPedido;
import com.enocp.vendas.domain.entity.Pedido;
import com.enocp.vendas.domain.entity.Produto;
import com.enocp.vendas.domain.enums.StatusPedido;
import com.enocp.vendas.domain.repository.Clientes;
import com.enocp.vendas.domain.repository.ItemsPedido;
import com.enocp.vendas.domain.repository.Pedidos;
import com.enocp.vendas.domain.repository.Produtos;
import com.enocp.vendas.exception.RegraNegocioException;
import com.enocp.vendas.rest.dto.ItemPedidoDTO;
import com.enocp.vendas.rest.dto.PedidoDTO;
import com.enocp.vendas.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaDialect;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PedidoServiceImpl  implements PedidoService {

    private final Pedidos repository;
    private final Clientes clientesRepository;
    private final Produtos produtosRepository;
    private final ItemsPedido itemsPedidoRepository;


    @Override
    @Transactional
     public Pedido salvar( PedidoDTO dto ) {
        Integer idCliente = dto.getCliente();
        Cliente cliente = clientesRepository
                .findById(idCliente)
                .orElseThrow(() -> new RegraNegocioException("Código de cliente inválido."));

        Pedido pedido = new Pedido();
        pedido.setTotal(dto.getTotal());
        pedido.setDataPedido(LocalDate.now());
        pedido.setCliente(cliente);
        pedido.setStatus(StatusPedido.REALIZAADO);

        List<ItemPedido> itemsPedido = converterItems(pedido, dto.getItems());
        repository.save(pedido);
        itemsPedidoRepository.saveAll(itemsPedido);
        pedido.setItens(itemsPedido);
        return pedido;
    }

    @Override
    public Optional<Pedido> obterPedidoCompleto(Integer id) {

        return repository.findByIdFetchItems(id);
    }
    private List<ItemPedido> converterItems(Pedido pedido, List<ItemPedidoDTO> items){
        if(items.isEmpty()){
            throw new RegraNegocioException("Não é possível realizar um pedido sem items.");
        }


        return items
                .stream()
                .map( dto -> {
                    Integer idProduto = dto.getProduto();
                    Produto produto = produtosRepository
                            .findById(idProduto)
                            .orElseThrow(
                                    () -> new RegraNegocioException(
                                            "Código de produto inválido: "+ idProduto
                                    ));

                    ItemPedido itemPedido = new ItemPedido();
                    itemPedido.setQuantidade(dto.getQuantidade());
                    itemPedido.setPedido(pedido);
                    itemPedido.setProduto(produto);
                    return itemPedido;
                }).collect(Collectors.toList());

    }
}
