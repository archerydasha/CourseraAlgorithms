package service;

import com.google.common.collect.Lists;
import model.MyEdge;
import model.MyGraph;
import model.MyVertex;
import org.junit.Test;
import testdata.TestGraphs;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * Created by arche on 8/1/2016.
 */
public class MinCutSmallGraphsTest extends MinCutAlgorithmTest {
    @Test
    public void TestEdgeContraction1(){
        MyGraph graph = TestGraphs.createSimpleGraph2();
        MinCutAlgorithm.contractEdge(new MyEdge(2,3),graph);
        MyVertex vertex1 = new MyVertex(1, Lists.newArrayList(2));
        MyVertex vertex2 = new MyVertex(2, Lists.newArrayList(1,4,4));
        MyVertex vertex4 = new MyVertex(4, Lists.newArrayList(2,2));
        MyGraph expectedResult = new MyGraph(Lists.newArrayList(vertex1, vertex2, vertex4));
        assertEquals(expectedResult, graph);

    }

    @Test
    public void TestEdgeContraction2(){
        MyVertex vertex1 = new MyVertex(1, Lists.newArrayList(2));
        MyVertex vertex2 = new MyVertex(2, Lists.newArrayList(1,4,4));
        MyVertex vertex4 = new MyVertex(4, Lists.newArrayList(2,2));
        MyGraph graph = new MyGraph(Lists.newArrayList(vertex1, vertex2, vertex4));
        MinCutAlgorithm.contractEdge(new MyEdge(2,4), graph);
        MyVertex newVertex1 = new MyVertex(1,Lists.newArrayList(2));
        MyVertex newVertex2 = new MyVertex(2,Lists.newArrayList(1));
        MyGraph expectedResult =new MyGraph(Lists.newArrayList(newVertex1, newVertex2));
        assertEquals(expectedResult, graph);

    }


    @Test
    public void TestMinCut1() throws IOException {
        testMinCut("small_graph_1.txt", 1);
    }

    @Test
    public void TestMinCut2() throws IOException {
        testMinCut("small_graph_2.txt", 1);
    }

    @Test
    public void TestMinCut3() throws IOException {
        testMinCut("small_graph_3.txt", 2);
    }

    @Test
    public void TestMinCut4() throws IOException {
        testMinCut("small_graph_4.txt", 2);
    }
}
