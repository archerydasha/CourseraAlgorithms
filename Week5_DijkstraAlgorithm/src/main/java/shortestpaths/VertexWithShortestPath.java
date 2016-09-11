package shortestpaths;

import java.util.List;

/**
 * Created by Dasha on 8/24/2016.
 */
public class VertexWithShortestPath {
    private MyVertex delegate;
    private long shortestPath;

    public VertexWithShortestPath(MyVertex v, long i) {
        delegate = v;
        shortestPath = i;
    }

    public List<MyEdge> getOutEdges() {
        return delegate.getOutEdges();
    }

    public int getNumber() {
        return delegate.getNumber();
    }

    public long getShortestPath() {
        return shortestPath;
    }

    public void setShortestPath(long shortestPath) {
        this.shortestPath = shortestPath;
    }

    @Override
    public boolean equals(Object o){
        if (o == null) return false;
        if (!(o instanceof VertexWithShortestPath)) return false;
        VertexWithShortestPath otherVertex = (VertexWithShortestPath)o;
        return delegate.equals(otherVertex.delegate);
    }
}
