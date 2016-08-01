package model;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dasha on 7/29/2016.
 */
public class MyGraph implements Cloneable {
    long numberOfEdges;
    List<MyVertex> vertices;

    public MyGraph() {
        this(null);
    }

    public MyGraph(List<MyVertex> vertices) {
        numberOfEdges = 0l;
        this.vertices = new ArrayList<MyVertex>();
        if (vertices != null) {
            for (MyVertex v : vertices) {
                addVertexAndCountEdges(v);
            }
        }
    }

    private void addVertexAndCountEdges(MyVertex v) {
        vertices.add(v);
        numberOfEdges += v.getIncidentVertices().size();
    }

    public void reduceNumberOfEdgesByOne(){
        numberOfEdges--;
    }

    public long getNumberOfEdges() {
        return numberOfEdges;
    }

    public MyVertex getVertexByNumber(final Integer vertexNumber) {
        return Iterables.find(vertices, new Predicate<MyVertex>() {
            public boolean apply(MyVertex vertex) {
                return vertex.getNumber().equals(vertexNumber);
            }
        }, null);
    }


    public List<MyVertex> getVertices() {
        return vertices;
    }

    public void addVertex(MyVertex vertex) {
        if (getVertexByNumber(vertex.getNumber()) != null) {
            throw new GraphCreationException("Trying to add vertex " + vertex.getNumber() + " to the graph that already has this vertex!");
        }
        addVertexAndCountEdges(vertex);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (!(o instanceof MyGraph)) return false;
        MyGraph otherGraph = (MyGraph) o;
        return (otherGraph.getVertices().containsAll(vertices) &&
                vertices.containsAll(otherGraph.getVertices()));
    }

    @Override
    public MyGraph clone() {
        List<MyVertex> newVertices = new ArrayList<MyVertex>();
        for (MyVertex v : vertices) {
            newVertices.add(v.clone());
        }
        return new MyGraph(newVertices);
    }
}
