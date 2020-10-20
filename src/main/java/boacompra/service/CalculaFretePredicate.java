package boacompra.service;

import java.math.BigDecimal;
import java.util.function.Predicate;

import boacompra.model.Brinde;

public class CalculaFretePredicate implements CalculaValor {

	private final Predicate<Brinde> predicado;
	private final CalculaValor calculaValorVerdade;
	private final CalculaValor calculaValorFalso;

	public CalculaFretePredicate(Predicate<Brinde> predicado, CalculaValor calculaValorVerdade,
			CalculaValor calculaValorFalso) {
		this.predicado = predicado;
		this.calculaValorVerdade = calculaValorVerdade;
		this.calculaValorFalso = calculaValorFalso;
	}

	@Override
	public BigDecimal calcular(Brinde brinde) {
		if (predicado.test(brinde)) {
			return this.calculaValorVerdade.calcular(brinde);
		} else {
			return this.calculaValorFalso.calcular(brinde);
		}
	}

}
