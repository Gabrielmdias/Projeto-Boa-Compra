package boacompra.model.builder;

import java.math.BigDecimal;

import boacompra.model.Brinde;
import boacompra.model.Produto;

public class BrindeBuilder {

	private Produto produto;
	private Integer distancia;
	private BigDecimal peso;

	public BrindeBuilder setProduto(Produto produto) {
		this.produto = produto;
		return this;
	}

	public BrindeBuilder setDistancia(Integer distancia) {
		this.distancia = distancia;
		return this;
	}

	public BrindeBuilder setPeso(BigDecimal peso) {
		this.peso = peso;
		return this;
	}

	public Brinde build() {
		return new Brinde(produto, distancia, peso);
	}
}
