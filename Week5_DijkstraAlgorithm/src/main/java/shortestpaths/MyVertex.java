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
        if(outEdges == null)
            this.outEdges = new ArrayList<>();
        else
            this.outEdges = outEdges;
    }

    public List<MyEdge> getOutEdges() {
        return outEdges;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (!(o instanceof MyVertex)) return false;
        MyVertex otherVertex = (MyVertex) o;
        return number == otherVertex.getNumber() && outEdges.containsAll(otherVertex.getOutEdges()) &&
                otherVertex.getOutEdges().containsAll(outEdges);
    }
}
