import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Dictionnary<K1, K2> implements BidirectionnalMap<K1, K2> {

	Map<K1,K2> dico1= new HashMap<K1,K2>();
	Map<K2,K1> dico2= new HashMap<K2,K1>();
	
	@Override
	public K2 getFromPrimary(K1 k) {
		return dico1.get(k);
	}
	@Override
	public K1 getFromSecondary(K2 k) {
		return dico2.get(k);
	}
	@Override
	public void put(K1 k1, K2 k2) {
		dico1.put(k1, k2);
		dico2.put(k2, k1);
	}
	@Override
	public boolean isEmpty() {
		return dico1.isEmpty()&&dico2.isEmpty();
	}
	@Override
	public void clear() {
		dico1.clear();
		dico2.clear();		
	}
	@Override
	public void removeFromPrimary(K1 k1) {
		dico1.remove(k1);
		dico2.remove(getFromPrimary(k1));
	}
	
	public String toString(){
		String res="";
		if(!dico1.isEmpty()){
			res+="[";
			Iterator it =dico1.entrySet().iterator();
			while(it.hasNext()){
				res+=it.next();
			}
			res+="]";
		}
		return res;
	}
	
	public static void main(String[] args) {
		BidirectionnalMap<String, String> dico = new Dictionnary<String,String>();
		dico.put("chat", "cat");
		System.out.println(dico);
	}
}
