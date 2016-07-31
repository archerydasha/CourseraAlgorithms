package graphreading;

import model.MyGraph;
import model.MyVertex;

/**
 * Created by Dasha on 7/31/2016.
 */
public interface GraphLineParser {
    MyVertex parseLine(String thisLine);
}
