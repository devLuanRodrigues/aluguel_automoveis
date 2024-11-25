package com.java.automoveis.model;

import java.time.LocalDate;

public class Pagamento {

    private int id;
    private Aluguel aluguel;
    private double valor;
    private LocalDate dataPagamento;
    private FormaPagamento formaPagamento;
    private boolean confirmado;

    public Pagamento() {}

    public Pagamento(Aluguel aluguel, double valor, LocalDate dataPagamento, FormaPagamento formaPagamento, boolean confirmado) {
        this.aluguel = aluguel;
        this.valor = valor;
        this.dataPagamento = dataPagamento;
        this.formaPagamento = formaPagamento;
        this.confirmado = confirmado;
    }

    public int getId() {
        return id;
    }

    public Aluguel getAluguel() {
        return aluguel;
    }

    public void setAluguel(Aluguel aluguel) {
        this.aluguel = aluguel;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public boolean isConfirmado() {
        return confirmado;
    }

    public void setConfirmado(boolean confirmado) {
        this.confirmado = confirmado;
    }
}
