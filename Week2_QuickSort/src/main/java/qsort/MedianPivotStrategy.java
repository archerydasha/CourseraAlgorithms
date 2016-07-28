package qsort;

import java.util.List;

/**
 * Created by Dasha on 7/21/2016.
 */
public class MedianPivotStrategy implements PivotChoiceStrategy {
    public int getPivot(List<Integer> input, int beginning, int end) {
        int middleIndex = (end + beginning) / 2;
        int firstElement = input.get(beginning);
        int middleElement = input.get(middleIndex);
        int lastElement = input.get(end);
        if (firstElement < middleElement) {
            if (firstElement > lastElement)
                return beginning;
            else {
                if (middleElement < lastElement) {
                    return middleIndex;
                } else {
                    return end;
                }
            }
        } else {
            if (firstElement < lastElement)
                return beginning;
            else {
                if (middleElement > lastElement) {
                    return middleIndex;
                } else {
                    return end;
                }
            }
        }
    }
}
