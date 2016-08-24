package twosum;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Dasha on 8/17/2016.
 */
public class TwoSumCounter {

    public static long countNumberOfPossibleTwoSumsOptimized(long leftEdge, long rightEdge, String fileName) {
        HashSet<Long> targets = new HashSet<Long>((int) (rightEdge - leftEdge + 1));
        for (Long l = leftEdge; l <= rightEdge; l++) {
            targets.add(l);
        }
        int originalSize = targets.size();
        HashSet<Long> values = new HashSet<Long>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)))) {
            String thisLine;
            while ((thisLine = reader.readLine()) != null) {
                Long value = Long.valueOf(thisLine);
                Set<Long> hitTargets = new HashSet<>();
                for (Long t : targets) {
                    Long targetValue = t - value;
                    if (!targetValue.equals(value) && values.contains(targetValue)) {
                        hitTargets.add(t);
                    }
                }
                for (Long hitTarget : hitTargets) {
                    targets.remove(hitTarget);
                }
                values.add(value);
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        return originalSize - targets.size();
    }

    public static long countNumberOfPossibleTwoSums(long leftEdge, long rightEdge, String fileName) {
        long result = 0;
        for (long t = leftEdge; t <= rightEdge; t++) {
            if (hasSuchCombination(t, fileName)) {
                result++;
            }
        }
        return result;
    }

    public static boolean hasSuchCombination(long t, String fileName) {
        HashSet<Long> values = new HashSet<Long>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)))) {
            String thisLine;
            while ((thisLine = reader.readLine()) != null) {
                Long value = Long.valueOf(thisLine);
                Long targetValue = t - value;
                if (!targetValue.equals(value) && values.contains(targetValue)) {
                    return true;
                }
                values.add(value);
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
