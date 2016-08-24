package shortestpaths;

import java.util.List;

/**
 * Created by Dasha on 8/24/2016.
 */
public class VertexWithShortestPath extends MyVertex {
    MyVertex delegate;
    private long shortestPath;

    public VertexWithShortestPath(MyVertex v, long i) {
        delegate = v;
        shortestPath = i;
    }

    @Override
    public List<MyEdge> getOutEdges() {
        return delegate.getOutEdges();
    }

    @Override
    public int getNumber() {
        return delegate.getNumber();
    }

    public long getShortestPath() {
        return shortestPath;
    }

    public void setShortestPath(long shortestPath) {
        this.shortestPath = shortestPath;
    }
}
