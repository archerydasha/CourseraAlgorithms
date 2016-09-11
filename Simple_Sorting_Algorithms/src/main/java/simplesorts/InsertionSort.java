package simplesorts;

import java.util.List;

/**
 * Created by Dasha on 8/31/2016.
 */
public class InsertionSort implements SortingAlgorithm {
    @Override
    public void sort(List<Integer> input) {
        for(int i = 1; i< input.size();i++){
            int element = input.get(i);
            int j = i;
            while(j>0 && input.get(j-1) > element){
                input.set(j, input.get(j-1));
                j--;
            }
            input.set(j,element);
        }
    }
}
