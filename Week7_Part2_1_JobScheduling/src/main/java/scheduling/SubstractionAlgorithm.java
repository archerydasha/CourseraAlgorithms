package scheduling;

/**
 * Created by Dasha on 9/11/2016.
 */
public class SubstractionAlgorithm implements GreedyAlgorithm {
    @Override
    public double computeScore(int weight, int length) {
        return weight - length;
    }
}
