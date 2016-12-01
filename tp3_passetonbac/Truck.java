package tp3_passetonbac;

public class Truck implements Taxable {
	private final int weight;
	
	public Truck(int weight){
		this.weight = weight;
	}
	
	/* (non-Javadoc)
	 * @see tp3_passetonbac.Taxable#computeTaxe()
	 */
	@Override
	public long computeTaxe(){
		return weight / 100L;
	}
}
