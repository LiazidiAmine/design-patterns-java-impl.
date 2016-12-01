package tp3_passetonbac;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Parser {
	public interface LineTransformer<T> {
		public T transform(String line);
	}
	
	public <T> List<T> parse(Path path, LineTransformer<T> transformer) throws IOException{
		try(Stream<String> lines = Files.lines(path)){
			return lines.map(transformer::transform)
					.collect(Collectors.toList());
		}
	}
	
}
