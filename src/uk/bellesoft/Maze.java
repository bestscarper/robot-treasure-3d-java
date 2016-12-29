package uk.bellesoft;

import java.util.AbstractMap;
import java.util.HashSet;
import java.util.Optional;

/**
 *
 */
public class Maze {
    private HashSet<Door> portals;

    public boolean connected(PointX room1, PointX room2) {
        Door d1 = new Door(room1,room2);
        boolean contains = portals.contains(d1);
        return contains;
    }

    class Door {
        private PointX r1, r2;
        Door(PointX r1, PointX r2) {
            this.r1 = r1;
            this.r2 = r2;
        }

        @Override
        public int hashCode() {
            return new StringBuilder().append(r1.toString()).append(r2.toString()).toString().hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            // lazy assumption nothing's null
            return this.hashCode() == obj.hashCode();
        }
    }

    private Maze(int[][][] doors) {
        this.portals = new HashSet<>();
        this.addDoors(doors);
    }

    private void addDoors(int[][][] doors) {
        for( int [][] portal : doors ) {
            // portal is pair of coord arrays
            int [] from = portal[0];
            int [] to = portal[1];
            Door door1 = new Door(PointX.xyz(from), PointX.xyz(to));
            portals.add(door1);
            Door door2 = new Door(PointX.xyz(to), PointX.xyz(from));
            portals.add(door2);
        }
    }

    Optional<PointX> go(Direction direction, PointX room, HashSet<PointX> visited) {
        PointX next = room.newOffset(direction);
        if (this.connected(room,next)) {
            return Optional.of(next);
        }
        else {
            return Optional.empty();
        }
    }

    public static Maze fromCoords(int[][][] doors) {
        return new Maze(doors);
    }
}
