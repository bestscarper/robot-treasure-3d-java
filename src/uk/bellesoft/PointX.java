package uk.bellesoft;

import java.util.HashSet;

/**
 * Created by ashley on 28/11/2016.
 */
public final class PointX {
    private int x,y,z;

    private PointX(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    static PointX xyz(int x, int y, int z) {
        return new PointX(x,y,z);
    }
    static PointX xyz(int[] x) {
        return new PointX(x[0], x[1], x[2]);
    }

    public boolean isIn(int[] other) {
        return xyz(other).isIn( this );
    }

    @Override
    public int hashCode() {
        return new StringBuilder().append(x).append(y).append(z).toString().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        // lazy check - no null objects
        return this.hashCode() == obj.hashCode();
    }

    @Override
    public String toString() {
        return new StringBuilder().append(x).append(y).append(z).toString();
    }

    boolean isIn(PointX room) {
        return room.equals(this);
    }

    PointX newOffset(Direction direction) {
        return new PointX(x+direction.dx, y+direction.dy, z+direction.dz);
    }


}
