package boacompra.sorteio;

import java.math.BigDecimal;

import boacompra.model.Brinde;
import boacompra.model.Produto;
import boacompra.model.Transportadora;
import boacompra.model.builder.BrindeBuilder;
import boacompra.predicate.PredicateLimiar;
import boacompra.service.CalculaFrete;
import boacompra.service.CalculaFretePredicate;

public class BoaCompraApplication {

	public static void main(String[] args) {

		Transportadora transboa = new Transportadora("Transboa", new CalculaFretePredicate(new PredicateLimiar(5),
				new CalculaFrete(new BigDecimal("10.00"), new BigDecimal("0.01")), new CalculaFrete(new BigDecimal("2.10"), new BigDecimal("1.10"))));
		
		Transportadora boaDex = new Transportadora("boaDex", new CalculaFrete(new BigDecimal("10.00"), new BigDecimal("0.05")));
		
		Transportadora boaLog = new Transportadora("boaLog", new CalculaFrete(new BigDecimal("4.30"), new BigDecimal("0.12")));

		Produto foneDeOuvido = new Produto("Fone de ouvido");

		Brinde brinde = new BrindeBuilder().setProduto(foneDeOuvido).setDistancia(65).setPeso(new BigDecimal("1"))
				.build();

		System.out.println(transboa.calcularFrete(brinde));
		System.out.println(boaDex.calcularFrete(brinde));
		System.out.println(boaLog.calcularFrete(brinde));
	}
}
