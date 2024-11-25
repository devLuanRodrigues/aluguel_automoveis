package com.java.automoveis.model;

import java.time.LocalDate;

public class ComprovanteReserva {

    private Cliente cliente;
    private Veiculo veiculo;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private int diasAlugados;
    private double valorTotal;
    private String formaPagamento;
    private String numeroComprovante;

    // Construtor
    public ComprovanteReserva(Cliente cliente, Veiculo veiculo, LocalDate dataInicio, LocalDate dataFim, int diasAlugados, double valorTotal, String formaPagamento) {
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.diasAlugados = diasAlugados;
        this.valorTotal = valorTotal;
        this.formaPagamento = formaPagamento;
        this.numeroComprovante = gerarNumeroComprovante();
    }

    // Método para gerar número do comprovante (simulação de um código único)
    private String gerarNumeroComprovante() {
        return "RES-" + System.currentTimeMillis();
    }

    // Getters e Setters
    public Cliente getCliente() {
        return cliente;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public int getDiasAlugados() {
        return diasAlugados;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public String getNumeroComprovante() {
        return numeroComprovante;
    }
}
