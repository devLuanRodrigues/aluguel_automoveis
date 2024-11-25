package com.java.automoveis.model;

public class Caminhao extends Veiculo {
	
    private double capacidadeCarga;

    public Caminhao(String modelo, double precoDiaria, double capacidadeCarga) {
        super(modelo, precoDiaria);
        this.capacidadeCarga = capacidadeCarga;
    }

    public double getCapacidadeCarga() {
        return capacidadeCarga;
    }
}