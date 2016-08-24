package shortestpaths;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dasha on 8/24/2016.
 */
public class MyVertex {
    private int number;
    private List<MyEdge> outEdges;

    public MyVertex(int number, List<MyEdge> outEdges) {
        this.number = number;
        this.outEdges = outEdges;
    }

    public List<MyEdge> getOutEdges() {
        return outEdges;
    }

    public int getNumber() {
        return number;
    }
}
