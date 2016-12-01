package tp3_passetonbac;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;
//pour fermer ce code, on le met dans un package a part
//une hashmap ne conserve pas l'ordre des données
//factory kit une sorte de factory qui permet d'enregistrer des bouts de factory
public class TaxableFactoryKit<T> {
	private final HashMap<String, Creator<T>> map = new HashMap<>(); 

	public interface Creator<T> {
		public T create(List<String> tokens);
	}
	
	public void register(String kind, Creator<T> creator){
		Objects.requireNonNull(kind);
		Objects.requireNonNull(creator);
		map.put(kind, creator);
		
	}
	
	private Creator<T> unknow(String kind){
		return __ -> {
			throw new IllegalArgumentException("unknow type "+kind);
		};
	}
	
	public T create(String kind, List<String> tokens){
		return map.getOrDefault(kind, unknow(kind)).create(tokens);
	}
}

