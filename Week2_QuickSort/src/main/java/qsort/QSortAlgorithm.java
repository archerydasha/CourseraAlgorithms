package qsort;

import java.util.List;

/**
 * Created by Dasha on 7/20/2016.
 */
public class QSortAlgorithm {

    public static QSortAlgorithm createAlgorithmWithFirstElementPivotStrategy(){
        return new QSortAlgorithm(new FirstElementPivotStrategy());
    }
    public static QSortAlgorithm createAlgorithmWithLastElementPivotStrategy(){
        return new QSortAlgorithm(new LastElementPivotStrategy());
    }
    public static QSortAlgorithm createAlgorithmWithMedianPivotStrategy(){
        return new QSortAlgorithm(new MedianPivotStrategy());
    }

    private PivotChoiceStrategy pivotChoiceStrategy;

    private QSortAlgorithm(PivotChoiceStrategy pivotChoiceStrategy) {
        this.pivotChoiceStrategy = pivotChoiceStrategy;
    }

    public long sort(List<Integer> input) {
        return performSort(input, 0, input.size() - 1);
    }

    private long performSort(List<Integer> input, int beginning, int end) {
        if (end <= beginning) {
            return 0;
        }
        long numberOfComparisons = end - beginning;

        int pivotIndex = pivotChoiceStrategy.getPivot(input, beginning, end);
        if (pivotIndex != beginning) {
            swap(input, beginning, pivotIndex);
        }
        Integer pivotElement = input.get(beginning);
        int i = beginning + 1;
        int j = beginning + 1;
        for (; j <= end; j++) {
            if (input.get(j) < pivotElement) {
                swap(input, j, i);
                i++;
            }
        }
        swap(input, beginning, i - 1);

        numberOfComparisons += performSort(input, beginning, i - 2);
        numberOfComparisons += performSort(input, i, end);
        return numberOfComparisons;
    }

    private void swap(List<Integer> input, int i, int j) {
        if (i != j) {
            Integer value1 = input.get(i);
            Integer value2 = input.get(j);
            input.set(i, value2);
            input.set(j, value1);
        }
    }
}
