package model;

import java.util.Set;

/**
 * Created by Dasha on 7/31/2016.
 */
public class MyVertex {
    Integer number;
    Set<Integer> incidentVertices;

    public MyVertex(Integer vertextNumber, Set<Integer> incidentVertices) {
        this.number = vertextNumber;
        this.incidentVertices = incidentVertices;
    }

    public Integer getNumber() {
        return number;
    }

    public Set<Integer> getIncidentVertices() {
        return incidentVertices;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (!(o instanceof MyVertex)) return false;
        MyVertex otherVertex = (MyVertex) o;
        if (number.equals(otherVertex.getNumber()) &&
                incidentVertices.containsAll(otherVertex.getIncidentVertices()) &&
                otherVertex.getIncidentVertices().containsAll(incidentVertices)) {
            return true;
        }
        return false;
    }
}
