import java.util.HashSet;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class SolverBFS implements SolverInterface{
  private Position root_position;

  private Configuration config;
  private static int totalSteps;

  private LinkedList<Position> stack = new LinkedList<Position>();
  private ArrayList<Position> explored = new ArrayList<Position>();
  //private ArrayList<Coup> stack= new ArrayList<Coup>();

  public SolverBFS(Configuration config){
      this.config = config;
      this.root_position = this.config.getJoueur().getPosition();
  }

  public void set(Configuration config){
      this.config = config;
  }

  public Configuration getConfiguration(){
      return config;
  }

  public LinkedList<Direction> getValidMoves(Position p){
    Position test = new Position(p.getX(), p.getY());
    LinkedList<Direction> moves = new LinkedList<Direction>();
    for (Direction d: Direction.getDirections()){
      if (this.config.estVide(test.add(d))){
          moves.add(d);
      }
    }
    return moves;
  }

public LinkedList<Direction> DFS(){
  LinkedList<Direction> valid_dir = new LinkedList<Direction>();
  Position node = this.config.getJoueur().getPosition();
  System.out.println(node.toString());
  this.stack.add(node);

  if (this.config.victoire()){
    return valid_dir;
  }

  while (true){
    if (this.stack.peek() == null){
      System.out.println("Failure, no path found !\n");
      return valid_dir;
    }
    this.explored.add(node);

    for (Direction d : this.getValidMoves(node)){
        Position child = new Coup(node, d).getPosition();
        valid_dir.add(d);

        if (! this.explored.contains(child) && !this.stack.contains(child)){
          if (this.config.victoire()){
            return valid_dir;
          }
        }
        this.stack.add(child);
        totalSteps++;
    }
  }
}

  public void step(){
      LinkedList<Direction> win_path = BFS();
      for (Direction d : win_path){
        this.config.bougerJoueurVers(d);
      }
	}

  public boolean stop(){
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

  public int getTotalSteps(){
		return SolverBFS.totalSteps;
	}
}
