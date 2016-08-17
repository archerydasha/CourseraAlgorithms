package components;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dasha on 8/6/2016.
 */
public class MyVertex extends TheVertex {
    List<TheEdge> inEdges;
    List<TheEdge> outEdges;

    public MyVertex(Long vertexNumber) {
        super(vertexNumber);
        inEdges = new ArrayList<TheEdge>();
        outEdges = new ArrayList<TheEdge>();
    }

    public void addInEdge(TheEdge edge) {
        inEdges.add(edge);
    }

    public void addOutEdge(TheEdge edge) {
        outEdges.add(edge);
    }

    public List<TheEdge> getInEdges() {
        return inEdges;
    }

    public List<TheEdge> getOutEdges() {
        return outEdges;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (!(o instanceof MyVertex)) return false;
        MyVertex otherVertex = (MyVertex) o;
        boolean result = true;
        return (initialNumber.equals(otherVertex.getInitialNumber()) &&
                inEdges.containsAll(otherVertex.getInEdges()) &&
                otherVertex.getInEdges().containsAll(inEdges) &&
                outEdges.containsAll(otherVertex.getOutEdges()) &&
                otherVertex.getOutEdges().containsAll(outEdges));
    }
}
