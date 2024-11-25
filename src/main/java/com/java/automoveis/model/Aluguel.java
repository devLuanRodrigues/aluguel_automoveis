package com.java.automoveis.model;

import java.time.LocalDate;

public class Aluguel {

	private int id;
	private Cliente cliente;
	private Veiculo veiculo;
	private int dias;
	private LocalDate dataInicio;
	private LocalDate dataFim;
	private double valorTotal;
	private String formaPagamento;

	public Aluguel() {}

	public Aluguel(Cliente cliente, Veiculo veiculo, int dias) {
		this(cliente, veiculo, dias, "Não especificado");
	}

	public Aluguel(Cliente cliente, Veiculo veiculo, int dias, String formaPagamento) {
		this.cliente = cliente;
		this.veiculo = veiculo;
		this.dias = dias;
		this.dataInicio = LocalDate.now();
		this.dataFim = dataInicio.plusDays(dias);
		this.valorTotal = calcularValorTotal();
		this.formaPagamento = formaPagamento;
	}

	private double calcularValorTotal() {
		return dias * veiculo.getPrecoDiaria();
	}

	// Getters e Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public int getDias() {
		return dias;
	}

	public void setDias(int dias) {
		this.dias = dias;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDate getDataFim() {
		return dataFim;
	}

	public void setDataFim(LocalDate dataFim) {
		this.dataFim = dataFim;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public String getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}
}
