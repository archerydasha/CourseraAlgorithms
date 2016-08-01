package service;

import graphreading.GraphFileReader;
import graphreading.GraphTabSeparatedLineParser;
import model.MyGraph;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import static org.junit.Assert.*;

/**
 * Created by arche on 7/31/2016.
 */
public class MinCutTestFromForum {
    private GraphFileReader fileReader = new GraphFileReader(new GraphTabSeparatedLineParser());
    @Test
    public void testBigGraph1() throws IOException {
        InputStream input = getClass().getResourceAsStream("big_graph_1.txt");
        MyGraph bigGraph = fileReader.readGraphFromFile(input);
        int expectedResult = 2;
        int actualResult = MinCutAlgorithm.findMinCut(bigGraph);
        assertEquals(expectedResult, actualResult);
    }
    @Test
    public void testBigGraph1Permuted() throws IOException {
        InputStream input = getClass().getResourceAsStream("big_graph_1_permuted.txt");
        MyGraph bigGraph = fileReader.readGraphFromFile(input);
        int expectedResult = 2;
        int actualResult = MinCutAlgorithm.findMinCut(bigGraph);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testBigGraph2() throws IOException {
        InputStream input = getClass().getResourceAsStream("big_graph_2.txt");
        MyGraph bigGraph = fileReader.readGraphFromFile(input);
        int expectedResult = 1;
        int actualResult = MinCutAlgorithm.findMinCut(bigGraph);
        assertEquals(expectedResult, actualResult);
    }
    @Test
    public void testBigGraph2Permuted() throws IOException {
        InputStream input = getClass().getResourceAsStream("big_graph_2_permuted.txt");
        MyGraph bigGraph = fileReader.readGraphFromFile(input);
        int expectedResult = 1;
        int actualResult = MinCutAlgorithm.findMinCut(bigGraph);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testBigGraph3() throws IOException {
        InputStream input = getClass().getResourceAsStream("big_graph_3.txt");
        MyGraph bigGraph = fileReader.readGraphFromFile(input);
        int expectedResult = 3;
        int actualResult = MinCutAlgorithm.findMinCut(bigGraph);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testBigGraph4() throws IOException {
        InputStream input = getClass().getResourceAsStream("big_graph_4.txt");
        MyGraph bigGraph = fileReader.readGraphFromFile(input);
        int expectedResult = 2;
        int actualResult = MinCutAlgorithm.findMinCut(bigGraph);
        assertEquals(expectedResult, actualResult);
    }

}
