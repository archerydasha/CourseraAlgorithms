package components;

import org.junit.Test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

/**
 * Created by Dasha on 8/7/2016.
 */
public class SccFindingTest {

    private void testGraph(String filename, long[] expectedSizes) throws IOException {
        MyGraph graph = new MyGraph(getClass().getResourceAsStream(filename));
        List<StronglyConnectedComponent> components = StronglyConnectedComponentAlgorithm.computeStronglyConnectedComponents(graph);
        long[] actualSizes = getFirst5ComponentSizes(components);
        assertArrayEquals(expectedSizes, actualSizes);
    }

    private long[] getFirst5ComponentSizes(List<StronglyConnectedComponent> components) {
        Collections.sort(components);
        long[] result = new long[5];
        for (int i = 0; i < 5; i++) {
            if (i < components.size()) {
                result[i] = components.get(i).getSize();
            } else {
                result[i] = 0l;
            }
            System.out.print(result[i] + " ");
        }
        return result;
    }

    //------------------------------------------------------
    @Test
    public void testSccGraph1() throws IOException {
        System.out.println();
        System.out.println("test case 1");
        long[] expectedSizes = {3l, 2l, 0l, 0l, 0l};
        testGraph("scc_graph1.txt", expectedSizes);
    }

    @Test
    public void testSccGraph2() throws IOException {
        System.out.println();
        System.out.println("test case 2");
        long[] expectedSizes = {3l, 3l, 3l, 0l, 0l};
        testGraph("scc_graph2.txt", expectedSizes);
    }

    @Test
    public void testMain() throws IOException {
        System.out.println();
        System.out.println("main task");
        long[] expectedSizes = {3l, 3l, 3l, 0l, 0l};
        testGraph("SCC.txt", expectedSizes);
    }


}
