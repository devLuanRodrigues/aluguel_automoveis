package com.java.automoveis.model;

public class Carro extends Veiculo {
	
    private int portas;

    public Carro(String modelo, double precoDiaria, int portas) {
        super(modelo, precoDiaria);
        this.portas = portas;
    }

    public int getPortas() {
        return portas;
    }
}