package graphreading;

import com.google.common.collect.Sets;
import model.MyVertex;
import org.junit.Test;

import java.util.HashSet;

import static org.junit.Assert.*;

/**
 * Created by Dasha on 7/31/2016.
 */
public class GraphTabSeparatedLineParserTest {

    @Test
    public void testVertexCreation1(){
        String input = "2\t1\t3\t4";
        MyVertex expectedResult = new MyVertex(2, Sets.newHashSet(1,3,4));
        assertEquals(expectedResult, new GraphTabSeparatedLineParser().parseLine(input));
    }

    @Test
    public void testVertexCreation2(){
        String input = "5";
        MyVertex expectedResult = new MyVertex(5, new HashSet<Integer>());
        assertEquals(expectedResult, new GraphTabSeparatedLineParser().parseLine(input));
    }

    @Test
    public void testVertexCreation3(){
        String input = "5";
        MyVertex expectedResult = new MyVertex(5, null);
        assertEquals(expectedResult, new GraphTabSeparatedLineParser().parseLine(input));
    }
}
