package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class GestionCartes {

	public static <C> C extraire (List<C> list) {
		int random = (int) (list.size() * Math.random());
		return list.remove(random);
	}
	
	public static <C> C extraireV2 (List<C> list) {
		int random = (int) (list.size() * Math.random());
		ListIterator<C> it = list.listIterator(random);
		C elem = it.next();
		it.remove();
		return elem;
	}
	
	public static <C> List<C> melanger(List<C> list) {
		List<C> listMelange = new ArrayList<>();
		for(C elem : list) {
			listMelange.add(extraire(list));
		}
		return listMelange;
	}
	
	
}
