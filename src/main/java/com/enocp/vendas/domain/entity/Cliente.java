package com.enocp.vendas.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table( name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "nome", length = 100)
    @NotEmpty(message = "Campo nome é obrigatorio")
    private String nome;

    @NotEmpty(message = "Campo CPF é obrigatorio")
    @CPF(message = "Informe um cpf valido")
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Column(name = "cpf", length =  11)
    private String cpf;

    @JsonIgnore
    @OneToMany(mappedBy= "cliente", fetch = FetchType.LAZY)
    private Set<Pedido> pedidos;

    public Set<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(Set<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public Cliente(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }


}