import java.awt.*;
import java.util.Random;

public class NinjaCat extends Critter {

    private Color color;
    private int stepsTaken;
    private boolean hasInfected;
    private boolean isEnraged;

    public NinjaCat() {
        this.color = new Color(128, 0, 128);
        this.stepsTaken = 0;
        this.hasInfected = false;
        this.isEnraged = false;
    }

    @Override
    public Color getColor() {
        if (isEnraged) {
            int flashing = 0;
            flashing++;
            if (flashing % 2 == 0) {
                return Color.RED;
            }
            return this.color;
        }
        return this.color;
    }

    @Override
    public String toString() {
        return "Dog";
    }

    @Override
    public Action getMove(CritterInfo info) {

        if (info.getFront() == Neighbor.OTHER) {
            this.isEnraged = true;
            return Action.INFECT;

        } else if (info.getFront() == Neighbor.WALL || info.getFront() == Neighbor.SAME) {
            Random rnd = new Random();
            int x = rnd.nextInt(1);

            if (x == 0) {
                return Action.LEFT;
            }
            return Action.RIGHT;

        }
        return Action.HOP;
    }
}
