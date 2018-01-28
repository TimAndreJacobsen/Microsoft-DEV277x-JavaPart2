import java.awt.*;

public class WhiteTiger extends Critter {

    private Color color;
    private int stepsTaken;
    private boolean hasInfected;

    public WhiteTiger() {
        this.stepsTaken = 0;
        this.color = Color.WHITE;
        this.hasInfected = false;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public String toString() {

        if (hasInfected) {
            return "TGR";
        }
        return "tgr";
    }

    @Override
    public Action getMove(CritterInfo info) {
        stepsTaken++;

        if (info.getFront() == Neighbor.OTHER) {
            this.hasInfected = true;
            return Action.INFECT;

        } else if (info.getFront() == Neighbor.WALL || info.getRight() == Neighbor.WALL) {
            return super.getMove(info);

        } else if (info.getFront() == Neighbor.SAME) {
            return Action.RIGHT;
        }
        return Action.HOP;
    }
}

