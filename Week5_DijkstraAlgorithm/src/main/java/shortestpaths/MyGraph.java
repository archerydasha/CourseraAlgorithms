package shortestpaths;

import com.google.common.base.CharMatcher;
import com.google.common.base.Splitter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dasha on 8/24/2016.
 */
public class MyGraph {

    private List<MyVertex> vertices = new ArrayList<>();

    public List<MyVertex> getVertices() {
        return vertices;
    }

    public MyGraph(List<MyVertex> vertices) {
        this.vertices = vertices;
    }

    public static MyGraph readGraphFromFile(String fileName) throws IOException {
        Splitter lineSplitter = Splitter.on(CharMatcher.WHITESPACE.or(CharMatcher.is('\t'))).omitEmptyStrings();
        Splitter edgeDataSplitted = Splitter.on(",").omitEmptyStrings();
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        List<MyVertex> vertices = new ArrayList<>();
        String line;
        while ((line = reader.readLine()) != null) {
            List<String> values = lineSplitter.splitToList(line);
            int vertexNumber = Integer.valueOf(values.get(0));
            List<MyEdge> edges = new ArrayList<>();
            for (int i = 1; i < values.size(); i++) {
                List<String> edgeData = edgeDataSplitted.splitToList(values.get(i));
                try {
                    int head = Integer.valueOf(edgeData.get(0));
                    long lenth = Long.valueOf(edgeData.get(1));
                    MyEdge edge = new MyEdge(head, lenth);
                    edges.add(edge);
                } catch (NumberFormatException ex) {
                    continue;
                }
            }
            MyVertex vertex = new MyVertex(vertexNumber, edges);
            vertices.add(vertex);
        }
        return new MyGraph(vertices);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (!(o instanceof MyGraph)) return false;
        MyGraph otherGraph = (MyGraph) o;
        if (vertices == null && otherGraph.getVertices() == null) return true;
        if (vertices != null && otherGraph.getVertices() != null &&
                vertices.containsAll(otherGraph.getVertices()) && otherGraph.getVertices().containsAll(vertices))
            return true;
        return false;
    }
}
