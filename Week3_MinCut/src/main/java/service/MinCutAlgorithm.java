package service;


import model.MyEdge;
import model.MyGraph;
import model.MyVertex;

import java.util.List;


/**
 * Created by arche on 7/31/2016.
 */
public class MinCutAlgorithm {

    public static int findMinCut(MyGraph graph) {
        int graphSize = graph.getVertices().size();
        int numberOfTrials = (int)Math.pow(graphSize, 2);// Math.round(Math.pow(graphSize, 2) * calculateNumberOfEdges(graph));
        int minCutSize = Integer.MAX_VALUE;
        for (int i = 0; i < numberOfTrials; i++) {
            int cutSize = findRandomCut(graph.copy());
            if (cutSize < minCutSize) {
                minCutSize = cutSize;
            }
        }
        return minCutSize;
    }

    public static int findRandomCut(MyGraph graph) {
        while (graph.getVertices().size() > 2) {
            MyEdge edge = findRandomEdge(graph);
            ContractEdge(edge, graph);
        }
        ;
        return graph.getVertices().get(0).getIncidentVertices().size();
    }

    private static MyEdge findRandomEdge(MyGraph graph) {
        //long numberOfEdges = calculateNumberOfEdges(graph);
        long numberOfEdges = graph.getNumberOfEdges();
        long edgeNumber = Math.round(Math.random() * (double) numberOfEdges);
        if (edgeNumber == 0) {
            edgeNumber = 1;
        }
        MyVertex tailVertex = null;
        for (MyVertex vertex : graph.getVertices()) {
            int incidendVerticesCount = vertex.getIncidentVertices().size();
            if (incidendVerticesCount >= edgeNumber) {
                tailVertex = vertex;
                break;
            }
            edgeNumber -= incidendVerticesCount;
        }
        Integer tail = tailVertex.getNumber();
        Integer head = tailVertex.getIncidentVertices().get((int) edgeNumber - 1);

        return new MyEdge(tail, head);
    }

    private static long calculateNumberOfEdges(MyGraph graph) {
        long numberOfEdges = 0l;
        for (MyVertex v : graph.getVertices()) {
            numberOfEdges += v.getIncidentVertices().size();
        }
        return numberOfEdges;
    }

    public static void ContractEdge(MyEdge edge, MyGraph graph) {
        MyVertex tailVertex = graph.getVertexByNumber(edge.getTail());
        MyVertex headVertex = graph.getVertexByNumber(edge.getHead());
        List<Integer> incidentVertices = tailVertex.getIncidentVertices();
        incidentVertices.addAll(headVertex.getIncidentVertices());
        while (incidentVertices.contains(edge.getTail())) {
            incidentVertices.remove(edge.getTail());
            graph.reduceNumberOfEdgesByOne();
        }
        while (incidentVertices.contains(edge.getHead())) {
            incidentVertices.remove(edge.getHead());
            graph.reduceNumberOfEdgesByOne();
        }
        graph.getVertices().remove(headVertex);
        for (Integer vertexNumber : incidentVertices) {
            MyVertex incidentVertex = graph.getVertexByNumber(vertexNumber);
            while (incidentVertex.getIncidentVertices().contains(edge.getHead())) {
                incidentVertex.getIncidentVertices().remove(edge.getHead());
                incidentVertex.getIncidentVertices().add(edge.getTail());
            }
        }
    }


}
