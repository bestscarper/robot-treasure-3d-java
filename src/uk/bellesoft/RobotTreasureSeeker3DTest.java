package uk.bellesoft;

import org.testng.annotations.Test;
import org.testng.Assert;
import static uk.bellesoft.RobotTreasureSeeker3D.*;

/**
 * Created by ashley on 28/11/2016.
 */
public class RobotTreasureSeeker3DTest {

    /*

     x => start point
     * => treasure
     ^ => door up
     v => door down

     Solution is to go up then forwards, but we will get sidetracked by going forwards first.

      floor 1 (z=0)
      -----
      |   |     1
      -- --
      | x^|     0
      -----
        0

      floor 2 (z=1)
      -----
      | * | 1
      -- --
      |  v| 0
      -----
        0
     */
    @Test
    public void treasureFoundTest() throws Exception {
         int[][][] doors = {
                 { { 0,0,0}, {0,1,0} },  // false trail forwards
                 { { 0,0,0}, {0,0,1} },  // door up to first floor
                 { { 0,0,1}, {0,1,1} },  // door into treasure room
         };

         int [] startingPoint = { 0,0,0 };
         int [] treasure = { 0,1,1 };

        boolean found = seek( startingPoint, treasure, doors );
        Assert.assertTrue(found);
    }

    @Test
    public void treasureNotFoundTest() throws Exception {
        int[][][] doors = {
                { { 0,0,0}, {0,1,0} },
                { { 0,0,0}, {0,0,1} },  // door up to first floor
                { { 0,0,1}, {0,1,1} },  // door into treasure room
        };

        int [] startingPoint = { 0,0,0 };
        int [] treasure = { 2,1,1 }; // can't be reached

        boolean found = seek( startingPoint, treasure, doors );
        Assert.assertFalse(found);
    }
}