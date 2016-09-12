package scheduling;

import java.util.Objects;

/**
 * Created by Dasha on 9/11/2016.
 */
public class JobWithScore {
    Integer weight;
    Integer length;
    Double score;

    public JobWithScore(Integer weight, Integer length, Double score) {
        this.weight = weight;
        this.length = length;
        this.score = score;
    }

    public Integer getWeight() {
        return weight;
    }

    public Integer getLength() {
        return length;
    }

    public Double getScore() {
        return score;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (!(o instanceof JobWithScore)) return false;
        JobWithScore otherJob = (JobWithScore)o;
        return (Objects.equals(weight, otherJob.getWeight()) &&
                Objects.equals(length, otherJob.getLength()) &&
                Objects.equals(score, otherJob.getScore()));
    }
}
