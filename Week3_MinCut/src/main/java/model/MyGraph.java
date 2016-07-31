package model;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

import java.util.List;

/**
 * Created by Dasha on 7/29/2016.
 */
public class MyGraph {
    List<MyVertex> vertices;


    public MyVertex getVertexByNumber(final Integer vertexNumber) {
        return Iterables.find(vertices, new Predicate<MyVertex>() {
            public boolean apply(MyVertex vertex) {
                return vertex.getNumber().equals(vertexNumber);
            }
        });
    }


    public void addVertex(MyVertex vertex) {
        if (getVertexByNumber(vertex.getNumber()) != null) {
            throw new GraphCreationException("Trying to add vertex " + vertex.getNumber() + " to the graph that already has this vertex!");
        }
        vertices.add(vertex);
    }
}
