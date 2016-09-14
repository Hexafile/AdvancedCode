import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class ComponentGraph extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int[] tab;
	private int a = -1;
	private int b = -1;

	public ComponentGraph(int[] tab, Dimension d) {
		this.tab = tab;
		this.setSize(d);
		this.setVisible(true);
	}

	public void paint(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());

		g.setColor(Color.WHITE);
		for (int i = 0; i < tab.length; i++) {
			g.fillRect(0 + i * (getWidth() / tab.length), this.getHeight()
					- tab[i] * (getHeight() / 400),
					this.getWidth() / tab.length, tab[i]
							* (this.getHeight() / 400));
		}
		if (a != -1 && b != -1) {
			g.setColor(Color.RED);
			g.fillRect(0 + a * (getWidth() / tab.length), this.getHeight()
					- tab[a] * (getHeight() / 400),
					this.getWidth() / tab.length, tab[a]
							* (this.getHeight() / 400));
			g.fillRect(0 + b * (getWidth() / tab.length), this.getHeight()
					- tab[b] * (getHeight() / 400),
					this.getWidth() / tab.length, tab[b]
							* (this.getHeight() / 400));
		}
	}

	public void set(int[] tab, int a, int b) {
		this.tab = tab;
		this.a = a;
		this.b = b;
	}

}
