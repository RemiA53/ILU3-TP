package carte;

public class Borne extends Carte {
	private int km;
	
	public Borne(int km) {
		this.km = km;
	}
	
	@Override
	public String toString() {
		StringBuilder chaine = new StringBuilder();
		chaine.append(km);
		chaine.append("KM");
		return chaine.toString();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Borne borne) {
			return km == borne.km;
		}
		
		return false;
	}
}
 