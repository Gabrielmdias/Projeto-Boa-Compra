package boacompra.service;

import java.math.BigDecimal;

import boacompra.model.Brinde;

public class CalculaFrete implements CalculaValor {
	
	private final BigDecimal valorFixo;
	private final BigDecimal valorKmKg;

	public CalculaFrete(BigDecimal valorFixo, BigDecimal valorKmKg) {
		this.valorFixo = valorFixo;
		this.valorKmKg = valorKmKg;
	}

	@Override
	public BigDecimal calcular(Brinde brinde) {
		return this.valorFixo.add(new BigDecimal(brinde.getDistancia())
				.multiply(this.valorKmKg).multiply(brinde.getPeso()));
		
	}

}
