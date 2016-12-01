package tp3_passetonbac;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;
//pour fermer ce code, on le met dans un package a part
//une hashmap ne conserve pas l'ordre des données
//factory kit une sorte de factory qui permet d'enregistrer des bouts de factory
public class TaxableFactory {
	private final HashMap<String, TaxableCreator> map = new HashMap<>(); 

	public interface TaxableCreator {
		public Taxable create(List<String> tokens);
	}
	
	public void register(String kind, TaxableCreator creator){
		Objects.requireNonNull(kind);
		Objects.requireNonNull(creator);
		map.put(kind, creator);
		
	}
	
	private TaxableCreator unknow(String kind){
		return __ -> {
			throw new IllegalArgumentException("unknow type "+kind);
		};
	}
	
	public Taxable createTaxable(String kind, List<String> tokens){
		return map.getOrDefault(kind, unknow(kind)).create(tokens);
	}
}

