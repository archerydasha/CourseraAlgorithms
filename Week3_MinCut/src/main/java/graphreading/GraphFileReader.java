package graphreading;

import com.google.common.base.Function;
import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;
import model.MyGraph;
import model.MyVertex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Set;

/**
 * Created by Dasha on 7/29/2016.
 */
public class GraphFileReader {

    private GraphLineParser parser;

    public GraphFileReader(GraphLineParser parser) {
        this.parser = parser;
    }

    public MyGraph readGraphFromFile(InputStream inputStream) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        MyGraph result = new MyGraph();
        String thisLine;
        while ((thisLine = reader.readLine()) != null) {
            MyVertex vertex = parser.parseLine(thisLine);
            result.addVertex(vertex);
        }
        return result;
    }
}
