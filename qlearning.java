import java.util.LinkedList;
import java.util.ArrayList;


class Qlearning {
    private final double alpha = 0.1; // Learning rate
    private final double gamma = 0.9; // Eagerness - 0 looks in the near future, 1 looks in the distant future

    private int mazeWidth;
    private int mazeHeight;
    private final int statesCount = mazeHeight * mazeWidth;

    private final int reward = 100;
    private final int penalty = -10;

    private Niveau niveau ;
    private Configuration config;

    public Qlearning(Niveau niv, Configuration config){
        this.niveau  = niv;
        this.mazeWidth = niv.getX();
        this.mazeHeight = niv.getY();

        this.config = config;
    }


    void calculateQ() {
            Random rand = new Random();

            for (int i = 0; i < 1000; i++) { // Train cycles
                // Select a random initial state
                int crtState = rand.nextInt(statesCount);

                while (!isFinalState(crtState)) {
                    int[] actionsFromCurrentState = possibleActionsFromState(crtState);

                    // Pick a random action from the ones possible
                    int index = rand.nextInt(actionsFromCurrentState.length);
                    int nextState = actionsFromCurrentState[index];

                    // Q(state,action)= Q(state,action) + alpha * (R(state,action) + gamma * Max(next state, all actions) - Q(state,action))
                    double q = Q[crtState][nextState];
                    double maxQ = maxQ(nextState);
                    int r = R[crtState][nextState];

                    double value = q + alpha * (r + gamma * maxQ - q);
                    Q[crtState][nextState] = value;

                    crtState = nextState;
                }
            }
        }
    void calculateQ() {
            Random rand = new Random();

            for (int i = 0; i < 1000; i++) { // Train cycles
                // Select a random initial state
                int crtState = rand.nextInt(statesCount);

                while (!isFinalState(crtState)) {
                    int[] actionsFromCurrentState = possibleActionsFromState(crtState);

                    // Pick a random action from the ones possible
                    int index = rand.nextInt(actionsFromCurrentState.length);
                    int nextState = actionsFromCurrentState[index];

                    // Q(state,action)= Q(state,action) + alpha * (R(state,action) + gamma * Max(next state, all actions) - Q(state,action))
                    double q = Q[crtState][nextState];
                    double maxQ = maxQ(nextState);
                    int r = R[crtState][nextState];

                    double value = q + alpha * (r + gamma * maxQ - q);
                    Q[crtState][nextState] = value;

                    crtState = nextState;
                }
            }
        }
}
