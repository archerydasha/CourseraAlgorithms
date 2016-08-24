package twosum;

import org.junit.Test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Dasha on 8/18/2016.
 */
public class TwoSumCounterTest {
    @Test
    public void testHasCombinationFile1() {
        String fileName = getClass().getResource("simple_text_file_1.txt").getPath();
        assertEquals(false, TwoSumCounter.hasSuchCombination(4, fileName));
        assertEquals(true, TwoSumCounter.hasSuchCombination(5, fileName));
        assertEquals(true, TwoSumCounter.hasSuchCombination(-3, fileName));
    }

    @Test
    public void testHowManyValues1() {
        String fileName = getClass().getResource("not_so_simple_text_file_1.txt").getPath();
        /*
        this file has 4 values: 10, 20, -30, -5
        so the only possible 2-sums are: 30, -20, 5, -10, 15, -35
        or, in sorted order: -35, -20, -10, 5, 15, 30
        */
        assertEquals(1, TwoSumCounter.countNumberOfPossibleTwoSums(-8, 8, fileName));
        assertEquals(2, TwoSumCounter.countNumberOfPossibleTwoSums(-10, 10, fileName));
        assertEquals(4, TwoSumCounter.countNumberOfPossibleTwoSums(-25, 15, fileName));
        assertEquals(6, TwoSumCounter.countNumberOfPossibleTwoSums(-35, 40, fileName));
    }

    @Test
    public void testHowManyValuesOptimized1() {
        String fileName = getClass().getResource("not_so_simple_text_file_1.txt").getPath();
        /*
        this file has 4 values: 10, 20, -30, -5
        so the only possible 2-sums are: 30, -20, 5, -10, 15, -35
        or, in sorted order: -35, -20, -10, 5, 15, 30
        */
        assertEquals(1, TwoSumCounter.countNumberOfPossibleTwoSumsOptimized(-8, 8, fileName));
        assertEquals(2, TwoSumCounter.countNumberOfPossibleTwoSumsOptimized(-10, 10, fileName));
        assertEquals(4, TwoSumCounter.countNumberOfPossibleTwoSumsOptimized(-25, 15, fileName));
        assertEquals(6, TwoSumCounter.countNumberOfPossibleTwoSumsOptimized(-35, 40, fileName));
    }

    @Test
    public void testWeeklyAssignment6Part1(){
        String fileName = getClass().getResource("programming_prob-2sum.txt").getPath();
        assertEquals(427, TwoSumCounter.countNumberOfPossibleTwoSumsOptimized(-10000, 10000, fileName));
    }


    @Test
    public void testCaseFromForum(){
        String fileName = getClass().getResource("testCaseFromForum.txt").getPath();
        assertEquals(3, TwoSumCounter.countNumberOfPossibleTwoSumsOptimized(-10000, 10000, fileName));
    }
}
