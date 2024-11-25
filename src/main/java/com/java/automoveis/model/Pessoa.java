package com.java.automoveis.model;

import jakarta.persistence.*;

public abstract class Pessoa {

	private int id;

	private String nome;
	private String cpf;

	public Pessoa(String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
	}

	public Pessoa() { } // Construtor padrão para Hibernate

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}
}
