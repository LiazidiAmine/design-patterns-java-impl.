package tp3_passetonbac;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
	
	public static List<Taxable> createConvoy(Path path) throws IOException{
		try(Stream<String> lines = Files.lines(path)){
			return lines.map(line -> parseTruck(line))
					.collect(Collectors.toList());
		}
	}
	
	public static Taxable parseTruck(String line) {
		String[] tokens = line.split(" ");
		String kind = tokens[0];
		return createTaxable(kind, tokens);
	}
	
	private static Taxable createTaxable(String kind, String[] tokens){
		switch(kind){
		case "auto":
			return () -> 1550;
		case "moto":
			return () -> 0;
		case "truck":
			int weight = Integer.parseInt(tokens[2]);
			return new Truck(weight);
		default:
			throw new IllegalArgumentException("unknow taxable type "+tokens[0]);
	}
	}
	
	private static long computeTaxe(List<Taxable> taxables){
		return taxables.stream()
		.mapToLong(Taxable::computeTaxe)
		.sum();
	}
	
	public static void main(String[] args) throws IOException{
		List<Taxable> taxables = createConvoy(Paths.get("convoy1.txt"));
		System.out.println(computeTaxe(taxables));
	}
	
}
