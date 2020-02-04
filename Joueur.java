import java.util.ArrayList;

public class Joueur extends Mobile {
    private ArrayList<Direction> histo;                       //pour garder l’historique des coups joués par le joueur.

    public Joueur(Configuration config, Position pos){
        super(Type.JOUEUR, config, pos);
        histo = new ArrayList<Direction>();
    }

    public Joueur(Configuration config, Joueur joueur){
        this(config, joueur.getPosition());
        histo = new ArrayList<Direction>();
    }

    //Difficult conditions !! review them carefully
    
    public boolean bougerVers(Direction direction){
		Position position =this.getPosition().add(direction);

		if(this.config.estCaisse(position)){
			if(this.config.estCaisse(position.add(direction))!=true && this.config.estVide(position.add(direction))==true ) {
			this.config.get(position).bougerVers(direction);
			setPosition(position);
			
			histo.add(direction);
			return true;
			}
			else {
				return false;
			}
			
			}
		if (this.config.estVide(position)){
			histo.add(direction);
			setPosition(position);
			return true ;
		}
		return false;
	}

    public int getNbCoups(){
        return histo.size();
    }

    public ArrayList<Direction> getHisto(){
        return histo;
    };
}
