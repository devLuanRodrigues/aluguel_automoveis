package com.java.automoveis.model;

public class Moto extends Veiculo {
	
    private boolean possuiBagageiro;

    public Moto(String modelo, double precoDiaria, boolean possuiBagageiro) {
        super(modelo, precoDiaria);
        this.possuiBagageiro = possuiBagageiro;
    }

    public boolean isPossuiBagageiro() {
        return possuiBagageiro;
    }
}