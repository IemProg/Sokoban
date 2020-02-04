import java.util.ArrayList;

public class Solver_V2 implements SolverInterface{
	private Configuration config;
	private ArrayList<Coup> stack= new ArrayList<Coup>();
	private ListeCoups ls;

	public Solver_V2(Configuration config){
        this.config = config;
        this.ls = new ListeCoups(config);
    }

	public void step() {
		 while(stack.size()>0) {
			 Coup cur = stack.remove(0);
			 config.bougerJoueurVers(cur.getDirection());
		 }
		 getNextCoup();
		}

	// À implementer pour tomber sur la liste de deplacement pour effectuer un coup aléatoire de la liste coup possible
	public ArrayList<Direction> getNextCoup(){
		  ArrayList<Direction> direction = new ArrayList<Direction>();
		  int random = (int) (Math.random()*ls.getCoup_possibles().size());
		  direction.add(ls.getCoup_possibles().get(random).getDirection());
		  return direction;
	}

	public void set(Configuration config){
      this.config = config;
  }

  public Configuration getConfiguration(){
      return config;
  }

	@Override
	public boolean stop(){
		for(Caisse caisse : this.config.getCaisses()){
			if(((this.config.get(caisse.getPosition().add(Direction.HAUT)).getType() == Type.MUR)
				&& (this.config.get(caisse.getPosition().add(Direction.DROITE)).getType() == Type.MUR))
					|| ((this.config.get(caisse.getPosition().add(Direction.HAUT)).getType() == Type.MUR)
					&& (this.config.get(caisse.getPosition().add(Direction.GAUCHE)).getType() == Type.MUR))
					|| ((this.config.get(caisse.getPosition().add(Direction.BAS)).getType() == Type.MUR)
					&& (this.config.get(caisse.getPosition().add(Direction.DROITE)).getType() == Type.MUR))
					|| ((this.config.get(caisse.getPosition().add(Direction.BAS)).getType() == Type.MUR)
					&& (this.config.get(caisse.getPosition().add(Direction.GAUCHE)).getType() == Type.MUR))){

				return true;
			}
		}
		return config.victoire();
	}

	@Override
	public int getTotalSteps() {
		// TODO Auto-generated method stub
		return 0;
	}



}
