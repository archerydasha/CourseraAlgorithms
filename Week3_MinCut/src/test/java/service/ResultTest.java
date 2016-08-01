package service;

import graphreading.GraphFileReader;
import graphreading.GraphTabSeparatedLineParser;
import model.MyGraph;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;

/**
 * Created by arche on 8/1/2016.
 */
public class ResultTest {
    private GraphFileReader fileReader = new GraphFileReader(new GraphTabSeparatedLineParser());

    @Test
    public void testResult() throws IOException {
        InputStream input = getClass().getResourceAsStream("kargerMinCut.txt");
        MyGraph bigGraph = fileReader.readGraphFromFile(input);
        int expectedResult = 17;
        int actualResult = MinCutAlgorithm.findMinCut(bigGraph);
        assertEquals(expectedResult, actualResult);
    }
}
