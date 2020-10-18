package boacompra.service;

import java.math.BigDecimal;

import boacompra.model.Brinde;

public interface CalculaValor {

	BigDecimal calcular(Brinde brinde);
	
}
