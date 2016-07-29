package graphreading;

import model.MyGraph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Dasha on 7/29/2016.
 */
public class GraphFileReader {
    private GraphFileReader() {
    }


    public static MyGraph readGraphFromFile(InputStream inputStream) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        MyGraph result = new MyGraph();
        String thisLine;
        while ((thisLine = reader.readLine()) != null) {
            parseLine(result, thisLine);
        }
        return result;
    }

    private static void parseLine(MyGraph result, String thisLine) {
        //ToDo - for implementation
    }

}
