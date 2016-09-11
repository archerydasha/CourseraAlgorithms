package simplesorts;

import java.util.List;

import static java.util.Collections.swap;

/**
 * Created by Dasha on 8/31/2016.
 */
public class BubbleSort implements SortingAlgorithm {
    @Override
    public void sort(List<Integer> input) {
        int size = input.size();
        for(int i = 0; i < size; i++){
            for(int j = i+1; j <size;j++){
                if(input.get(i) > input.get(j)){
                    swap(input, i ,j);
                }
            }
        }
    }
}
