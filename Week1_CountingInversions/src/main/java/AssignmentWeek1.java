import utils.FileReadingUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dasha on 7/16/2016.
 */
public class AssignmentWeek1 {
    public static void main(String args[]) {

        List<Integer> inputArray = null;
        try {
            inputArray = FileReadingUtils.readArrayFromInputStream(AssignmentWeek1.class.getResourceAsStream("IntegerArray.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(inputArray.size());

        System.out.println(InversionCounter.countInversions(inputArray).getInversionCount());
    }
}
