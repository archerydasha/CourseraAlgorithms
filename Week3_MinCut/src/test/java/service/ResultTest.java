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
public class ResultTest extends MinCutAlgorithmTest{
   @Test
    public void testResult() throws IOException {
        testMinCut("kargerMinCut.txt", 17);
    }
}
