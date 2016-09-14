
public class Counter {
	private int perm;
	private int comp;

	public void incPerm() {
		this.perm++;
	}

	public void incPerm(int n) {
		this.perm += n;
	}

	public void incComp() {
		this.comp++;
	}

	public void incComp(int n) {
		this.comp += n;
	}

	public String toString() {
		return "["+this.comp+"|"+this.perm+"]";
	}
	
	public void reset(){
		this.comp=0;
		this.perm=0;
	}
}
