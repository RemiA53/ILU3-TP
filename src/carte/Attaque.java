package carte;

public class Attaque extends Probleme {
	public Attaque(Type type) {
		super(type);
	}
	
	@Override
	public String toString() {
		Type type = getType();
		return type.getNomAttaque();
	}
}
