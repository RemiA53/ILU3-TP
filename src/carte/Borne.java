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
}
 