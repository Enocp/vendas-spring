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

			List<Cliente> todosClientes = clientes.findAll();
			todosClientes.forEach(System.out::println);

			System.out.println("Ataualizando Cliente");
			todosClientes.forEach(c-> {
				c.setNome(c.getNome() + " atualizado.");
				clientes.save(c);
			});



			todosClientes = clientes.findAll();
			todosClientes.forEach(System.out::println);

			System.out.println("Buscando  Cliente");
			clientes.findByNomeLike("ma").forEach(System.out::println);

			System.out.println("Deletando  Cliente");
			clientes.findAll().forEach(c -> {
				clientes.delete(c);
			});

			todosClientes = clientes.findAll();
			if (todosClientes.isEmpty()){
				System.out.println(" Nenhum  Cliente");

			}else{
				todosClientes.forEach(System.out::println);
			}

		};
	}

	public static void main(String[] args) {
		SpringApplication.run(VendasApplication.class, args);
	}

}
