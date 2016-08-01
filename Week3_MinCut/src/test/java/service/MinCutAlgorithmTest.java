package service;

import com.google.common.collect.Lists;
import model.MyEdge;
import model.MyGraph;
import model.MyVertex;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Dasha on 7/29/2016.
 */
public class MinCutAlgorithmTest {
    @Test
    public void TestEdgeContraction1(){
        MyGraph graph = createSimpleGraph2();
        MinCutAlgorithm.ContractEdge(new MyEdge(2,3),graph);
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
        MinCutAlgorithm.ContractEdge(new MyEdge(2,4), graph);
        MyVertex newVertex1 = new MyVertex(1,Lists.newArrayList(2));
        MyVertex newVertex2 = new MyVertex(2,Lists.newArrayList(1));
        MyGraph expectedResult =new MyGraph(Lists.newArrayList(newVertex1, newVertex2));
        assertEquals(expectedResult, graph);

    }


    @Test
    public void TestMinCut1(){
        MyGraph graph = createSimpleGraph1();
        int expectedResult = 1;
        int actualResult = MinCutAlgorithm.findMinCut(graph);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void TestMinCut2(){
        MyGraph graph = createSimpleGraph2();
        int expectedResult = 1;
        int actualResult = MinCutAlgorithm.findMinCut(graph);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void TestMinCut3(){
        MyGraph graph = createSimpleGraph3();
        int expectedResult = 2;
        int actualResult = MinCutAlgorithm.findMinCut(graph);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void TestMinCut4(){
        MyGraph graph = createSimpleGraph4();
        int expectedResult = 2;
        int actualResult = MinCutAlgorithm.findMinCut(graph);
        assertEquals(expectedResult, actualResult);
    }

//----------------------------------------------------------------


    private MyGraph createSimpleGraph1() {
        MyVertex vertex1 = new MyVertex(1, Lists.newArrayList(2));
        MyVertex vertex2 = new MyVertex(2, Lists.newArrayList(1));
        return new MyGraph(Lists.newArrayList(vertex1, vertex2));
    }

    private MyGraph createSimpleGraph2() {
        MyVertex vertex1 = new MyVertex(1, Lists.newArrayList(2));
        MyVertex vertex2 = new MyVertex(2, Lists.newArrayList(1,3,4));
        MyVertex vertex3 = new MyVertex(3, Lists.newArrayList(4,2));
        MyVertex vertex4 = new MyVertex(4, Lists.newArrayList(3,2));
        return new MyGraph(Lists.newArrayList(vertex1, vertex2, vertex3, vertex4));
    }


    private MyGraph createSimpleGraph3() {
        MyVertex vertex1 = new MyVertex(1, Lists.newArrayList(2,3));
        MyVertex vertex2 = new MyVertex(2, Lists.newArrayList(1,3));
        MyVertex vertex3 = new MyVertex(3, Lists.newArrayList(1,2));
        MyGraph graph = new MyGraph(Lists.newArrayList(vertex1, vertex2, vertex3));
        return graph;
    }

    private MyGraph createSimpleGraph4(){
        MyVertex vertex1 = new MyVertex(1, Lists.newArrayList(2,3));
        MyVertex vertex2 = new MyVertex(2, Lists.newArrayList(1,4,5));
        MyVertex vertex3 = new MyVertex(3, Lists.newArrayList(1,4));
        MyVertex vertex4 = new MyVertex(4, Lists.newArrayList(7,2,3));
        MyVertex vertex5 = new MyVertex(5, Lists.newArrayList(7,2,6));
        MyVertex vertex6 = new MyVertex(6, Lists.newArrayList(5,8));
        MyVertex vertex7 = new MyVertex(7, Lists.newArrayList(5,8,4));
        MyVertex vertex8 = new MyVertex(8, Lists.newArrayList(6,7));
        MyGraph graph = new MyGraph(Lists.newArrayList(vertex1, vertex2, vertex3, vertex4, vertex5, vertex6, vertex7, vertex8));
        return graph;
    }
    //ToDo - for implementation
    //small_graph_1.txt - min cut with size 1, formed by edge (1,2)
    //small_graph_2.txt - min cut with size 1, formed by edge (1,2)
    //small_graph_3.txt - min cut with size 2, formed by edge (1,2) or (1,2) or (2,3)
    //small_graph_4.txt - min cut with size 2, formed by edge (2,5) and (4,7)
}
