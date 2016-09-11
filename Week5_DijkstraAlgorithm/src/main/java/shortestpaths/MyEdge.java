package shortestpaths;

import java.util.List;

/**
 * Created by Dasha on 8/24/2016.
 */
public class MyEdge {
    private int head;
    private long length;

    public int getHead() {
        return head;
    }

    public long getLength() {
        return length;
    }


    public MyEdge(int head, long length) {
        this.head = head;
        this.length = length;
    }

    @Override
    public boolean equals(Object o){
        if (o == null) return false;
        if ( ! (o instanceof  MyEdge)) return false;
        MyEdge otherEdge = (MyEdge) o;
        return head == otherEdge.getHead() && length == otherEdge.getLength();
    }
}
