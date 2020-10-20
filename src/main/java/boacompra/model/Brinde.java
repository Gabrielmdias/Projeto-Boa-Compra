package boacompra.model;

public class Brinde {

	private Produto produto;
	private Integer distancia;

	public Brinde(Produto produto, Integer distancia) {
		this.produto = produto;
		this.distancia = distancia;
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

	@Override
	public String toString() {
		return "Brinde [produto=" + produto + ", distancia=" + distancia + "]";
	}

}
