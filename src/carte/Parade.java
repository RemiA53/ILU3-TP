package carte;

public class Parade extends Probleme{

	public Parade(Type type) {
		super(type);
	}
	@Override
	public String toString() {
		Type type = getType();
		return type.getNomParade();
	}
}
