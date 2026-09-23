package carte;

public class Probleme extends Carte {
	private Type type;
	
	protected Probleme(Type type) {
		this.type = type; 
	}

	public Type getType() {
		return type;
	}
	
	
}
