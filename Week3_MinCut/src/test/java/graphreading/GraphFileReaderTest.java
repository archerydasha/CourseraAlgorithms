package graphreading;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
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
public class GraphFileReaderTest {

    private GraphFileReader graphFileReader = new GraphFileReader(new GraphTabSeparatedLineParser());;

    @Test
    public void testGraphReading1() throws IOException {
        MyGraph graph = TestGraphs.createSimpleGraph1();
        assertEquals(graph, graphFileReader.readGraphFromFile(readResource("small_graph_1.txt")));
    }

    @Test
    public void testGraphReading2() throws IOException {
        MyGraph graph = TestGraphs.createSimpleGraph2();
        assertEquals(graph, graphFileReader.readGraphFromFile(readResource("small_graph_2.txt")));
    }

    @Test
    public void testGraphReading3() throws IOException {
        MyGraph graph = TestGraphs.createSimpleGraph3();
        assertEquals(graph, graphFileReader.readGraphFromFile(readResource("small_graph_3.txt")));
    }

    @Test
    public void testGraphReading4() throws IOException {
        MyGraph graph = TestGraphs.createSimpleGraph4();
        assertEquals(graph, graphFileReader.readGraphFromFile(readResource("small_graph_4.txt")));
    }


    private InputStream readResource(String name) {
        return getClass().getResourceAsStream(name);
    }
}
