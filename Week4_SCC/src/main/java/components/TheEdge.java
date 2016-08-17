package components;

/**
 * Created by Dasha on 8/7/2016.
 */
public abstract class TheEdge {

    protected MyVertex tail;
    protected MyVertex head;

    public TheEdge(MyVertex tail, MyVertex head) {
        this.tail = tail;
        this.head = head;
    }

    public MyVertex getTail() {
        return tail;
    }

    public MyVertex getHead() {
        return head;
    }


}
