package com.java.automoveis.service;

import com.java.automoveis.model.Aluguel;
import com.java.automoveis.model.Cliente;
import com.java.automoveis.model.Veiculo;

import java.util.ArrayList;
import java.util.List;

public class AluguelService {

    private List<Aluguel> historicoAluguel = new ArrayList<>();
    private List<Veiculo> veiculosCadastrados = new ArrayList<>();  // Lista de veículos cadastrados

    // Método para buscar um veículo pelo ID
    public Veiculo buscarVeiculo(int veiculoId) {
        return veiculosCadastrados.stream()
                .filter(v -> v.getId() == veiculoId)  // Verifica se o ID do veículo é igual
                .findFirst()
                .orElse(null);  // Retorna null se não encontrar o veículo
    }

    // Método para realizar aluguel
    public void realizarAluguel(Cliente cliente, Veiculo veiculo, int dias, String formaPagamento) {
        Aluguel aluguel = new Aluguel(cliente, veiculo, dias);
        historicoAluguel.add(aluguel);
        System.out.println("Aluguel realizado: " + cliente.getNome() + " alugou " + veiculo.getModelo() + " por " + dias + " dias.");
        System.out.println("Forma de pagamento escolhida: " + formaPagamento);
    }

    // Método para exibir o histórico de aluguéis de um cliente
    public void exibirHistoricoAluguel(int clienteId) {
        System.out.println("Histórico de Aluguéis para o cliente com ID: " + clienteId);
        boolean found = false;

        for (Aluguel aluguel : historicoAluguel) {
            if (aluguel.getCliente().getId() == clienteId) {
                found = true;
                System.out.println("- Veículo: " + aluguel.getVeiculo().getModelo());
                System.out.println("  Dias alugados: " + aluguel.getDias());
                System.out.println("  Valor total: R$ " + (aluguel.getDias() * aluguel.getVeiculo().getPrecoDiaria()));
            }
        }

        if (!found) {
            System.out.println("Nenhum histórico de aluguel encontrado para este cliente.");
        }
    }

    // Método para cadastrar um novo veículo
    public void cadastrarVeiculo(Veiculo veiculo) {
        veiculosCadastrados.add(veiculo);
        System.out.println("Veículo cadastrado: " + veiculo.getModelo());
    }
}
