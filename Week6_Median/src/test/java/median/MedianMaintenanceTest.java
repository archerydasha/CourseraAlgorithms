package median;

import static org.junit.Assert.*;

import org.junit.Test;

import java.io.IOException;

/**
 * Created by Dasha on 8/19/2016.
 */
public class MedianMaintenanceTest {
    @Test
    public void simpleFileTest1() throws IOException {
        String fileName = getClass().getResource("simple_file1.txt").getPath();
        assertEquals(1, MedianMaintenance.countNMedians(1, fileName));
        assertEquals(2, MedianMaintenance.countNMedians(2, fileName));
        assertEquals(4, MedianMaintenance.countNMedians(3, fileName));
        assertEquals(6, MedianMaintenance.countNMedians(4, fileName));
        assertEquals(9, MedianMaintenance.countNMedians(5, fileName));
    }

    @Test
    public void simpleFileTest2() throws IOException {
        String fileName = getClass().getResource("simple_file2.txt").getPath();
        assertEquals(5, MedianMaintenance.countNMedians(1, fileName));
        assertEquals(10, MedianMaintenance.countNMedians(2, fileName));
        assertEquals(15, MedianMaintenance.countNMedians(3, fileName));
        assertEquals(18, MedianMaintenance.countNMedians(4, fileName));
        assertEquals(23, MedianMaintenance.countNMedians(5, fileName));
    }

    @Test
    public void testWeeklyAssignment6Part2() throws IOException {
        String fileName = getClass().getResource("Median.txt").getPath();
        assertEquals(1213, MedianMaintenance.countNMedians(10000, fileName)%10000);
        assertEquals(46831213, MedianMaintenance.countNMedians(10000, fileName));
    }

    @Test
    public void testCaseFromForum() throws IOException {
        String fileName = getClass().getResource("testCaseFromForum.txt").getPath();
        System.out.println(MedianMaintenance.countNMedians(10000, fileName)%10000);
    }
}
