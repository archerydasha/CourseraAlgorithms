package components;

import com.google.common.collect.Lists;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dasha on 8/7/2016.
 */
public class GraphReadingFromFileTest {
    @Test
    public void testReadingSmallGraph1() throws IOException {
        MyGraph graph = new MyGraph(getClass().getResourceAsStream("small_graph1.txt"));

        MyVertex firstVertex = new MyVertex(1l);
        MyVertex secondVertex = new MyVertex(2l);
        MyVertex thirdVertex = new MyVertex(3l);
        MyEdge firstEdge = new MyEdge(firstVertex, secondVertex);
        MyEdge secondEdge = new MyEdge(secondVertex, thirdVertex);
        firstVertex.addOutEdge(firstEdge);
        secondVertex.addInEdge(firstEdge);
        secondVertex.addOutEdge(secondEdge);
        thirdVertex.addInEdge(secondEdge);
        MyGraph expectedResultGraph = new MyGraph(Lists.newArrayList(firstVertex, secondVertex, thirdVertex));

        assertEquals(expectedResultGraph, graph);
    }

    @Test
    public void testReadingSmallGraph2() throws IOException {
        MyGraph graph = new MyGraph(getClass().getResourceAsStream("small_graph2.txt"));

        MyVertex firstVertex = new MyVertex(1l);
        MyVertex secondVertex = new MyVertex(2l);
        MyVertex thirdVertex = new MyVertex(3l);
        MyEdge firstEdge = new MyEdge(firstVertex, secondVertex);
        MyEdge secondEdge = new MyEdge(secondVertex, thirdVertex);
        MyEdge thirdEdge = new MyEdge(firstVertex, thirdVertex);
        firstVertex.addOutEdge(firstEdge);
        firstVertex.addOutEdge(thirdEdge);
        secondVertex.addInEdge(firstEdge);
        secondVertex.addOutEdge(secondEdge);
        thirdVertex.addInEdge(secondEdge);
        thirdVertex.addInEdge(thirdEdge);
        MyGraph expectedResultGraph = new MyGraph(Lists.newArrayList(firstVertex, secondVertex, thirdVertex));

        assertEquals(expectedResultGraph, graph);
    }

}
