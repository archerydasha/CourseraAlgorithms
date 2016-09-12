package mst;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

import java.io.IOException;
import java.util.*;

/**
 * Created by Dasha on 9/11/2016.
 */
public class PrimsAlgorithm {
    private PrimsAlgorithm() {
    }

    public static Long computeSizeOfMST(String fileName) throws IOException {
        SimpleGraph graph = SimpleGraphReader.readGraphFromFile(fileName);
        return computeSizeOfMST(graph);
    }

    public static Long computeSizeOfMST(SimpleGraph graph) {
        List<Long> unSpannedVertices = new ArrayList<>(graph.getVertices());
        List<Long> spannedVertices = new ArrayList<>();
        Long size = 0l;
        moveVertexToSpanned(spannedVertices, unSpannedVertices, unSpannedVertices.get(0));
        while (!(unSpannedVertices.isEmpty())) {
            Predicate<SimpleEdge> isOnFrontier = new Predicate<SimpleEdge>() {
                @Override
                public boolean apply(SimpleEdge simpleEdge) {
                    return ((spannedVertices.contains(simpleEdge.getVertex1()) &&
                            unSpannedVertices.contains(simpleEdge.getVertex2()) ||
                            (spannedVertices.contains(simpleEdge.getVertex2()) &&
                                    unSpannedVertices.contains(simpleEdge.getVertex1()))));
                }
            };
            List<SimpleEdge> frontier = Lists.newArrayList(Iterables.filter(graph.getEdges(), isOnFrontier));
            Collections.sort(frontier, new Comparator<SimpleEdge>() {
                @Override
                public int compare(SimpleEdge o1, SimpleEdge o2) {
                    return o1.getCost().compareTo(o2.getCost());
                }
            });
            SimpleEdge nextEdge = frontier.get(0);
            Long tail;
            if (spannedVertices.contains(nextEdge.getVertex1())) {
                tail = nextEdge.getVertex2();
            } else {
                tail = nextEdge.getVertex1();
            }
            moveVertexToSpanned(spannedVertices, unSpannedVertices, tail);
            size += nextEdge.getCost();
        }
        return size;
    }

    private static void moveVertexToSpanned(List<Long> spannedVertices, List<Long> unSpannedVertices, Long vertexNumber) {
        int i = unSpannedVertices.indexOf(vertexNumber);
        spannedVertices.add(unSpannedVertices.get(i));
        unSpannedVertices.remove(i);
    }
}
