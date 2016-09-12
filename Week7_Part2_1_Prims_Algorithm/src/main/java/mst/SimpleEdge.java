package mst;

/**
 * Created by Dasha on 9/11/2016.
 */
public class SimpleEdge {
    private Long vertex1;
    private Long vertex2;
    private Long cost;

    public SimpleEdge(Long vertex1, Long vertex2, Long cost) {
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
        this.cost = cost;
    }

    public Long getVertex1() {
        return vertex1;
    }

    public Long getVertex2() {
        return vertex2;
    }

    public Long getCost() {
        return cost;
    }
}
