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
	
	public static <C> List<C> rassembler(List<C> list) {
		List<C> listRassemblee = new ArrayList<>();
		List<C> dejaVu = new ArrayList<>();
		
		for (C carte : list) {
	        if (!dejaVu.contains(carte)) {
	            dejaVu.add(carte);

	            for (C carte2 : list) {
	                if (carte != null && carte.equals(carte2)) {
	                    listRassemblee.add(carte2);
	                }
	            }
	        }
	    }
		return listRassemblee;
	}
	
	public static <C> boolean verifierRassemblement(List<C> list) {
		for(ListIterator<C> it1 = list.listIterator(); it1.hasNext();) {
			C courant = it1.next();
			
			if(it1.hasNext()) {
				C next = it1.next();
				
				if(!(courant != null && courant.equals(next))) {
					for(ListIterator<C> it2 = list.listIterator(it1.nextIndex()); it2.hasNext();) {
						C element = it2.next();
						if(element != null && element.equals(courant)) {
							return false;
						}
					}
					
					it1.previous();
				}
			}
		}
		return true;
	}
	
}
