import java.awt.*;

public class Bear extends Critter {

    private boolean polar;
    private int stepsTaken;

    public Bear() {
        this.stepsTaken = 0;
        /* randomizing type
        Random rand = new Random();
        int isPolar = rand.nextInt(1);
        System.out.println("rand int 0-1: " + isPolar);
        if (isPolar == 0) {
            polar = false;
        } else {
            polar = true;
        } */
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
