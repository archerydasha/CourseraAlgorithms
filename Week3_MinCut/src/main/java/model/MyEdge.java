package model;

/**
 * Created by arche on 7/31/2016.
 */
public class MyEdge {
    Integer tail;
    Integer head;

    public MyEdge(Integer tail, Integer head) {
        this.tail = tail;
        this.head = head;
    }

    public Integer getTail() {
        return tail;
    }

    public Integer getHead() {
        return head;
    }
}
