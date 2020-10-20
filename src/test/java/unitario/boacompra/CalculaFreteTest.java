package unitario.boacompra;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

import boacompra.model.Brinde;
import boacompra.model.Produto;
import boacompra.model.Transportadora;
import boacompra.predicate.PredicateLimiar;
import boacompra.service.CalculaFrete;
import boacompra.service.CalculaFretePredicate;

public class CalculaFreteTest {

	@Test
	public void calculaFreteTest() throws Exception {
		Transportadora transboa = new Transportadora("Transboa", new CalculaFretePredicate(new PredicateLimiar(5),
				new CalculaFrete(new BigDecimal("10.00"), new BigDecimal("0.01")), new CalculaFrete(new BigDecimal("2.10"), new BigDecimal("1.10"))));
		
		Transportadora boaDex = new Transportadora("boaDex", new CalculaFrete(new BigDecimal("10.00"), new BigDecimal("0.05")));
		
		Transportadora boaLog = new Transportadora("boaLog", new CalculaFrete(new BigDecimal("4.30"), new BigDecimal("0.12")));

		Produto foneDeOuvido = new Produto("Fone de ouvido", new BigDecimal("1"));
		
		Produto pcGamer = new Produto("Pc Gamer", new BigDecimal("35"));

		Brinde brindeFone65 = new Brinde(foneDeOuvido, 65);
		assertEquals(new BigDecimal("73.60"), transboa.calcularFrete(brindeFone65).setScale(2));
		assertEquals(new BigDecimal("13.25"), boaDex.calcularFrete(brindeFone65).setScale(2));
		assertEquals(new BigDecimal("12.10"), boaLog.calcularFrete(brindeFone65).setScale(2));
		
		Brinde brindeFone430 = new Brinde(foneDeOuvido, 430);
		assertEquals(new BigDecimal("475.10"), transboa.calcularFrete(brindeFone430).setScale(2));
		assertEquals(new BigDecimal("31.50"), boaDex.calcularFrete(brindeFone430).setScale(2));
		assertEquals(new BigDecimal("55.90"), boaLog.calcularFrete(brindeFone430).setScale(2));
		
		Brinde brindePcGamer1 = new Brinde(pcGamer, 1);
		assertEquals(new BigDecimal("10.35"), transboa.calcularFrete(brindePcGamer1).setScale(2));
		assertEquals(new BigDecimal("11.75"), boaDex.calcularFrete(brindePcGamer1).setScale(2));
		assertEquals(new BigDecimal("8.50"), boaLog.calcularFrete(brindePcGamer1).setScale(2));
		
		Brinde brindePcGamer1000 = new Brinde(pcGamer, 1000);
		assertEquals(new BigDecimal("360.00"), transboa.calcularFrete(brindePcGamer1000).setScale(2));
		assertEquals(new BigDecimal("1760.00"), boaDex.calcularFrete(brindePcGamer1000).setScale(2));
		assertEquals(new BigDecimal("4204.30"), boaLog.calcularFrete(brindePcGamer1000).setScale(2));

	}

}
