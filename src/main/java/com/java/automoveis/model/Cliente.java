package com.java.automoveis.model;

import jakarta.persistence.*;

public class Cliente extends Pessoa {

    public Cliente(String nome, String cpf) {
        super(nome, cpf);
    }

    public Cliente() { } // Construtor padrão para Hibernate
}

