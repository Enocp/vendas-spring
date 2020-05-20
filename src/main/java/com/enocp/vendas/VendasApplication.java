package com.enocp.vendas;

import com.enocp.vendas.domain.entity.Cliente;
import com.enocp.vendas.domain.repositorio.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class VendasApplication {

	@Bean
	public CommandLineRunner init (@Autowired Clientes clientes){
		return args -> {
			System.out.println("Salvando Cliente");
			clientes.save(new Cliente("pierre"));
			clientes.save(new Cliente("marcia"));

			List<Cliente > result = clientes.encontrarPorNome("pierre");
			result.forEach(System.out::println);
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(VendasApplication.class, args);
	}

}
