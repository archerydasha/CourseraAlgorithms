package components;

import java.util.List;

/**
 * Created by Dasha on 8/7/2016.
 */
public abstract class TheVertex {

    protected Long initialNumber;
    protected Long finishingTime;
    boolean explored;

    public TheVertex(Long vertexNumber) {
        this.initialNumber = vertexNumber;
        explored = false;
    }

    public Long getInitialNumber() {
        return initialNumber;
    }

    public Long getFinishingTime() {
        return finishingTime;
    }

    public void setFinishingTime(Long finishingTime) {
        this.finishingTime = finishingTime;
    }

    public boolean isExplored() {
        return explored;
    }

    public void setExplored(boolean explored) {
        this.explored = explored;
    }


    public abstract List<TheEdge> getInEdges();

    public abstract List<TheEdge> getOutEdges();


}
