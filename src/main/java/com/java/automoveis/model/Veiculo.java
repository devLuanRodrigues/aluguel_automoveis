package com.java.automoveis.model;

import jakarta.persistence.*;

public abstract class Veiculo {

	private int id;

	private String modelo;
	private double precoDiaria;

	public Veiculo(String modelo, double precoDiaria) {
		this.modelo = modelo;
		this.precoDiaria = precoDiaria;
	}

	public Veiculo() { }

	public int getId() {
		return id;
	}

	public String getModelo() {
		return modelo;
	}

	public double getPrecoDiaria() {
		return precoDiaria;
	}
}
