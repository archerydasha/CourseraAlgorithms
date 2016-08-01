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
public class MinCutTestFromForum  extends MinCutAlgorithmTest{

    @Test
    public void testBigGraph1() throws IOException {
        testMinCut("big_graph_1.txt", 2);
    }
    @Test
    public void testBigGraph1Permuted() throws IOException {
        testMinCut("big_graph_1_permuted.txt", 2);
    }

    @Test
    public void testBigGraph2() throws IOException {
        testMinCut("big_graph_2.txt", 1);
    }
    @Test
    public void testBigGraph2Permuted() throws IOException {
        testMinCut("big_graph_2_permuted.txt", 1);
    }

    @Test
    public void testBigGraph3() throws IOException {
        testMinCut("big_graph_3.txt", 3);
    }

    @Test
    public void testBigGraph4() throws IOException {
        testMinCut("big_graph_4.txt", 2);
    }
}
