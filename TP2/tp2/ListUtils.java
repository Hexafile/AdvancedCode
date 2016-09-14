package tp2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

public class ListUtils {

	public static List<Integer> genereRdmIntList() {
		List<Integer> l = new ArrayList<Integer>();
		int length = new Random().nextInt(31);
		for (int i = 0; i < length; i++) {
			l.add(new Random().nextInt(101));
		}
		return l;
	}

	public static String toString(List<Integer> l) {
		String s = "";
		Iterator<Integer> it = l.iterator();
		if (it.hasNext()) {
			s += it.next();
		}
		while (it.hasNext()) {
			s += " -> " + it.next();
		}
		return s;
	}

	public static void affiche(List<Integer> l) {
		System.out.println(toString(l));
	}
	
	public static void afficheInverse(List<Integer> l) {
		System.out.println(toStringInverse(l));
	}

	public static String toStringInverse(List<Integer> l) {
		String s = "";
		ListIterator<Integer> it = l.listIterator(l.size());
		if (it.hasPrevious()) {
			s += it.previous();
		}
		while (it.hasPrevious()) {
			s += " -> " + it.previous();
		}
		return s;
	}
	
	public static int somme(List<Integer> l){
		Iterator<Integer> it = l.iterator();
		int tmp=0;
		while (it.hasNext()) {
			tmp += it.next();
		}
		return tmp;
	}
	
	public static int moyenne(List<Integer> l){
		return somme(l)/l.size();
	}
	
	public static int max(List<Integer> l){
		Iterator<Integer> it = l.iterator();
		int max = 0;
		while (it.hasNext()) {
			if(max <it.next())max=it.next();
		}
		return max;
	}
	
	public static int min(List<Integer> l){
		Iterator<Integer> it = l.iterator();
		int min=0;
		if(it.hasNext())min =it.next();
		while (it.hasNext()) {
			if(min >it.next())min=it.next();
		}
		return min;
	}

}
