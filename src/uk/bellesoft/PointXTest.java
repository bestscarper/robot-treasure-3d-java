package uk.bellesoft;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by ashley on 29/11/2016.
 */
public class PointXTest {
    @Test
    public void testHashCode() throws Exception {
        int hash1 = PointX.xyz(2,3,4).hashCode();
        int hash2 = PointX.xyz(2,3,4).hashCode();

        Assert.assertEquals(hash1, hash2);
    }

}