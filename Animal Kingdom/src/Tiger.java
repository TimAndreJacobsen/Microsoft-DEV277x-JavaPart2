import java.awt.*;
import java.util.Random;

public class Tiger extends Critter {
    private int stepsTaken;
    private Color color;

    public Tiger() {
        this.stepsTaken = 0;
        this.color = getColor();
    }

    @Override
    public Color getColor() {

        if (stepsTaken % 3 == 0) {
            Random rnd = new Random();
            int rngColor = rnd.nextInt(2);

            if (rngColor == 0) {
                return Color.RED;
            } else if (rngColor == 1) {
                return Color.GREEN;
            } else if (rngColor == 2) {
                return Color.BLUE;
            }
        }
        return this.color;
    }

    @Override
    public Action getMove(CritterInfo info) {
        stepsTaken++;

        if (info.getFront() == Neighbor.OTHER) {
            return Action.INFECT;

        } else if (info.getFront() == Neighbor.WALL || info.getRight() == Neighbor.WALL) {
            return super.getMove(info);

        } else if (info.getFront() == Neighbor.SAME) {
            return Action.RIGHT;
        }
            return Action.HOP;
    }

    @Override
    public String toString() {
        return "TGR";
    }
}
