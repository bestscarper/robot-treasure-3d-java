package uk.bellesoft;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by ashley on 29/11/2016.
 */
public class MazeTest {
    @Test
    public void testConnected() throws Exception {
        int [][][] twoRooms = {
                { { 0,0,0 }, { 0,0,1} }
        };
        Maze simple = Maze.fromCoords(twoRooms);
        PointX from = PointX.xyz(0,0,0);
        PointX to = PointX.xyz(0,0,1);

        assertTrue(simple.connected(from,to));
        assertTrue(simple.connected(to,from));

    }

}