package carte;

public abstract class Limite extends Carte {
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Limite limite) {
			return toString().equals(limite.toString()) && getClass().equals(limite.getClass());
		}
		
		return false;
	}
}
