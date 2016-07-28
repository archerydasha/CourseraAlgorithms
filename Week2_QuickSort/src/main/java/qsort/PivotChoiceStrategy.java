package qsort;

import java.util.List;

/**
 * Created by Dasha on 7/21/2016.
 */
public interface PivotChoiceStrategy {
    int getPivot(List<Integer> input, int beginning, int end);
}
