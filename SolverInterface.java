
public interface SolverInterface {
	public void set(Configuration sokoban);
	public Configuration getConfiguration();
	public boolean stop();
	public int getTotalSteps();
	public void step();
	
}
