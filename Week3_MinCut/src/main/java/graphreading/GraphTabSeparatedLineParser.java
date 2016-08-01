package graphreading;

import com.google.common.base.Function;
import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import model.MyGraph;
import model.MyVertex;

import java.util.List;
import java.util.Set;

/**
 * Created by Dasha on 7/31/2016.
 */
public class GraphTabSeparatedLineParser implements GraphLineParser {
    private static final Splitter splitter = Splitter.on('\t').omitEmptyStrings();

    public MyVertex parseLine(String thisLine) {
        List<String> elements = splitter.splitToList(thisLine);
        Integer vertexNumber = Integer.valueOf(elements.get(0));
        List<Integer> incidentVertices = Lists.newArrayList(Iterables.transform(elements.subList(1, elements.size()), new Function<String, Integer>() {
            public Integer apply(String s) {
                return Integer.valueOf(s);
            }
        }));
        MyVertex vertex = new MyVertex(vertexNumber, incidentVertices);
        return vertex;
    }
}
