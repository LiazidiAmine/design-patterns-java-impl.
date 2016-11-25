package tp3_equilibrium.parsing;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class LineParser {
	public static <T> List<T> parse(Path path, Function<String, T> transformer) throws IOException{
		try(Stream<String> lines = Files.lines(path)) {
			return lines
					.map(transformer)
					.collect(Collectors.toList());
		}
	}
}
