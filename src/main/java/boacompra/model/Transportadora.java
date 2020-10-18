package boacompra.model;

import java.math.BigDecimal;

import boacompra.service.CalculaValor;

public class Transportadora {

	private String nome;
	private CalculaValor calculaValor;

	public Transportadora(String nome, CalculaValor calculaValor) {
		this.nome = nome;
		this.calculaValor = calculaValor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public CalculaValor getCalculaValor() {
		return calculaValor;
	}

	public void setCalculaValor(CalculaValor calculaValor) {
		this.calculaValor = calculaValor;
	}
	
	public BigDecimal calcularFrete(Brinde brinde) {
		return this.calculaValor.calcular(brinde);
	}

}
