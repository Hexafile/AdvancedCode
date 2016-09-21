
public class Pile {
	private int sommet;
	private Cellule[] c;
	
	Pile(int taille){
		c = new Cellule[taille];
		sommet = -1;
	}
	
	public int size(){
		return c.length;
	}
	
	public boolean push(Cellule cel){
		if(!isFull()){
			c[++sommet]=cel;
			return true;
		}
		return false;
	}
	
	public boolean isEmpty(){
		return sommet==-1;
	}
	
	public boolean isFull(){
		return sommet==c.length-1;
	}
	
	public Cellule pop(){
		return c[sommet--];
	}
	
	public void clear(){
		sommet = -1;
		c = new Cellule[c.length];				
	}
}
