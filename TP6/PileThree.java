
public class PileThree<K extends Comparable<K>, V> {
	private int sommet;
	private BinarySearchTree<K, V>[] b;
	
	PileThree(int taille){
		b = new BinarySearchTree<K,V>()[taille];
		sommet = -1;
	}
	
	public int size(){
		return b.length;
	}
	
	public boolean push(Cellule cel){
		if(!isFull()){
			b[++sommet]=cel;
			return true;
		}
		return false;
	}
	
	public boolean isEmpty(){
		return sommet==-1;
	}
	
	public boolean isFull(){
		return sommet==b.length-1;
	}
	
	public Cellule pop(){
		return b[sommet--];
	}
	
	public void clear(){
		sommet = -1;
		b = new Cellule[c.length];				
	}
}
