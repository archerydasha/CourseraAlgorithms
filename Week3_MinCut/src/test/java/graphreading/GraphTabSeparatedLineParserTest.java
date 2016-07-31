package graphreading;

import com.google.common.collect.Sets;
import model.MyVertex;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Dasha on 7/31/2016.
 */
public class GraphTabSeparatedLineParserTest {

    @Test
    public void testVertexCreation(){
        String input = "2   1   3   4";
        MyVertex expectedResult = new MyVertex(2, Sets.newHashSet(1,3,4));
        assertEquals(expectedResult, new GraphTabSeparatedLineParser().parseLine(input));
    }
}
