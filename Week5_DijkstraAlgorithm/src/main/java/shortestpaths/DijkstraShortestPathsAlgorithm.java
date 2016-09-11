package shortestpaths;

import java.util.*;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.MapDifference;

/**
 * Created by Dasha on 8/24/2016.
 */
public class DijkstraShortestPathsAlgorithm {
    public static Map<Integer, Long> computeShortestPaths(MyGraph graph, int sourceVertexNumber) throws CorruptedInputException {

        PriorityQueue<VertexWithShortestPath> vertexHeap = new PriorityQueue<>(new Comparator<VertexWithShortestPath>() {
            @Override
            public int compare(VertexWithShortestPath o1, VertexWithShortestPath o2) {
                if (o1.getShortestPath() == o2.getShortestPath()) return 0;
                return (o1.getShortestPath() - o2.getShortestPath()) > 0 ? 1 : -1;
            }
        });

        Map<Integer, Long> computedPaths = new HashMap<>();
        VertexWithShortestPath lastAddedVertex = null;

        for (MyVertex v : graph.getVertices()) {
            if (sourceVertexNumber == v.getNumber()) {
                computedPaths.put(sourceVertexNumber, 0l);
                lastAddedVertex = new VertexWithShortestPath(v, 0);
            } else {
                vertexHeap.add(new VertexWithShortestPath(v, 1000000));
            }
        }

        if (lastAddedVertex == null) {
            throw new CorruptedInputException("The graph does not have a source vertex specified");
        }
        while (vertexHeap.size() > 0) {
            //recomputing correct heap values
            for (MyEdge edge : lastAddedVertex.getOutEdges()) {
                VertexWithShortestPath affectedVertex = Iterables.find(vertexHeap, new Predicate<VertexWithShortestPath>() {
                    @Override
                    public boolean apply(VertexWithShortestPath vertex) {
                        return vertex.getNumber() == edge.getHead();
                    }
                }, null);

                if (affectedVertex != null) {
                    //if it is null - it is probably already gone from the heap
                    long newShortestPath = lastAddedVertex.getShortestPath() + edge.getLength();
                    if (newShortestPath < affectedVertex.getShortestPath()) {
                        vertexHeap.remove(affectedVertex);
                        affectedVertex.setShortestPath(newShortestPath);
                        vertexHeap.add(affectedVertex);
                    }
                }
            }
            //actually finding new candidate
            lastAddedVertex = vertexHeap.poll();
            computedPaths.put(lastAddedVertex.getNumber(), lastAddedVertex.getShortestPath());
        }

        return computedPaths;
    }

}
