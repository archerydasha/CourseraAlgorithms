package shortestpaths;

import com.google.common.collect.Lists;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.IOException;

/**
 * Created by Dasha on 8/24/2016.
 */
public class GraphReadingTest {
    @Test
    public void testReadingSmallGraph1() throws IOException {
        MyVertex vertex1 = new MyVertex(1, Lists.newArrayList(new MyEdge(2,5), new MyEdge(3,8)));
        MyVertex vertex2 = new MyVertex(2, Lists.newArrayList(new MyEdge(3,1), new MyEdge(4,7)));
        MyVertex vertex3 = new MyVertex(3, Lists.newArrayList(new MyEdge(4,2)));
        MyVertex vertex4 = new MyVertex(4, Lists.newArrayList());
        MyGraph expectedResult = new MyGraph(Lists.newArrayList(vertex1, vertex2, vertex3, vertex4));
        String fileName = getClass().getResource("small_graph_1.txt").getPath();
        MyGraph actualResult = MyGraph.readGraphFromFile(fileName);
        assertEquals(expectedResult,actualResult);
    }

    @Test
    public void testReadingSmallGraph2() throws IOException{
        MyVertex vertex1 = new MyVertex(1, Lists.newArrayList(new MyEdge(2,2), new MyEdge(3,1), new MyEdge(4,5)));
        MyVertex vertex2 = new MyVertex(2, Lists.newArrayList());
        MyVertex vertex3 = new MyVertex(3, Lists.newArrayList(new MyEdge(4,1)));
        MyVertex vertex4 = new MyVertex(4, Lists.newArrayList());
        MyGraph expectedResult = new MyGraph(Lists.newArrayList(vertex1, vertex2, vertex3, vertex4));
        String fileName = getClass().getResource("small_graph_2.txt").getPath();
        MyGraph actualResult = MyGraph.readGraphFromFile(fileName);
        assertEquals(expectedResult, actualResult);
    }
}
