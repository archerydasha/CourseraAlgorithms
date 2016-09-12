package mst;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Created by Dasha on 9/11/2016.
 */
public class PrimsAlgorithmTest {
    @Test
    public void WeeklyAssingment3() throws IOException {
        testGraphFromFile("edges.txt", -3612829l);
    }

    private void testGraphFromFile(String fileName, Long expectedResult) throws IOException {
        String pathToFile = getClass().getResource(fileName).getPath();
        assertEquals(expectedResult, PrimsAlgorithm.computeSizeOfMST(pathToFile));
    }

    @Test
    public void testSimpleGraph1() throws IOException {
        testGraphFromFile("simple_graph1.txt", 6l);
    }

    @Test
    public void testGraphFromForum1() throws IOException {
        testGraphFromFile("graph_from_forum1.txt", -236l);
    }
}
