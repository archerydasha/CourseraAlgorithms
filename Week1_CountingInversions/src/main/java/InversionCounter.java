import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dasha on 7/16/2016.
 */
public class InversionCounter {
    public static SortedInput countInversions(List<Integer> input) {
        //base case scenario
        if (input == null || input.size() == 0 || input.size() == 1) {
            return new SortedInput(input, 0);
        }
        int middle = input.size() / 2;
        SortedInput left = countInversions(input.subList(0, middle));
        SortedInput right = countInversions(input.subList(middle, input.size()));
        SortedInput merged = merge(left, right);
        return merged;
    }

    private static SortedInput merge(SortedInput left, SortedInput right) {
        List<Integer> result = new ArrayList<Integer>();
        long inversionCount = 0;
        int i = 0, j = 0;
        int leftSize = left.getInput().size();
        int rightSize = right.getInput().size();
        while (i < leftSize && j < rightSize) {
            Integer leftValue = left.getInput().get(i);
            Integer rigthValue = right.getInput().get(j);
            if (leftValue < rigthValue) {
                result.add(leftValue);
                i++;
            } else {
                result.add(rigthValue);
                j++;
                inversionCount += leftSize - i;
            }
        }

        for (; i < leftSize; i++) {
            result.add(left.getInput().get(i));
        }
        for (; j < rightSize; j++) {
            result.add(right.getInput().get(j));
        }

        inversionCount += left.getInversionCount();
        inversionCount += right.getInversionCount();
        return new SortedInput(result, inversionCount);
    }
}
