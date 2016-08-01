package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Dasha on 7/31/2016.
 */
public class MyVertex {
    Integer number;
    List<Integer> incidentVertices;

    public MyVertex(Integer vertextNumber, List<Integer> incidentVertices) {
        this.number = vertextNumber;
        if (incidentVertices == null)
            this.incidentVertices = new ArrayList<Integer>();
        else
            this.incidentVertices = incidentVertices;
    }

    public Integer getNumber() {
        return number;
    }

    public List<Integer> getIncidentVertices() {
        return incidentVertices;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (!(o instanceof MyVertex)) return false;
        MyVertex otherVertex = (MyVertex) o;
        return (number.equals(otherVertex.getNumber()) &&
                incidentVertices.containsAll(otherVertex.getIncidentVertices()) &&
                otherVertex.getIncidentVertices().containsAll(incidentVertices));
    }

    public MyVertex copy() {
        List<Integer> newIncidentVertices = new ArrayList<Integer>(incidentVertices);
        return new MyVertex(number.intValue(), newIncidentVertices);
    }
}
