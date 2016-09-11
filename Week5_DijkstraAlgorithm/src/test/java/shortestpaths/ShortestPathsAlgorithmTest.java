package shortestpaths;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by Dasha on 8/24/2016.
 */
public class ShortestPathsAlgorithmTest {

    public void testGraphFromFile(Map<Integer, Long> expectedResults, String fileName, int sourceVertexNumber) throws IOException, CorruptedInputException {
        String fullFileName = getClass().getResource(fileName).getPath();
        MyGraph graph = MyGraph.readGraphFromFile(fullFileName);
        Map<Integer, Long> actualResult = DijkstraShortestPathsAlgorithm.computeShortestPaths(graph, sourceVertexNumber);
        assertEquals(expectedResults, actualResult);
    }

    @Test
    public void testSmallGraph1() throws IOException, CorruptedInputException {
        Map<Integer, Long> expectedResult = ImmutableMap.of(1, 0l, 2, 5l, 3, 6l, 4, 8l);
        testGraphFromFile(expectedResult, "small_graph_1.txt", 1);
    }

    @Test
    public void testSmallGraph2() throws IOException, CorruptedInputException {
        Map<Integer, Long> expectedResult = ImmutableMap.of(1, 0l, 2, 2l, 3, 1l, 4, 2l);
        testGraphFromFile(expectedResult, "small_graph_2.txt", 1);
    }


    @Test
    public void testGraphFromForum1() throws IOException, CorruptedInputException {
        Map<Integer, Long> expectedResult = new HashMap<>();
        expectedResult.put(1, 0l);
        expectedResult.put(2, 1l);
        expectedResult.put(3, 2l);
        expectedResult.put(4, 3l);
        expectedResult.put(5, 4l);
        expectedResult.put(6, 4l);
        expectedResult.put(7, 3l);
        expectedResult.put(8, 2l);
        testGraphFromFile(expectedResult, "graph_from_forum_1.txt", 1);
    }

    @Test
    public void MainAssignmentWeek5() throws IOException, CorruptedInputException {
        MyGraph graph = MyGraph.readGraphFromFile(getClass().getResource("dijkstraData.txt").getPath());
        Map<Integer, Long> shortestPaths = DijkstraShortestPathsAlgorithm.computeShortestPaths(graph, 1);
        String result = "";
        result += shortestPaths.get(7) + ",";
        result += shortestPaths.get(37) + ",";
        result += shortestPaths.get(59) + ",";
        result += shortestPaths.get(82) + ",";
        result += shortestPaths.get(99) + ",";
        result += shortestPaths.get(115) + ",";
        result += shortestPaths.get(133) + ",";
        result += shortestPaths.get(165) + ",";
        result += shortestPaths.get(188) + ",";
        result += shortestPaths.get(197);

        String expectedResult = "2599,2610,2947,2052,2367,2399,2029,2442,2505,3068";

        assertEquals(expectedResult, result);
    }


}
