
/**
 * SDD Seance TP 1 :
 *
 * @author <a href="mailto:Frederic.Guyomarch@univ-lille1.fr">Frédéric Guyomarch</a>
 * IUT-A, Universite de Lille, Sciences et TEchnologies
 */
public class Sort {

    public static int [] generateRdmIntArray(int n, int min, int max){
    	int[] tab= new int[n];
    	for(int i=0; i<n ; i++){
    		tab[i]= (int) (Math.random()*(max-min+1))+min ;
    	}
    	return tab;
    }

    public static int smallest(Counter c,int[] tab,int a){
    	int tmp=a;
    	for(int i=a;i<tab.length;i++){
    		c.incComp();
    		if(tab[tmp]>tab[i])tmp=i;
    	}
    	return tmp;
    }

    public static void insertSort(int [] tab,Counter c) {
    	for(int i=0;i<tab.length;i++){
    		int tmp = tab[i];
    		int j=i;
    		while(j>0 && tab[j-1]>=tmp){
    			c.incComp();
    			tab[j]=tab[j-1];
    			j--;
    			c.incPerm();
    		}
    		c.incComp();
    		tab[j]=tmp;
    		if(i!=j)c.incPerm();
    	}
    }

    public static void selectSort(int [] tab,Counter c){
    	for(int i=0;i<tab.length;i++){
    		swap(tab,i,smallest(c,tab, i));
    		c.incPerm();
    	}
    }

    public static void printArray(int [] tab){
    	for(int i : tab){
    		System.out.print(i+" | ");
    	}
    }

    public static void swap(int [] tab, int idx, int idx2){
    	int tmp = tab[idx];
    	tab[idx]=tab[idx2];
    	tab[idx2]=tmp;
    }

    public static void bubbleSort(int [] tab,Counter c){
    	boolean isSorted = false;
    	while(!isSorted){
    		isSorted = true;
    		for(int j=0;j<tab.length-1;j++){
    			c.incComp();
    			if(tab[j]>tab[j+1]){
    				c.incPerm();
    				isSorted=false;
    				swap(tab,j,j+1);
    			}
    		}
    	}
    }

	public static void main(String[] args) {
		Counter c = new Counter();
    	int[] tab =generateRdmIntArray(5, 5, 20);
		printArray(tab);
		insertSort(tab,c);
		System.out.println(c);
		printArray(tab);
	}
}

