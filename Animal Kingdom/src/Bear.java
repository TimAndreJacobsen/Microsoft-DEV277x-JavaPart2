import java.awt.*;

public class Bear extends Critter {

    private boolean polar;
    private int stepsTaken;

    public Bear(boolean isPolar) {
        this.stepsTaken = 0;
        this.polar = isPolar;
    }

    @Override
    public Action getMove(CritterInfo info) {
        stepsTaken++;

        if (info.getFront() == Neighbor.OTHER) { // Front is enemy
            return Action.INFECT;
        } else if (info.getFront() == Neighbor.EMPTY) { // Front is empty
            return Action.HOP;
        } else { // let super turn left
            return super.getMove(info);
        }
    }

    @Override
    public Color getColor() {
        if (polar) {
            return Color.WHITE;
        }
        return Color.BLACK;
    }

    @Override
    public String toString() {
        if (stepsTaken % 2 == 0) {
            return "(/)";
        } else return "(\\)";
    }






}
