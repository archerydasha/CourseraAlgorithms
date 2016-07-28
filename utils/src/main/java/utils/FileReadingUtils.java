package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dasha on 7/21/2016.
 */
public class FileReadingUtils {
    private FileReadingUtils() {
    }

    public static List<Integer> readArrayFromInputStream(InputStream inputStream) throws IOException {
        List<Integer> inputArray = new ArrayList<Integer>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        String thisLine;

        while ((thisLine = reader.readLine()) != null) {
            Integer value = Integer.valueOf(thisLine);
            inputArray.add(value);
        }

        return inputArray;
    }
}
