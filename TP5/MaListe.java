
public class MaListe<K, V> {
	private HashCouple<K,V> hc;
	private MaListe<K,V> m;
	
	public MaListe() {
		// TODO Auto-generated constructor stub
	}
	
	public MaListe(HashCouple<K, V> hc){
		this.hc=hc;
		m = new MaListe<>();
	}
	
	public MaListe(HashCouple<K, V> hc, MaListe<K, V> m){
		this.hc=hc;
		this.m=m;
	}
	
	public void add(HashCouple<K, V> hc){
		if(isEmpty()){
			m = new MaListe<K,V>();
			this.hc=hc;
		}
		else m.add(hc);
	}
	
	public boolean isEmpty(){
		return m==null;
	}
	
	public HashCouple remove(K key){		
		if(hc.getKey()!=key){
			if(m.isEmpty())return null;
			m.remove(key);
			return null;
		}else{
			HashCouple<K, V> hctmp= hc;
			hc=m.hc;
			m=m.m;
			return hctmp;
		}
	}


	public String toString(){
		if (isEmpty())
			return"[]";
		return "[" + toStringAux() + "]";
	}
	
	public String toStringAux() {
		String s = "";
		if(m.isEmpty())
			return hc.toString();
		return hc.toString() + ", " + m.toStringAux();
	}
	
	public String afficher(String s){
		if(s==null)
			s="["+hc.toString();
		else{
			if(m.isEmpty()) {
				s+=']';
				return s;
			}else s+=','+hc.toString();
		}
		return m.afficher(s);
	}
	
	public static void main(String[] args) {
		HashCouple<Integer,String> h = new HashCouple<Integer,String>(11,"François");
		MaListe<Integer,String> m = new MaListe<>(h);
		m.add(new HashCouple<Integer, String>(12, "Gauthier"));
		System.out.println(m.toString());
		System.out.println(m.afficher(null));
	}
}
