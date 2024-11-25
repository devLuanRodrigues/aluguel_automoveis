package com.java.automoveis.service;

import java.util.ArrayList;
import java.util.List;
import com.java.automoveis.model.Cliente;

public class ClienteService {

    private List<Cliente> clientes = new ArrayList<>();

    public void cadastrarCliente(Cliente cliente) {
        clientes.add(cliente);
        System.out.println("Cliente cadastrado: " + cliente.getNome());
    }

    public Cliente buscarCliente(String cpf) {
        return clientes.stream()
                .filter(c -> c.getCpf().equals(cpf))
                .findFirst()
                .orElse(null);
    }

    public Cliente buscarClientePorId(int clienteId) {
        return clientes.stream()
                .filter(c -> c.getId() == clienteId)
                .findFirst()
                .orElse(null);
    }

    // Outros métodos para atualizar ou remover cliente...
}
