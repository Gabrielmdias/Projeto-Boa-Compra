package boacompra.model;

import java.math.BigDecimal;

public class Brinde {

	private Produto produto;
	private Integer distancia;
	private BigDecimal peso;

	public Brinde(Produto produto, Integer distancia, BigDecimal peso) {
		this.produto = produto;
		this.distancia = distancia;
		this.peso = peso;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Integer getDistancia() {
		return distancia;
	}

	public void setDistancia(Integer distancia) {
		this.distancia = distancia;
	}

	public BigDecimal getPeso() {
		return peso;
	}

	public void setPeso(BigDecimal peso) {
		this.peso = peso;
	}

	@Override
	public String toString() {
		return "Brinde [produto=" + produto + ", distancia=" + distancia + ", peso=" + peso + "]";
	}

}
