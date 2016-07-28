package qsort;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Dasha on 7/21/2016.
 */
public class MedianPivotStrategyTest {
    @Test
    public void testMedian1(){
        List<Integer> input = Arrays.asList(1,2,3);
        int pivot = new MedianPivotStrategy().getPivot(input, 0, 2);
        assertEquals(1, pivot);
    }

    @Test
    public void testMedian2(){
        List<Integer> input = Arrays.asList(5,6,3);
        int pivot = new MedianPivotStrategy().getPivot(input, 0, 2);
        assertEquals(0, pivot);
    }

    @Test
    public void testMedian3(){
        List<Integer> input = Arrays.asList(7,3,6);
        int pivot = new MedianPivotStrategy().getPivot(input, 0, 2);
        assertEquals(2, pivot);
    }

    @Test
    public void testMedian4(){
        List<Integer> input = Arrays.asList(0,1,2,4,6,3,5);
        int pivot = new MedianPivotStrategy().getPivot(input, 4, 6);
        assertEquals(6, pivot);
    }

    @Test
    public void testMedian5(){
        List<Integer> input = Arrays.asList(0,2,1,4,6,3,5);
        int pivot = new MedianPivotStrategy().getPivot(input, 1, 3);
        assertEquals(1, pivot);
    }

    @Test
    public void testMedian6(){
        List<Integer> input = Arrays.asList(0,2,1,4,6,3,5);
        int pivot = new MedianPivotStrategy().getPivot(input, 1, 3);
        assertEquals(1, pivot);
    }

    @Test
    public void testMedian7(){
        List<Integer> input = Arrays.asList(0,2,1,4,6,3,5);
        int pivot = new MedianPivotStrategy().getPivot(input, 0, 3);
        assertEquals(1, pivot);
    }

    @Test
    public void testMedian8(){
        List<Integer> input = Arrays.asList(0,2,1,4,6,3,5);
        int pivot = new MedianPivotStrategy().getPivot(input, 1, 4);
        assertEquals(1, pivot);
    }


    @Test
    public void testMedian9(){
        List<Integer> input = Arrays.asList(1,2,3,4,5,6);
        int pivot = new MedianPivotStrategy().getPivot(input, 3, 5);
        assertEquals(4, pivot);
    }

    @Test
    public void testMedian10(){
        List<Integer> input = Arrays.asList(1,2,3,4,5,6,7);
        int pivot = new MedianPivotStrategy().getPivot(input, 3, 6);
        assertEquals(4, pivot);
    }

}
