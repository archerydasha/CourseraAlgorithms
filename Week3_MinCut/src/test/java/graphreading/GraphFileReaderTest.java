package graphreading;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import model.MyGraph;
import model.MyVertex;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Created by Dasha on 7/29/2016.
 */
public class GraphFileReaderTest {
    @Test
    public void testGraphReading1() throws IOException {
        MyVertex vertex1 = new MyVertex(1, Sets.newHashSet(2));
        MyVertex vertex2 = new MyVertex(2, Sets.newHashSet(1));
        MyGraph graph = new MyGraph(Lists.newArrayList(vertex1, vertex2));
        GraphFileReader graphFileReader = new GraphFileReader(new GraphTabSeparatedLineParser());
        assertEquals(graph, graphFileReader.readGraphFromFile(getClass().getResourceAsStream("small_graph_1.txt")));
    }

    @Test
    public void testGraphReading2() throws IOException {
        MyVertex vertex1 = new MyVertex(1, Sets.newHashSet(2));
        MyVertex vertex2 = new MyVertex(2, Sets.newHashSet(1,3,4));
        MyVertex vertex3 = new MyVertex(3, Sets.newHashSet(4));
        MyVertex vertex4 = new MyVertex(4, Sets.newHashSet(3));
        MyGraph graph = new MyGraph(Lists.newArrayList(vertex1, vertex2, vertex3, vertex4));
        GraphFileReader graphFileReader = new GraphFileReader(new GraphTabSeparatedLineParser());
        assertEquals(graph, graphFileReader.readGraphFromFile(getClass().getResourceAsStream("small_graph_2.txt")));
    }

    @Test
    public void testGraphReading3() throws IOException {
        MyVertex vertex1 = new MyVertex(1, Sets.newHashSet(2,3));
        MyVertex vertex2 = new MyVertex(2, Sets.newHashSet(1,3));
        MyVertex vertex3 = new MyVertex(3, Sets.newHashSet(1,2));
        MyGraph graph = new MyGraph(Lists.newArrayList(vertex1, vertex2, vertex3));
        GraphFileReader graphFileReader = new GraphFileReader(new GraphTabSeparatedLineParser());
        assertEquals(graph, graphFileReader.readGraphFromFile(getClass().getResourceAsStream("small_graph_3.txt")));
    }

    @Test
    public void testGraphReading4() throws IOException {
        MyVertex vertex1 = new MyVertex(1, Sets.newHashSet(2,3));
        MyVertex vertex2 = new MyVertex(2, Sets.newHashSet(1,4,5));
        MyVertex vertex3 = new MyVertex(3, Sets.newHashSet(1,4));
        MyVertex vertex4 = new MyVertex(4, Sets.newHashSet(7,2,3));
        MyVertex vertex5 = new MyVertex(5, Sets.newHashSet(7,2,6));
        MyVertex vertex6 = new MyVertex(6, Sets.newHashSet(5,8));
        MyVertex vertex7 = new MyVertex(7, Sets.newHashSet(5,8,4));
        MyVertex vertex8 = new MyVertex(8, Sets.newHashSet(6,7));
        MyGraph graph = new MyGraph(Lists.newArrayList(vertex1, vertex2, vertex3, vertex4, vertex5, vertex6, vertex7, vertex8));
        GraphFileReader graphFileReader = new GraphFileReader(new GraphTabSeparatedLineParser());
        assertEquals(graph, graphFileReader.readGraphFromFile(getClass().getResourceAsStream("small_graph_4.txt")));
    }
}
