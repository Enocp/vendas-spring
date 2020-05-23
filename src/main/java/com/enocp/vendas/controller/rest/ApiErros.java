package com.enocp.vendas.controller.rest;

import lombok.Data;
import lombok.Getter;
import org.apache.catalina.LifecycleState;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;


public class ApiErros {

    @Getter
    private List<String> errors;

    public ApiErros(List<String> errors) {
        this.errors = errors;
    }

    public ApiErros(String mensagemErro){
        this.errors = Arrays.asList(mensagemErro);
    }
}
