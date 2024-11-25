package com.java.automoveis;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.java.automoveis.model.Aluguel;
import com.java.automoveis.model.Cliente;
import com.java.automoveis.model.Veiculo;
import com.java.automoveis.model.Carro;
import com.java.automoveis.model.Moto;
import com.java.automoveis.model.Caminhao;

public class Main {

    private static List<Cliente> clientes = new ArrayList<>();
    private static List<Veiculo> veiculos = new ArrayList<>();
    private static List<Aluguel> alugueis = new ArrayList<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n======================================");
            System.out.println("    SISTEMA DE ALUGUEL DE AUTOMÓVEIS");
            System.out.println("======================================");
            System.out.println("1. Cadastrar Cliente");
            System.out.println("2. Cadastrar Veículo");
            System.out.println("3. Confirmar Aluguel");
            System.out.println("4. Listar Clientes");
            System.out.println("5. Listar Veículos Cadastrados");
            System.out.println("6. Listar Aluguéis");
            System.out.println("7. Sair");
            System.out.println("======================================");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer

            switch (opcao) {
                case 1:
                    cadastrarCliente(scanner);
                    break;

                case 2:
                    cadastrarVeiculo(scanner);
                    break;

                case 3:
                    confirmarAluguel(scanner);
                    break;

                case 4:
                    listarClientes();
                    break;

                case 5:
                    listarVeiculos();
                    break;

                case 6:
                    listarAlugueis();
                    break;

                case 7:
                    running = false;
                    System.out.println("\nEncerrando o sistema...");
                    System.out.println("======================================");
                    break;

                default:
                    System.out.println("\nOpção inválida. Tente novamente.");
                    System.out.println("======================================");
                    break;
            }
        }

        scanner.close();
    }

    private static void cadastrarCliente(Scanner scanner) {
        System.out.println("\n--- CADASTRO DE CLIENTE ---");
        System.out.print("Nome do Cliente: ");
        String nome = scanner.nextLine();
        System.out.print("CPF do Cliente: ");
        String cpf = scanner.nextLine();

        Cliente cliente = new Cliente(nome, cpf);
        clientes.add(cliente);

        System.out.println("\nCliente cadastrado com sucesso!");
        System.out.println("------------------------------");
    }

    private static void cadastrarVeiculo(Scanner scanner) {
        System.out.println("\n--- CADASTRO DE VEÍCULO ---");
        System.out.print("Tipo do Veículo (Carro/Moto/Caminhão): ");
        String tipoVeiculo = scanner.nextLine().toLowerCase();
        System.out.print("Modelo do Veículo: ");
        String modelo = scanner.nextLine();
        System.out.print("Preço da diária: ");
        double precoDiaria = scanner.nextDouble();
        scanner.nextLine();

        Veiculo veiculo;
        if ("carro".equals(tipoVeiculo)) {
            System.out.print("Número de portas: ");
            int portas = scanner.nextInt();
            scanner.nextLine();
            veiculo = new Carro(modelo, precoDiaria, portas);
        } else if ("moto".equals(tipoVeiculo)) {
            System.out.print("Possui bagageiro? (true/false): ");
            boolean bagageiro = scanner.nextBoolean();
            scanner.nextLine();
            veiculo = new Moto(modelo, precoDiaria, bagageiro);
        } else if ("caminhao".equals(tipoVeiculo)) {
            System.out.print("Capacidade de carga (em toneladas): ");
            double capacidadeCarga = scanner.nextDouble();
            scanner.nextLine();
            veiculo = new Caminhao(modelo, precoDiaria, capacidadeCarga);
        } else {
            System.out.println("\nTipo de veículo inválido.");
            return;
        }

        veiculos.add(veiculo);
        System.out.println("\nVeículo cadastrado com sucesso!");
        System.out.println("------------------------------");
    }

    private static void confirmarAluguel(Scanner scanner) {
        if (clientes.isEmpty() || veiculos.isEmpty()) {
            System.out.println("\nÉ necessário ter pelo menos um cliente e um veículo cadastrados para confirmar um aluguel.");
            System.out.println("======================================");
            return;
        }

        System.out.println("\n--- CONFIRMAR ALUGUEL ---");

        System.out.println("\nClientes disponíveis:");
        for (int i = 0; i < clientes.size(); i++) {
            System.out.println((i + 1) + ". " + clientes.get(i).getNome());
        }
        System.out.print("\nEscolha o cliente pelo número: ");
        int clienteIndex = scanner.nextInt() - 1;
        scanner.nextLine();

        System.out.println("\nVeículos disponíveis:");
        for (int i = 0; i < veiculos.size(); i++) {
            System.out.println((i + 1) + ". " + veiculos.get(i).getModelo() + " - R$" + veiculos.get(i).getPrecoDiaria() + "/dia");
        }
        System.out.print("\nEscolha o veículo pelo número: ");
        int veiculoIndex = scanner.nextInt() - 1;
        scanner.nextLine();

        System.out.print("\nQuantidade de dias para o aluguel: ");
        int dias = scanner.nextInt();
        scanner.nextLine();

        System.out.println("\nFormas de pagamento:");
        System.out.println("1. Dinheiro");
        System.out.println("2. Cartão de Crédito");
        System.out.println("3. PIX");
        System.out.println("4. Outra forma de pagamento");
        System.out.print("\nEscolha a forma de pagamento: ");
        int pagamentoOpcao = scanner.nextInt();
        scanner.nextLine();

        String formaPagamento;
        switch (pagamentoOpcao) {
            case 1:
                formaPagamento = "Dinheiro";
                break;
            case 2:
                formaPagamento = "Cartão de Crédito";
                break;
            case 3:
                formaPagamento = "PIX";
                break;
            case 4:
                System.out.print("\nEspecifique a forma de pagamento: ");
                formaPagamento = scanner.nextLine();
                break;
            default:
                System.out.println("\nOpção inválida. Pagamento padrão: 'Não especificado'.");
                formaPagamento = "Não especificado";
                break;
        }

        Cliente cliente = clientes.get(clienteIndex);
        Veiculo veiculo = veiculos.get(veiculoIndex);
        Aluguel aluguel = new Aluguel(cliente, veiculo, dias, formaPagamento);

        alugueis.add(aluguel);

        System.out.println("\n======================================");
        System.out.println("            NOTA FISCAL              ");
        System.out.println("======================================");
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("Veículo: " + veiculo.getModelo());
        System.out.println("Dias: " + dias);
        System.out.println("Data de Início: " + aluguel.getDataInicio());
        System.out.println("Data de Fim: " + aluguel.getDataFim());
        System.out.println("Valor Total: R$" + aluguel.getValorTotal());
        System.out.println("Forma de Pagamento: " + formaPagamento);
        System.out.println("======================================");
    }

    private static void listarClientes() {
        if (clientes.isEmpty()) {
            System.out.println("\nNenhum cliente cadastrado.");
            System.out.println("------------------------------");
            return;
        }

        System.out.println("\n--- CLIENTES CADASTRADOS ---");
        for (Cliente cliente : clientes) {
            System.out.println("Nome: " + cliente.getNome() + ", CPF: " + cliente.getCpf());
        }
        System.out.println("------------------------------");
    }

    private static void listarVeiculos() {
        if (veiculos.isEmpty()) {
            System.out.println("\nNenhum veículo cadastrado.");
            System.out.println("------------------------------");
            return;
        }

        System.out.println("\n--- VEÍCULOS CADASTRADOS ---");
        for (Veiculo veiculo : veiculos) {
            System.out.println("Modelo: " + veiculo.getModelo() +
                    ", Preço da diária: R$" + veiculo.getPrecoDiaria());
        }
        System.out.println("------------------------------");
    }

    private static void listarAlugueis() {
        if (alugueis.isEmpty()) {
            System.out.println("\nNenhum aluguel registrado.");
            System.out.println("------------------------------");
            return;
        }

        System.out.println("\n--- ALUGUÉIS REGISTRADOS ---");
        for (Aluguel aluguel : alugueis) {
            System.out.println("Cliente: " + aluguel.getCliente().getNome() +
                    ", Veículo: " + aluguel.getVeiculo().getModelo() +
                    ", Dias: " + aluguel.getDias() +
                    ", Valor Total: R$" + aluguel.getValorTotal() +
                    ", Forma de Pagamento: " + aluguel.getFormaPagamento());
        }
        System.out.println("------------------------------");
    }
}
