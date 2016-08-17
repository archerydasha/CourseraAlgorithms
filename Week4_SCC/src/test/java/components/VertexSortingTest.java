package components;

import org.junit.Test;

import java.io.IOException;
import java.util.List;
import static org.junit.Assert.*;

/**
 * Created by Dasha on 8/7/2016.
 */
public class VertexSortingTest {
    @Test
    public void testSortingByInitialNumber1() throws IOException {
        MyGraph graph = new MyGraph(getClass().getResourceAsStream("sorting_graph1.txt"));
        List<TheVertex> vertices = graph.getVertices();
        StronglyConnectedComponentAlgorithm.sortVerticesByInitialNumber(vertices);
        assert(vertices.get(0).getInitialNumber().equals(4l));
        assert(vertices.get(1).getInitialNumber().equals(3l));
        assert(vertices.get(2).getInitialNumber().equals(2l));
        assert(vertices.get(3).getInitialNumber().equals(1l));

    }
}
