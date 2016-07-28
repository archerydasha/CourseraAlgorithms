package qsort;

import java.util.List;

/**
 * Created by Dasha on 7/21/2016.
 */
public class FirstElementPivotStrategy implements PivotChoiceStrategy {
    public int getPivot(List<Integer> input, int beginning, int end) {
        return beginning;
    }
}
