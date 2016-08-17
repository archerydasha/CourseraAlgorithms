package components;

import com.google.common.base.Splitter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dasha on 8/7/2016.
 */
public class EdgeReader {
    //ToDo - since this is never used, consider removing
    private EdgeReader(){}
    private static final Splitter splitter = Splitter.on('\t');

    public static List<PrimitiveEdge> readFromInputStream(InputStream inputStream) throws IOException {
        List<PrimitiveEdge> result = new ArrayList<PrimitiveEdge>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String thisLine;
        while ((thisLine = reader.readLine()) != null) {
            List<String> elements = splitter.splitToList(thisLine);
            Integer tailVertexNumber = Integer.valueOf(elements.get(0));
            Integer headVertexNumber = Integer.valueOf(elements.get(1));
            PrimitiveEdge newEdge = new PrimitiveEdge(tailVertexNumber, headVertexNumber);
            result.add(newEdge);
        }
        return result;
    }
}
