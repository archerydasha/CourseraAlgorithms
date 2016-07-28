package qsort;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;

/**
 * Created by Dasha on 7/20/2016.
 */
public abstract class GenericQSortTest {
    protected QSortAlgorithm algorithm;

    @Test
    public void checkSorting1(){
        List<Integer> input = Arrays.asList(4,3,5,1,2);
        List<Integer> expectedResult = Arrays.asList(1,2,3,4,5);
        algorithm.sort(input);
        assertTrue(input.equals(expectedResult));
    }


    @Test
    public void checkSorting2(){
        List<Integer> input = Arrays.asList(4,7,5,6,8,1,10,3,9,2);
        List<Integer> expectedResult = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        algorithm.sort(input);
        assertTrue(input.equals(expectedResult));
    }
}
