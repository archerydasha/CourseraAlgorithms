package mst;

import java.util.List;

/**
 * Created by Dasha on 9/11/2016.
 */
public class SimpleGraph {
    private List<Long> vertices;
    private List<SimpleEdge> edges;


    public SimpleGraph(List<Long> vertices, List<SimpleEdge> edges) {
        this.vertices = vertices;
        this.edges = edges;
    }

    public List<Long> getVertices() {
        return vertices;
    }

    public List<SimpleEdge> getEdges() {
        return edges;
    }
}
