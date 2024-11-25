package com.java.automoveis.model;

import java.time.LocalDate;

public class NotaFiscal {

    private int id;
    private Cliente cliente;
    private Veiculo veiculo;
    private LocalDate dataEmissao;
    private double valorTotal;
    private double impostos;
    private String tipoServico;
    private String numeroNotaFiscal;
    private String chaveDeAcesso;

    public NotaFiscal(Cliente cliente, Veiculo veiculo, double valorTotal, double impostos) {
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.dataEmissao = LocalDate.now();
        this.valorTotal = valorTotal;
        this.impostos = impostos;
        this.tipoServico = "Aluguel de Veículo";
        this.numeroNotaFiscal = gerarNumeroNotaFiscal();
        this.chaveDeAcesso = gerarChaveDeAcesso();
    }

    private String gerarNumeroNotaFiscal() {
        return "NFE" + System.currentTimeMillis();
    }

    private String gerarChaveDeAcesso() {
        return "CHAVE-" + System.currentTimeMillis();
    }
}
