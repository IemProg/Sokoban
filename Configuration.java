import java.util.ArrayList;

public class Configuration {
    private ArrayList<Caisse> caisses;  // Dénote toutes les caisses du niveau
    private Joueur joueur;
    public Niveau niveau;

    // Un constructeur qui prend en paramètre le niveau et la position initiale du joueur
    public Configuration(Niveau niveau, Position positionJoueur){
        this.niveau = niveau;
        this.joueur = new Joueur(this, positionJoueur);
        this.caisses = new ArrayList<Caisse>();
    }

    // Un constructeur par copie
    public Configuration(Configuration configuration){
    	this(configuration.niveau, configuration.joueur.getPosition());
    	this.caisses=configuration.getCaisses();
    	
    }

    // Pour placer une nouvelle caisse
    public boolean addCaisse(Position pos){
        for (int i = 0; i < caisses.size(); i++){
            if (caisses.get(i).getPosition().equals(pos)){
                return false;
            }
        }
        caisses.add(new Caisse(this, pos));
        return true;
    }

    // Permettent de connaître la taille du niveau
    public int getX(){return niveau.getX();}
    public int getY(){return niveau.getY();}

    public Niveau getNiveau(){return niveau;}

    /*
    qui permet de renvoyer l’Element à la position en paramètre : le Joueur,
    une Caisse, un Mur ou une Case. C’est cette méthode qui sera principalement utilisée ! Celle de
    Niveau renvoie uniquement des informations statiques.
    Celle-ci peut renvoyer toute l’information
    présente dans la configuration, y compris les élément mobiles ; */

    public Element get(Position pos){
        for (Caisse cai: caisses){
            if (cai.getPosition().equals(pos)){
                return cai;
            }
        }

        if (joueur.getPosition().equals(pos)) {
            return getJoueur();
        }else{
            return this.niveau.get(pos);
        }
        /*
        if(! this.niveau.estVide(pos)){
            return this.niveau.get(pos);
        }
        */
        //return null;

    }

    public Joueur getJoueur(){return joueur;}
    public ArrayList<Caisse> getCaisses(){
        return caisses;
    }

    // Teste si la case ne contient pas de mur
    public boolean estVide(Position pos){
        return this.niveau.estVide(pos);
    }

    // Pour savoir si la position est une cible
    public boolean estCible(Position pos){ return niveau.estCible(pos); }

    // Permet de déplacer le joueur (renvoie true en cas de succès)
    public boolean bougerJoueurVers(Direction direction){
        if(joueur.bougerVers(direction)){
            return true;
        }else{return false;}
    }

    //Permet de savoir si leq joueur a gagné ou pas
    //TODO: Victoire  !!
    public boolean victoire(){
        for (int i = 0; i < caisses.size(); i++){
            if (! estCible(caisses.get(i).getPosition())){
                return false;
            }
        }
        return true;
    }

    public boolean estCaisse(Position position){
		for(Caisse c : caisses){
			if(c.getPosition().equals(position)){
				return true;
			}
		}
		return false;
	}
    
    public ArrayList<Coup> getChoix(){
    	return null;
    }

   /* public String toString(){
        /* • Mur : #                                                            Un exemple de représentation :
        • Cible : .                                                                     ######
        • Case : " "                                                                    #@$. #
        • Joueur : @, Joueur sur une cible : +                                          ######
        • Caisse : $, Caisse sur une cible : ∗
        
        return "@#@.$ ";}
   */

}
