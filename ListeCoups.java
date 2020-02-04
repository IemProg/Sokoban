import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Arrays;

public class ListeCoups {
    /*
    Coder une classe ListeCoups qui se chargera de l’algorithme de Djikstra. Elle doit prendre une configuration,
    calculer la distance de toutes les cases au joueur avec l’algorithme de Djikstra, puis construire la liste
    de tous les coups possibles (un coup n’est possible que si le joueur peut atteindre la case adjacente à
		la caisse dans la direction opposée à la direction de poussé) et enfin avoir une méthode qui permette de
		retourner la liste des déplacements pour effectuer le coup.
    */
		private LinkedList<Coup> coup_possibles=new LinkedList<Coup>();
		private Configuration config;
		private ArrayList<Position> stack=new ArrayList<Position>();
		private int[][] ind;

		public ListeCoups(Configuration config) {
			this.config = config;
			this.ind = new int[Niveau.getX()][Niveau.getY()];

			//On initialise le tableau ind pour toute les cases à 0 sauf la case joueur
			for(int i=0; i < Niveau.getX(); i++) {
				for(int j=0; j<Niveau.getY(); j++) {
					if((config.getJoueur().getPosition().getX() == i) && ( config.getJoueur().getPosition().getY() == j)) {
						 System.out.println("if");
						 ind[i][j] = 1;
					}else {
						 System.out.println("else");
						 ind[i][j] = 0;
					}
				}
			}
			//On ajoute la position joueur à stack
			stack.add(config.getJoueur().getPosition()) ;

			//On dépile stack
			while(stack.size()>0) {
				Position cur = stack.remove(0);
				//Pour chaque direction on regarde les coups possibles
				for(Direction d : Direction.getDirections()) {
					if(d!=null) {
						System.out.println("Check 1");
						//TODO:Probleme avec indexoutofbounds si il n'y a pas de limite fixée
						if ((config.estVide(cur.add(d))==true)&&(config.estCaisse(cur.add(d))==false)
							&&(cur.add(d).getX()<6)&&(cur.add(d).getY()<8)) {
								if((ind[cur.add(d).getX()][cur.add(d).getY()]==0)
								||(ind[cur.add(d).getX()][cur.add(d).getY()]>ind[cur.getX()][cur.getY()])) {
									System.out.println("Check 2");
									ind[cur.add(d).getX()][cur.add(d).getY()] +=1;
									stack.add(cur.add(d));
									System.out.println("Check 3");
								}
						}
					}
				}
			}

			//On remplit la list des coups possibles
			for(Caisse caisse : config.getCaisses()) {
				for(Direction d : Direction.getDirections()) {
					if(d!=null) {
					     // TODO: Bug ici
				       // if((ind[caisse.getPosition().sub(d).getX()][caisse.getPosition().sub(d).getY()]>=1)
							 //&&((config.estVide(caisse.getPosition().add(d)))==true)&&(config.estCaisse(caisse.getPosition().add(d))==false)) {

				    	coup_possibles.add(new Coup(caisse.getPosition().sub(d),d));

				//    }
				}
			}
			}
		}

		@Override
		public String toString() {
			return "ListeCoups [coup_possibles=" + coup_possibles + ", config=" + config + ", stack=" + stack + ", ind="
					+ Arrays.toString(ind) + "]";
		}

		//TODO: Renvoie la distance
		public int getDistance() {

			return 0;
		}

		public LinkedList<Coup> getCoup_possibles() {
			return coup_possibles;
		}

		public Configuration getConfig() {
			return config;
		}

		public ArrayList<Position> getStack() {
	    return stack;
	  }


}
