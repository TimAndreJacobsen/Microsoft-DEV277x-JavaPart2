import java.awt.*;

public class Giant extends Critter {

    private Color color;
    private int stepsTaken;
    private State state;

    public Giant() {
        this.color = Color.GRAY;
        this.stepsTaken = 0;
        this.state = State.fee;
    }

    public static enum State {
        fee, fie, foe, fum
    };

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public String toString() {
        return String.valueOf(this.state);
    }

    @Override
    public Action getMove(CritterInfo info) {
        stepsTaken++;

        if (stepsTaken % 6 == 0) {
            changeState();
        }

        if (info.getFront() == Neighbor.OTHER) {
            return Action.INFECT;
        } else if (info.getFront() == Neighbor.EMPTY) {
            return Action.HOP;
        }
        return Action.RIGHT;
    }

    // Changes state to next state, wraps around.
    private void changeState() {

        if (state == State.fee) {
            state=State.fie;

        } else if (state == State.fie) {
            state = State.foe;

        } else if (state == State.foe) {
            state = State.fum;

        } else {
            state = State.fie;
        }
    }
}
