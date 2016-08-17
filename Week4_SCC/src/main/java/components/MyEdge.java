package components;

/**
 * Created by Dasha on 8/6/2016.
 */
public class MyEdge extends TheEdge {


    public MyEdge(MyVertex tail, MyVertex head) {
        super(tail, head);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (!(o instanceof MyEdge)) return false;
        MyEdge otherEdge = (MyEdge)o;
        return (tail.getInitialNumber().equals(otherEdge.getTail().getInitialNumber()) &&
                head.getInitialNumber().equals(otherEdge.getHead().getInitialNumber()));
    }
}
