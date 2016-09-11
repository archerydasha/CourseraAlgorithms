package simplesorts;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Dasha on 8/31/2016.
 */
public abstract class SortingAlgorithmTest {
    private final SortingAlgorithm algorithm;

    public SortingAlgorithmTest(SortingAlgorithm algorithm){
        this.algorithm = algorithm;
    }

    @Test
    public void testInput1(){
        List<Integer> inputList = createInput1();
        algorithm.sort(inputList);
        assertEquals(createExpectedResult1(), inputList);
    }

    @Test
    public void testInput2(){
        List<Integer> inputList = createInput2();
        algorithm.sort(inputList);
        assertEquals(createExpectedResult2(), inputList);
    }
    @Test
    public void testInput3(){
        List<Integer> inputList = createInput3();
        algorithm.sort(inputList);
        assertEquals(createExpectedResult3(), inputList);
    }



    private List<Integer> createInput1(){
        return Lists.newArrayList(5,7,13,22,8,11,9,36);
    }

    private List<Integer> createExpectedResult1(){
        return Lists.newArrayList(5,7,8,9,11,13,22,36);
    }

    private List<Integer> createInput2(){
        return Lists.newArrayList(4,3,6,7,2,10,1,9,8,5);
    }
    private List<Integer> createExpectedResult2(){
        return Lists.newArrayList(1,2,3,4,5,6,7,8,9,10);
    }

    private List<Integer> createInput3(){
        return Lists.newArrayList(10,9,8,7,6,5,4,3,2,1);
    }
    private List<Integer> createExpectedResult3(){
        return Lists.newArrayList(1,2,3,4,5,6,7,8,9,10);
    }
}
