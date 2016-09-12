package mst;

import com.google.common.base.Splitter;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Dasha on 9/11/2016.
 */
public class SimpleGraphReader {
    private static Splitter splitter = Splitter.on(' ').omitEmptyStrings();

    private SimpleGraphReader() {
    }

    public static SimpleGraph readGraphFromFile(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        Set<Long> vertices = new HashSet<>();
        List<SimpleEdge> edges = new ArrayList<>();
        String numberOfNodesAndEdges = reader.readLine(); //really, I don't need it
        String line;
        while ((line = reader.readLine()) != null) {
            List<String> values = splitter.splitToList(line);
            Long vertex1 = Long.valueOf(values.get(0));
            Long vertex2 = Long.valueOf(values.get(1));
            Long cost = Long.valueOf(values.get(2));
            vertices.add(vertex1);
            vertices.add(vertex2);
            edges.add(new SimpleEdge(vertex1, vertex2, cost));
        }
        return new SimpleGraph(new ArrayList<>(vertices), edges);
    }
}
