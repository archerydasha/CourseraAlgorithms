package shortestpaths;

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
        Splitter lineSplitter = Splitter.on(" ");
        Splitter edgeDataSplitted  = Splitter.on(",");
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        List<MyVertex> vertices = new ArrayList<>();
        String line;
        while ((line = reader.readLine()) != null){
            List<String> values = lineSplitter.splitToList(line);
            int vertexNumber = Integer.valueOf(values.get(0));
            List<MyEdge> edges = new ArrayList<>();
            for(int i = 1; i < values.size(); i++){
                List<String> edgeData = edgeDataSplitted.splitToList(values.get(i));
                int head = Integer.valueOf(edgeData.get(0));
                long lenth = Long.valueOf(edgeData.get(1));
                MyEdge edge = new MyEdge(head, lenth);
                edges.add(edge);
            }
            MyVertex vertex = new MyVertex(vertexNumber, edges);
            vertices.add(vertex);
        }
        return new MyGraph(vertices);
    }
}
