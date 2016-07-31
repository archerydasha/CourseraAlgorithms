package model;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dasha on 7/29/2016.
 */
public class MyGraph {
    List<MyVertex> vertices;

    public MyGraph(){
        this(null);
    }

    public MyGraph(List<MyVertex> vertices) {
        if (vertices == null) {
            this.vertices = new ArrayList<MyVertex>();
        } else {
            this.vertices = vertices;
        }
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
        vertices.add(vertex);
    }

    @Override
    public boolean equals(Object o){
        if(o== null) return false;
        if(!(o instanceof MyGraph)) return false;
        MyGraph otherGraph = (MyGraph) o;
        return (otherGraph.getVertices().containsAll(vertices) &&
                vertices.containsAll(otherGraph.getVertices()));
    }
}
