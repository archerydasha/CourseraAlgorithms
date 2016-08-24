package components;

import com.google.common.base.Splitter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by Dasha on 8/6/2016.
 */
public class MyGraph implements TheGraph {
    private static final Splitter splitter = Splitter.on(' ');
    List<MyVertex> vertices;


    //ToDo - moved this for the sake of easiness, but can we do better? (from architecture point of view)
    public MyGraph(InputStream inputStream) throws IOException {
        this();
        Map<Long, MyVertex> vertexMap = new HashMap<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String thisLine;
        while ((thisLine = reader.readLine()) != null) {
            List<String> elements = splitter.splitToList(thisLine);
            Integer tailVertexNumber = Integer.valueOf(elements.get(0));
            Integer headVertexNumber = Integer.valueOf(elements.get(1));
            PrimitiveEdge newEdge = new PrimitiveEdge(tailVertexNumber, headVertexNumber);
            addEdge(newEdge, vertexMap);
        }
        vertices = new ArrayList<>(vertexMap.values());
    }

    protected MyGraph() {
        vertices = new ArrayList<MyVertex>();
    }

    public MyGraph(ArrayList<MyVertex> vertices) {
        this.vertices = vertices;
    }

    private void addEdge(PrimitiveEdge edge, Map<Long, MyVertex> vertexMap) {
        MyVertex tailVertex = getOrCreateVertex(edge.getTail(), vertexMap);
        MyVertex headVertex = getOrCreateVertex(edge.getHead(), vertexMap);
        MyEdge forwardEdge = new MyEdge(tailVertex, headVertex);
        tailVertex.addOutEdge(forwardEdge);
        headVertex.addInEdge(forwardEdge);
    }


    private MyVertex getOrCreateVertex(final Long vertexNumber, Map<Long, MyVertex> vertexMap) {
        MyVertex result = vertexMap.get(vertexNumber);
        if (result == null) {
            result = new MyVertex(vertexNumber);
            vertexMap.put(vertexNumber, result);
        }
        return result;
    }

    public List<TheVertex> getVertices(){
        return new ArrayList<TheVertex>(vertices);
    }

    @Override
    public boolean equals(Object o){
        if (o== null) return false;
        if (! (o instanceof  MyGraph)) return false;
        MyGraph otherGraph = (MyGraph) o;
        if ((vertices == null) && otherGraph.getVertices() == null) return true;
        return (vertices.containsAll(otherGraph.getVertices()) && otherGraph.getVertices().containsAll(vertices));
    }

}
