package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Collections;

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
		while(!list.isEmpty()) {
			listMelange.add(extraire(list));
		}
		return listMelange;
	}
	
	public static <C> boolean verifierMelange(List<C> list1, List<C> list2) {
		for (C carte : list1) {
			if(Collections.frequency(list1, carte) != (Collections.frequency(list2, carte))) {
				return false;
			}
		}
		return true;
	}
	
}
