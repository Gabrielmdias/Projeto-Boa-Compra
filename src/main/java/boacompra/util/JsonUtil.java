package boacompra.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import boacompra.model.Transportadora;
import boacompra.predicate.PredicateLimiar;
import boacompra.service.CalculaFrete;
import boacompra.service.CalculaFretePredicate;

public class JsonUtil {
	
	private JsonUtil() {
	    throw new IllegalStateException("Utility class");
	}

	@SuppressWarnings("unchecked")
	public static List<Transportadora> readTransportadoraJson(String filePath) throws FileNotFoundException, IOException, ParseException {
		JSONParser jsonParser = new JSONParser();

		List<Transportadora> transportadoras = new ArrayList<>();

		try (FileReader reader = new FileReader(filePath)) {
			JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);

			JSONArray transportadoraList = (JSONArray) jsonObject.get("transportadora");

			transportadoras = (List<Transportadora>) transportadoraList.stream()
					.map(transp -> parseTransportadoraObject((JSONObject) transp)).collect(Collectors.toList());
		}
		return transportadoras;
	}

	private static Transportadora parseTransportadoraObject(JSONObject trans) {
		String empresa = (String) trans.get("empresa");

		String valorFixo = (String) trans.get("valorFixo");

		String valorKmKg = (String) trans.get("valorKmKg");

		if (trans.get("pesoLimiar") != null) {
			Integer pesoLimiar = Integer.parseInt(trans.get("pesoLimiar").toString());

			String valorFixo2 = (String) trans.get("valorFixo2");

			String valorKmKg2 = (String) trans.get("valorKmKg2");

			CalculaFretePredicate calculaFretePredicate = new CalculaFretePredicate(new PredicateLimiar(pesoLimiar),
					new CalculaFrete(new BigDecimal(valorFixo2), new BigDecimal(valorKmKg2)),
					new CalculaFrete(new BigDecimal(valorFixo), new BigDecimal(valorKmKg)));

			return new Transportadora(empresa, calculaFretePredicate);
		}

		CalculaFrete calculaFrete = new CalculaFrete(new BigDecimal(valorFixo), new BigDecimal(valorKmKg));

		return new Transportadora(empresa, calculaFrete);
	}

}
