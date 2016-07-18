import com.google.common.io.Resources;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dasha on 7/16/2016.
 */
public class WeeklyAssignmentMainClass {
    public static void main(String args[]) {

        List<Integer> inputArray = new ArrayList<Integer>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(WeeklyAssignmentMainClass.class.getResourceAsStream("IntegerArray.txt")));

        String thisLine;
        try {
            while ((thisLine = reader.readLine()) != null) {
                Integer value = Integer.valueOf(thisLine);
                inputArray.add(value);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(inputArray.size());

        System.out.println(InversionCounter.countInversions(inputArray).getInversionCount());
    }
}
