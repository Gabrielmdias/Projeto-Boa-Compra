package boacompra;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import org.apache.commons.math3.util.Pair;
import org.json.simple.parser.ParseException;

import boacompra.model.Brinde;
import boacompra.model.Produto;
import boacompra.model.Transportadora;
import boacompra.util.JsonUtil;

public class BoaCompraApplication {

	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Entre com o nome do produto: ");
		String nome = scanner.nextLine();
		while (nome.length() < 3) {
			System.out.println("Digite um nome com no mínimo 3 caracteres: ");
			nome = scanner.nextLine();
		}
		System.out.println("Entre com o peso do produto: ");
		Double peso = scanner.nextDouble();
		while (peso <= 0) {
			System.out.println("Entre com um peso maior que zero: ");
			peso = scanner.nextDouble();
		}
		System.out.println("Entre com a distancia: ");
		int distancia = scanner.nextInt();
		while (distancia <= 0) {
			System.out.println("Entre com uma distancia maior que zero: ");
			distancia = scanner.nextInt();
		}
		scanner.close();

		Produto produto = new Produto(nome, new BigDecimal(peso.toString()));
		Brinde brinde = new Brinde(produto, distancia);
		List<Transportadora> transportadoras = JsonUtil.readTransportadoraJson(args[0]);

		System.out.print(String.format("%nBrinde %s com peso de %.2f kg e distancia de %d km%n",
				brinde.getProduto().getNome(), brinde.getProduto().getPeso(),
				brinde.getDistancia()));

		List<Pair<Transportadora, BigDecimal>> list = transportadoras.stream()
				.map(transp -> new Pair<Transportadora, BigDecimal>(transp, transp.calcularFrete(brinde)))
				.collect(Collectors.toList());

		list.sort(Comparator.comparing(Pair::getValue));
		list.forEach(transp -> 
			System.out.print(String.format("%s - valor frete: R$ %.2f%n", transp.getKey().getNome(), transp.getValue()))
		);
	}
}
