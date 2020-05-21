package com.enocp.vendas;

import com.enocp.vendas.domain.entity.Cliente;
import com.enocp.vendas.domain.entity.Pedido;
import com.enocp.vendas.domain.repository.Clientes;
import com.enocp.vendas.domain.repository.Pedidos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class VendasApplication {

	@Bean
	public CommandLineRunner init (
			@Autowired Clientes clientes,
			@Autowired Pedidos pedidos){

		return args -> {
			System.out.println("Salvando Cliente");
			//clientes.save(new Cliente("pierre"));
			Cliente pierre = new Cliente("pierre");
			clientes.save(pierre);

			Pedido p = new Pedido();
			p.setCliente(pierre);
			p.setDataPedido( LocalDate.now());
			p.setTotal(BigDecimal.valueOf(200));

			pedidos.save(p);

			//Cliente cliente = clientes.findClienteFetchPedidos(pierre.getId());
			//System.out.println(cliente);
			//System.out.println(cliente.getPedidos());

			pedidos.findByCliente(pierre).forEach(System.out::println);

		};
	}

	public static void main(String[] args) {
		SpringApplication.run(VendasApplication.class, args);
	}

}
