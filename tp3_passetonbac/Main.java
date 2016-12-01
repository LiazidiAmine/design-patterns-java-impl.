package tp3_passetonbac;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
	
	public static List<Taxable> createConvoy(Path path, TaxableFactory taxableFactory) throws IOException{
		try(Stream<String> lines = Files.lines(path)){
			return lines.map(line -> parseTruck(line, taxableFactory))
					.collect(Collectors.toList());
		}
	}
	
	public static Taxable parseTruck(String line, TaxableFactory taxableFactory) {
		String[] tokens = line.split(" ");
		String kind = tokens[0];
		return taxableFactory.createTaxable(kind, Arrays.stream(tokens).skip(1).collect(Collectors.toList()));
	}

	
	private static long computeTaxe(List<Taxable> taxables){
		return taxables.stream()
		.mapToLong(Taxable::computeTaxe)
		.sum();
	}
	
	private static Taxable createAuto(List<String> tokens){
		int passengerCount = Integer.parseInt(tokens.get(1));
		return () -> 200 * passengerCount;
	}
	
	private static Taxable createMoto(List<String> tokens){
		return () -> 0;
	}
	
	private static Taxable createTruck(List<String> tokens){
		int weight = Integer.parseInt(tokens.get(1));
		return new Truck(weight);
	}
	
	public static void main(String[] args) throws IOException{
		TaxableFactory taxableFactory = new TaxableFactory();
		taxableFactory.register("auto", Main::createAuto);
		taxableFactory.register("moto", Main::createMoto);
		taxableFactory.register("truck", Main::createTruck);
		
		List<Taxable> taxables = createConvoy(Paths.get("convoy1.txt"), taxableFactory);
		System.out.println(computeTaxe(taxables));
	}
	
}
