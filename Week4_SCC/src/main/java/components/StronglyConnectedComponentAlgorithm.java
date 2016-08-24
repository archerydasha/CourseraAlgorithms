package components;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Dasha on 8/7/2016.
 */
public class StronglyConnectedComponentAlgorithm {
    private StronglyConnectedComponentAlgorithm() {
    }

    //ToDo - refactor this
    private static long finishingTime;

    public static List<StronglyConnectedComponent> computeStronglyConnectedComponents(TheGraph graph) {
        //First loop on G-rev

        StronglyConnectedComponentAlgorithm.finishingTime = 0l;

        List<TheVertex> vertices = graph.getVertices();

        sortVerticesByInitialNumber(vertices);

        for (TheVertex vertex : vertices) {
            if (!vertex.isExplored()) {
                Reverse_DFS(vertex);
            }
        }

        sortVerticesByFinishingTime(vertices);

        for (TheVertex vertex : vertices) {
            vertex.setExplored(false);
        }
        TheVertex source = null;
        List<StronglyConnectedComponent> components = new ArrayList<StronglyConnectedComponent>();

        for (TheVertex vertex : vertices) {
            if (!vertex.isExplored()) {
                source = vertex;
                Forward_DFS(vertex, source, components);
            }
        }
        return components;
    }

    public static void sortVerticesByFinishingTime(List<TheVertex> vertices) {
        Collections.sort(vertices, new Comparator<TheVertex>() {
            public int compare(TheVertex o1, TheVertex o2) {
                long difference = o2.getFinishingTime() - o1.getFinishingTime();
                if (difference == 0l) return 0;
                return difference > 0 ? 1 : -1;
            }
        });
    }

    public static void sortVerticesByInitialNumber(List<TheVertex> vertices) {
        Collections.sort(vertices, new Comparator<TheVertex>() {
            public int compare(TheVertex o1, TheVertex o2) {
                long difference = o2.getInitialNumber() - o1.getInitialNumber();
                if (difference == 0l) return 0;
                return difference > 0 ? 1 : -1;
            }
        });
    }

    private static void Reverse_DFS(TheVertex vertex) {
        vertex.setExplored(true);
        for (TheEdge edge : vertex.getInEdges()) {
            TheVertex nextVertex = edge.getTail();
            if (!nextVertex.isExplored()) {
                Reverse_DFS(nextVertex);
            }
        }
        vertex.setFinishingTime(StronglyConnectedComponentAlgorithm.finishingTime);
        StronglyConnectedComponentAlgorithm.finishingTime++;
    }


    private static void Forward_DFS(TheVertex vertex, TheVertex source, List<StronglyConnectedComponent> components) {
        vertex.setExplored(true);
        addVertexToScc(vertex, source, components);
        for (TheEdge edge : vertex.getOutEdges()) {
            TheVertex nextVertex = edge.getHead();
            if (!nextVertex.isExplored()) {
                Forward_DFS(nextVertex, source, components);
            }
        }
    }

    private static void addVertexToScc(TheVertex vertex, final TheVertex source, List<StronglyConnectedComponent> components) {
        StronglyConnectedComponent currentComponent = Iterables.find(components, new Predicate<StronglyConnectedComponent>() {
            public boolean apply(StronglyConnectedComponent stronglyConnectedComponent) {
                return stronglyConnectedComponent.getSource() == source.getInitialNumber();
            }
        }, null);
        if (currentComponent == null) {
            currentComponent = new StronglyConnectedComponent(source.getInitialNumber());
            components.add(currentComponent);
        }
        currentComponent.setSize(currentComponent.getSize() + 1);
    }
}
