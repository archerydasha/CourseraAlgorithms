package shortestpaths;

import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Dasha on 9/4/2016.
 */
public class PriorityQueueTest {
    @Test
    public void testPriorityQueue() {
        PriorityQueue<VertexWithShortestPath> vertices = new PriorityQueue<>(new Comparator<VertexWithShortestPath>() {
            @Override
            public int compare(VertexWithShortestPath o1, VertexWithShortestPath o2) {
                return (int) (o1.getShortestPath() - o2.getShortestPath());
            }
        });
        MyVertex vertex1 = new MyVertex(1, null);
        VertexWithShortestPath v1 = new VertexWithShortestPath(vertex1, 1);
        MyVertex vertex2 = new MyVertex(2, null);
        VertexWithShortestPath v2 = new VertexWithShortestPath(vertex2, 2);
        vertices.add(v1);
        vertices.add(v2);
        System.out.println(vertices.peek().getNumber() + " " + vertices.peek().getShortestPath());
        vertices.remove(v1);
        v1.setShortestPath(4);
        vertices.add(v1);
        System.out.println(vertices.peek().getNumber() + " " + vertices.peek().getShortestPath());

    }
}
