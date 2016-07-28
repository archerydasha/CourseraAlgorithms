package qsort;

import utils.FileReadingUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Dasha on 7/21/2016.
 */
public class AssignmentWeek2 {
    public static void main(String[] args) {

        List<Integer> inputArray1 = null;
        try {
            inputArray1 = FileReadingUtils.readArrayFromInputStream(AssignmentWeek2.class.getResourceAsStream("QuickSort.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(inputArray1.size());

        List<Integer> inputArray2 = new ArrayList<Integer>();
        List<Integer> inputArray3 = new ArrayList<Integer>();
        inputArray2.addAll(inputArray1);
        inputArray3.addAll(inputArray1);

        System.out.println("Number with first element as a pivot: " +
                QSortAlgorithm.createAlgorithmWithFirstElementPivotStrategy().sort(inputArray1));
        System.out.println("Number with last element as a pivot: " +
                QSortAlgorithm.createAlgorithmWithLastElementPivotStrategy().sort(inputArray2));
        System.out.println("Number with median as a pivot: " +
                QSortAlgorithm.createAlgorithmWithMedianPivotStrategy().sort(inputArray3));

    }
}
