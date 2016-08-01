package testdata;

import com.google.common.collect.Lists;
import model.MyGraph;
import model.MyVertex;

/**
 * Created by arche on 8/1/2016.
 */
public class TestGraphs {
    private TestGraphs(){};

    public static MyGraph createSimpleGraph1() {
        MyVertex vertex1 = new MyVertex(1, Lists.newArrayList(2));
        MyVertex vertex2 = new MyVertex(2, Lists.newArrayList(1));
        return new MyGraph(Lists.newArrayList(vertex1, vertex2));
    }

    public static MyGraph createSimpleGraph2() {
        MyVertex vertex1 = new MyVertex(1, Lists.newArrayList(2));
        MyVertex vertex2 = new MyVertex(2, Lists.newArrayList(1,3,4));
        MyVertex vertex3 = new MyVertex(3, Lists.newArrayList(4,2));
        MyVertex vertex4 = new MyVertex(4, Lists.newArrayList(3,2));
        return new MyGraph(Lists.newArrayList(vertex1, vertex2, vertex3, vertex4));
    }


    public static MyGraph createSimpleGraph3() {
        MyVertex vertex1 = new MyVertex(1, Lists.newArrayList(2,3));
        MyVertex vertex2 = new MyVertex(2, Lists.newArrayList(1,3));
        MyVertex vertex3 = new MyVertex(3, Lists.newArrayList(1,2));
        MyGraph graph = new MyGraph(Lists.newArrayList(vertex1, vertex2, vertex3));
        return graph;
    }

    public static MyGraph createSimpleGraph4(){
        MyVertex vertex1 = new MyVertex(1, Lists.newArrayList(2,3));
        MyVertex vertex2 = new MyVertex(2, Lists.newArrayList(1,4,5));
        MyVertex vertex3 = new MyVertex(3, Lists.newArrayList(1,4));
        MyVertex vertex4 = new MyVertex(4, Lists.newArrayList(7,2,3));
        MyVertex vertex5 = new MyVertex(5, Lists.newArrayList(7,2,6));
        MyVertex vertex6 = new MyVertex(6, Lists.newArrayList(5,8));
        MyVertex vertex7 = new MyVertex(7, Lists.newArrayList(5,8,4));
        MyVertex vertex8 = new MyVertex(8, Lists.newArrayList(6,7));
        MyGraph graph = new MyGraph(Lists.newArrayList(vertex1, vertex2, vertex3, vertex4, vertex5, vertex6, vertex7, vertex8));
        return graph;
    }
}
