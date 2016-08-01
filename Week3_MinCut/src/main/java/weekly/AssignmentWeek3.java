package weekly;

import graphreading.GraphFileReader;
import graphreading.GraphTabSeparatedLineParser;
import model.MyGraph;
import service.MinCutAlgorithm;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by arche on 7/31/2016.
 */
public class AssignmentWeek3 {
    public static void main(String[] args) throws IOException {
        GraphFileReader graphFileReader = new GraphFileReader(new GraphTabSeparatedLineParser());
        InputStream input = AssignmentWeek3.class.getResourceAsStream("kargerMinCut.txt");
        MyGraph graph = graphFileReader.readGraphFromFile(input);
        int minCut = MinCutAlgorithm.findMinCut(graph);
        System.out.println(minCut);
    }
}
