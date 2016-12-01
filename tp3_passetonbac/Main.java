package tp3_passetonbac;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
	
	private static long computeTaxe(List<Taxable> taxables){
		return taxables.stream()
		.mapToLong(Taxable::computeTaxe)
		.sum();
	}
	
	private static Taxable createAuto(List<String> tokens){
		int passengerCount = Integer.parseInt(tokens.get(1));
		return () -> 200 * passengerCount;
	}
	
	public static Taxable parseTaxable(String line, FactoryKit<Taxable> taxableFactory) {
		String[] tokens = line.split(" ");
		String kind = tokens[0];
		return taxableFactory.create(kind,
				Arrays.stream(tokens).skip(1).collect(Collectors.toList()));
	}
	
	private static Taxable createMoto(List<String> tokens){
		return () -> 0;
	}
	
	private static Taxable createTruck(List<String> tokens){
		int weight = Integer.parseInt(tokens.get(1));
		return new Truck(weight);
	}
	
	public static List<Taxable> createConvoy(Path path, FactoryKit<Taxable> taxableFactory) throws IOException{
		return Parser.parse(path, line -> parseTaxable(line, taxableFactory));
	}
	
	public static void main(String[] args) throws IOException{
		FactoryKit<Taxable> taxableFactory = new FactoryKit<>();
		taxableFactory.register("auto", Main::createAuto);
		taxableFactory.register("moto", Main::createMoto);
		taxableFactory.register("truck", Main::createTruck);
		
		List<Taxable> taxables = createConvoy(Paths.get("convoy1.txt"), taxableFactory);
		System.out.println(computeTaxe(taxables));
	}
	
}
