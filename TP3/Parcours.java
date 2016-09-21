public class Parcours {
	public static void main(String[] args) {
		boolean trouve =false;
		Labyrinthe l = new Labyrinthe();
		Pile p = new Pile(100);
		l.poserMarque(0, 1);
		p.push(new Cellule(0,1));
		while(!p.isEmpty()){
			Cellule c =p.pop();
			l.poserMarqueRetour(c.getX(), c.getY());
			if(c.getX()==l.n()-1 && c.getY()==l.n()-2){
				System.out.println("Sortie trouvée");
				p.clear();
				trouve = true;
			}else{
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(c.getY()!=0 && !l.estMur(c.getX(),c.getY()-1) && !l.estMarque(c.getX(), c.getY()-1)){
					p.push(new Cellule(c.getX(), c.getY()-1));
					l.poserMarque(c.getX(), c.getY()-1);
				}
				if(c.getY()!=l.n()-1 && !l.estMur(c.getX(),c.getY()+1) && !l.estMarque(c.getX(), c.getY()+1)){
					p.push(new Cellule(c.getX(), c.getY()+1));
					l.poserMarque(c.getX(), c.getY()+1);
				}
				if(c.getX()!=0 && !l.estMur(c.getX()-1,c.getY()) && !l.estMarque(c.getX()-1, c.getY())){
					p.push(new Cellule(c.getX()-1, c.getY()));
					l.poserMarque(c.getX()-1, c.getY());
				}
				if(c.getX()!=l.n() && !l.estMur(c.getX()+1,c.getY()) && !l.estMarque(c.getX()+1, c.getY())){
					p.push(new Cellule(c.getX()+1, c.getY()));
					l.poserMarque(c.getX()+1, c.getY());
				}
			}
		}		
		if(!trouve)System.out.println("pas de chemin");
	}
}
