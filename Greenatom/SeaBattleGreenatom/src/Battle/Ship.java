package Battle;

import com.sun.istack.internal.NotNull;

public class Ship {
    private int rows;
    private int columns;
    private int length;
    private int direction;

    public final int UNSET = -1;
    public final int HORIZONTAL = 0;
    public final int VERTICAL = 1;

    public Ship(int length) {
        this.length = length;
        this.rows = -1;
        this.columns = -1;
        this.direction = UNSET;
    }

    public boolean isLocationSet() {
        return rows != -1 && columns != -1;
    }

    public boolean isDirectionSet() {
        return direction != UNSET;
    }

    public void setLocation(int row, int col) {
        this.rows = row;
        this.columns = col;
    }

    public void setDirection(int direction) {
        if (direction != UNSET && direction != HORIZONTAL && direction != VERTICAL)
            throw new IllegalArgumentException("");
        this.direction = direction;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public int getLength() {
        return length;
    }

    public int getDirection() {
        return direction;
    }

    @NotNull
    private String directionToString() {
        if (direction == UNSET)
            return "UNSET";
        else if (direction == HORIZONTAL)
            return "HORIZONTAL";
        else
            return "VERTICAL";
    }

    @Override
    public String toString() {
        return "Battle.Ship: " + getRows() + ", " + getColumns() + " with length " + getLength() + " and direction " + directionToString();
    }
}