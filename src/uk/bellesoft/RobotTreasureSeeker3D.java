package uk.bellesoft;

import java.util.HashSet;
import java.util.Optional;

import static uk.bellesoft.PointX.xyz;

public class RobotTreasureSeeker3D {

    public static void main(String[] args) {
	// write your code here
    }

    public static boolean seek(int[] startingCoords, int[] treasure, int[][][] doors) {
        PointX startingPoint = xyz(startingCoords);
        PointX treasurePoint = xyz(treasure);
        Maze maze = Maze.fromCoords(doors);

        HashSet<PointX> visits = new HashSet<>();
        return seek2( Optional.of(startingPoint), treasurePoint, maze, visits);
    }

    private static boolean seek2(Optional<PointX> maybeRoom, PointX treasure, Maze maze, HashSet<PointX> visited) {
        // bail out if can't go this way
        if (!maybeRoom.isPresent()) {
            return false;
        }

        PointX room = maybeRoom.get();
        if( !visited.add(room) ) {
            return false;
        }

        if (isTreasureHere(room,treasure)) {
            return true;
        }

        // short-circuit if/when we find the treasure
        boolean foundRight =
                seek2( maze.go(Direction.RIGHT,room,visited), treasure, maze, visited ) ||
                        seek2( maze.go(Direction.LEFT, room, visited), treasure, maze, visited ) ||
                        seek2( maze.go(Direction.FORWARD, room,visited), treasure, maze, visited ) ||
                        seek2( maze.go(Direction.BACKWARD, room,visited), treasure, maze, visited ) ||
                        seek2( maze.go(Direction.UP, room, visited), treasure, maze, visited ) ||
                        seek2( maze.go(Direction.DOWN, room, visited), treasure, maze, visited );

        return foundRight;
    }

    private static boolean isTreasureHere(PointX room, PointX treasure) {
        return treasure.isIn(room);
    }

}
