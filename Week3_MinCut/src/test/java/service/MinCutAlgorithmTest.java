package service;

import com.google.common.collect.Lists;
import graphreading.GraphFileReader;
import graphreading.GraphTabSeparatedLineParser;
import model.MyEdge;
import model.MyGraph;
import model.MyVertex;
import org.junit.Test;
import testdata.TestGraphs;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.*;

/**
 * Created by Dasha on 7/29/2016.
 */
public abstract class MinCutAlgorithmTest {
    private GraphFileReader fileReader = new GraphFileReader(new GraphTabSeparatedLineParser());

    protected void testMinCut(String inputFileName, int expectedMinCutSize) throws IOException {
        MyGraph graph = fileReader.readGraphFromFile(readResource(inputFileName));
        int actualResult = MinCutAlgorithm.findMinCut(graph);
        assertEquals(expectedMinCutSize, actualResult);
    }

    private InputStream readResource(String name) {
        return getClass().getResourceAsStream(name);
    }

}
