package com.java.automoveis.model;

public class Funcionario extends Pessoa {

	private String cargo;
	private double salario;

	public Funcionario(String nome, String cpf, String cargo, double salario) {
		super(nome, cpf);
		this.cargo = cargo;
		this.salario = salario;
	}

	public String getCargo() {
		return cargo;
	}

	public double getSalario() {
		return salario;
	}
}