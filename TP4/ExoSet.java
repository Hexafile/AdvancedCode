import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class ExoSet {

	public static void afficher(Set<Integer> ens) {
		if (!ens.isEmpty()) {
			Iterator it = ens.iterator();
			String res = "[" + ens.size() + "]{" + it.next();
			while (it.hasNext()) {
				res += "," + it.next();
			}
			System.out.println(res + "}");
		}
	}

	public static Set<Integer> inter(Set<Integer> set1, Set<Integer> set2) {
		Set<Integer> set = new HashSet<Integer>();
		for (int a : set1) {
			for (int b : set2) {
				if (a == b)
					set.add(a);
			}
		}
		return set;
	}

	public static Set<Integer> union(Set<Integer> set1, Set<Integer> set2) {
		for (int i : set2) {
			set1.add(i);
		}
		return set1;
	}

	public static boolean isIn(Set<Integer> set1, Set<Integer> set2){
		int res=0;
		for(int i:set1){
			for(int j:set2){
				if(j==i)res++;
			}
		}
		return res==set1.size();
	}
	
	public static void main(String[] args) {
		Set<Integer> ens1 = new HashSet<Integer>();
		Set<Integer> ens2 = new HashSet<Integer>();
		Random r = new Random();
		for (int i = 0; i < 3; i++) {
			ens1.add(r.nextInt(10));
		}
		for (int i = 0; i < 15; i++) {
			ens2.add(r.nextInt(10));
		}
		afficher(ens1);
		afficher(ens2);
		Set<Integer> inter = inter(ens1, ens2);
		afficher(inter);
		Set<Integer> union = union(ens1, ens2);
		afficher(union);
		System.out.println(isIn(ens1, ens2));
	}

}
