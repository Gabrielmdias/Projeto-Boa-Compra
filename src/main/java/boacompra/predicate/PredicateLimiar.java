package boacompra.predicate;

import java.math.BigDecimal;
import java.util.function.Predicate;

import boacompra.model.Brinde;

public class PredicateLimiar implements Predicate<Brinde>{
	
	private final Integer pesoLimiar;
	
	public PredicateLimiar(Integer pesoLimiar) {
		this.pesoLimiar = pesoLimiar;
	}

	@Override
	public boolean test(Brinde brinde) {
		return brinde.getProduto().getPeso().compareTo(new BigDecimal(this.pesoLimiar)) > 0;
	}
	
}
