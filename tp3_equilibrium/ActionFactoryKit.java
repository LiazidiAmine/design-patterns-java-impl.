package tp3_equilibrium;

import java.util.HashMap;
import java.util.Objects;
import java.util.function.Function;

public class ActionFactoryKit {
	private HashMap<String, Function<String[], Action>> actions = new HashMap<>();
	
	public ActionFactoryKit(){
		
	}
	
	public void register(String name, Function<String[], Action> actionFactory){
		Objects.requireNonNull(name);
		Objects.requireNonNull(actionFactory);
		actions.put(name, actionFactory);
	}
	
	private Function<String[], Action> unknow(String actionName){
		return __ -> {
			throw new IllegalArgumentException("unknow action "+actionName);
		};
	}
	
	public Action create(String line){
		String[] tokens = line.split(" ");
		String actionName = tokens[0];
		return actions.getOrDefault(actionName, 
				unknow(actionName)).apply(tokens); 
				
	}
}
