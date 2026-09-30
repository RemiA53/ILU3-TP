package carte;

public abstract class Limite extends Carte {
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof DebutLimite debutLimite) {
			return toString().equals(debutLimite.toString());
		}
		
		return false;
	}
}
