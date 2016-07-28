package qsort;

import org.junit.Test;
import utils.FileReadingUtils;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Dasha on 7/21/2016.
 */
public class MedianElementPivotAlgorithmTest extends GenericQSortTest {
    public MedianElementPivotAlgorithmTest() {
        algorithm = QSortAlgorithm.createAlgorithmWithMedianPivotStrategy();
    }

    @Test
    public void checkComparisonsSimple1() {
        List<Integer> input = Arrays.asList(3, 2, 1);
        long comparisons = algorithm.sort(input);
        assertEquals(2, comparisons);
    }

    @Test
    public void checkComparisonsSimple2() {
        List<Integer> input = Arrays.asList(4, 5, 6, 1, 3, 2);
        long comparisons = algorithm.sort(input);
        assertEquals(8, comparisons);
    }

    @Test
    public void checkComparisonsSimple3() {
        List<Integer> input = Arrays.asList(1, 2, 3, 4, 5, 6);
        long comparisons = algorithm.sort(input);
        assertEquals(8, comparisons);
    }

    @Test
    public void checkComparisonsFromDiscussion1() {
        List<Integer> input = Arrays.asList(3, 9, 8, 4, 6, 10, 2, 5, 7, 1);
        long comparisons = algorithm.sort(input);
        assertEquals(21, comparisons);
    }

    @Test
    public void checkComparisonsFromDiscussion2() {
        List<Integer> input = null;
        try {
            input = FileReadingUtils.readArrayFromInputStream(getClass().getResourceAsStream("100.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        long comparisons = algorithm.sort(input);
        assertEquals(518, comparisons);
    }


}
