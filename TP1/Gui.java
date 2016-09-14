import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

public class Gui extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ComponentGraph comp;
	private boolean timeMode;
	private int[] tab;
	private long time;

	public Gui(boolean timeMode) {
		this.timeMode = timeMode;
		initialize();

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(new Dimension(980,
				(int) screenSize.getHeight() / 2));

		comp = new ComponentGraph(tab, getSize());
		comp.setSize(this.getSize());

		this.setContentPane(comp);
		this.setTitle("Sort Comparator");
		setMinimumSize(getSize());
		setLocation((int) (screenSize.getWidth() / 2 - this.getWidth() / 2),
				(int) (screenSize.getHeight() / 2 - this.getHeight() / 2));
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		Date start = new Date();
		if (!timeMode)
			selectSort();
		else {
			for (int i = 0; i < 50; i++) {
				initialize();
				selectSort();
			}
			;
		}
		Date end = new Date();

		if (!timeMode){
			time = end.getTime() - start.getTime();
			time/=100;
			JOptionPane.showMessageDialog(this, time+" - Réussite : "+verification());
		}
		else{
			time = (end.getTime() - start.getTime()) / 50;
			JOptionPane.showMessageDialog(this, time+" - Réussite : "+verification());
		}
		
	}

	private void bubleSort() {
		for (int i = 0; i < tab.length; i++) {
			for (int j = 0; j < tab.length - 1; j++) {
				if (!timeMode) {
					try {
						TimeUnit.NANOSECONDS.sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					} 
				}
				if (tab[j] > tab[j + 1])
					swap(j, j + 1);
			}
		}
	}
	
	private void selectSort(){
		for(int i=0;i<tab.length-1;i++){
			int id=i;
			for(int j=i+1;j<tab.length;j++){
				System.out.println(j);
				if(tab[id]>tab[j])id=j;
			}
			try {
				TimeUnit.NANOSECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			swap(i,id);
		}
	}
	
	private void insertSort(){
		for(int i=0;i<tab.length;i++){
			int tmp = i;
			int j=i;
			while(j>0 && tab[j-1]>tab[tmp]){
				tab[j]=tab[j-1];
				swapWithout(j,j-1);
				j--;
			}
			try {
				TimeUnit.NANOSECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			tab[j]=tab[tmp];
		}
	}

	void initialize() {
		tab = new int[944];
		for (int i = 0; i < tab.length; i++) {
			tab[i] = new Random().nextInt(400);
		}
	}

	boolean verification(){
		int tmp= tab[0];
		for(int i=1;i<tab.length;i++){
			if(tab[i]>=tmp)tmp=tab[i];
			else return false;
		}
		return true;
	}
	
	void swap(int a, int b) {
		int tmp = tab[a];
		tab[a] = tab[b];
		tab[b] = tmp;
		if (!timeMode) {
			comp.set(tab, a, b);
			comp.repaint();
		}
	}
	
	void swapWithout(int a,int b){
		if (!timeMode) {
			comp.set(tab, a, b);
			comp.repaint();
		}
	}
	
	public long getTime(){
		return time;
	}

	public static void main(String[] args) {
		Gui g = new Gui(false);
	}
}
