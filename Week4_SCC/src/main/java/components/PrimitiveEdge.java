package components;

/**
 * Created by Dasha on 8/7/2016.
 */
public class PrimitiveEdge {
    long tail;
    long head;

    public PrimitiveEdge(long tail, long head) {
        this.tail = tail;
        this.head = head;
    }

    public long getTail() {
        return tail;
    }

    public long getHead() {
        return head;
    }
}
