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

			boolean exists = clientes.existsByNome("pierre");
			System.out.println("existe un cliente com o nome Douglas? " + exists);
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(VendasApplication.class, args);
	}

}
