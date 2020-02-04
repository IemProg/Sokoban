import java.util.ArrayList;

public class Niveau {
    private static Immobile[][] grille;          //composé d’objets Immobile, des murs sur tous les bords du niveau
    private static ArrayList<Position> cibles;   //là où les caisses doivent être déplacées

    public Niveau(int x, int y){
        // Creating X*Y Table
        cibles = new ArrayList<Position>();
        grille = new Immobile[x][y];

        for (int i = 0; i < x; i++){
            for (int k=0; k < y; k++){
            	grille[i][k] = new Case();
            }
        }
    }

    // Permettent de connaître la taille du niveau
    public static int getX(){return grille.length;} // Rows
    public static int getY(){return grille[0].length;}  //Columns

    
    public ArrayList<Position> getCibles(){
		return Niveau.cibles;
	}
    
    
    // Ajoute un mur et renvoie true en cas de succès (pas de mur déjà posé)
    public boolean addMur(Position pos){
        if (grille[pos.getX()][pos.getY()].getType() == Type.MUR){
            return false;
        }else{
            grille[pos.getX()][pos.getY()] = new Mur();
            return true;
        }
    }

    // Rajoute une cible (succès si la case n’est pas un mur ou ne contient pas déjà une cible) ;
    public boolean addCible(Position pos){
        if (this.get(pos).getType() != Type.MUR && (! estCible(pos)) && (this.get(pos).getType() != Type.CAISSE)) {
            cibles.add(pos);
            return true;
        }
        return false;

    }

    // Teste si une cible se trouve à la Position passée en paramètre
    public boolean estCible(Position pos){
    	int nbr=0;
        for (int i=0; i < cibles.size(); i++){
            if (cibles.get(i).equals(pos)){
                nbr++;
                return true;
            }
        }
       
        return false;
    }

    // Teste si la case ne contient pas de mur
    public boolean estVide(Position position){
        //System.out.println(Niveau.grille[position.getX()][position.getY()].getType() == Type.MUR);
        //System.out.println(get(position).getType());
        if (get(position).getType() == Type.MUR){
            return false;
        }else {
            return true;
        }
		//return get(position).getType() == null;
	}

    // Renvoie l’objet stocké à la position en paramètre dans le tableau grille
    public Immobile get(Position position){
		return Niveau.grille[position.getX()][position.getY()];
	}

    /*
    public static ArrayList<Position> getCible(Position pos) { return cibles; }
    */
}
