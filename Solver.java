public class Solver implements SolverInterface{

	private Configuration config;
	private static int totalSteps;

	 public Solver(Configuration config){
	        this.config = config;
	    }

	    public void set(Configuration config){
	        this.config = config;
	    }

	    public Configuration getConfiguration(){
	        return config;
	    }



	public boolean stop(){
		//System.out.println(this.config.getJoueur().getPosition().toString());
		for(Caisse caisse : this.config.getCaisses()){
			if(((this.config.get(caisse.getPosition().add(Direction.HAUT)).getType() == Type.MUR) && (this.config.get(caisse.getPosition().add(Direction.DROITE)).getType() == Type.MUR))
				|| ((this.config.get(caisse.getPosition().add(Direction.HAUT)).getType() == Type.MUR) && (this.config.get(caisse.getPosition().add(Direction.GAUCHE)).getType() == Type.MUR))
				|| ((this.config.get(caisse.getPosition().add(Direction.BAS)).getType() == Type.MUR) && (this.config.get(caisse.getPosition().add(Direction.DROITE)).getType() == Type.MUR))
				|| ((this.config.get(caisse.getPosition().add(Direction.BAS)).getType() == Type.MUR) && (this.config.get(caisse.getPosition().add(Direction.GAUCHE)).getType() == Type.MUR))){
				return true;
			}
		}
		return config.victoire();

	}

	public void step(){
		int random = (int) (Math.random()*4);

		switch(random){
			case 0:
				this.config.bougerJoueurVers(Direction.GAUCHE);
				break;
			case 1:
				this.config.bougerJoueurVers(Direction.DROITE);
				break;
			case 2:
				this.config.bougerJoueurVers(Direction.HAUT);
				break;
			default:
				this.config.bougerJoueurVers(Direction.BAS);
		totalSteps++;

		}

	}

	public int getTotalSteps(){
		return Solver.totalSteps;
	}


}
