package uk.bellesoft;

/**
 * Created by ashley on 28/11/2016.
 */
public enum Direction {
    LEFT(-1,0,0),
    RIGHT(1,0,0),
    FORWARD(0,1,0),
    BACKWARD(0,-1,0),
    UP(0,0,1),
    DOWN(0,0,-1);

    public int dx, dy, dz;

    private Direction(int dx, int dy, int dz) {
        this.dx = dx;
        this.dy = dy;
        this.dz = dz;
    }

}
