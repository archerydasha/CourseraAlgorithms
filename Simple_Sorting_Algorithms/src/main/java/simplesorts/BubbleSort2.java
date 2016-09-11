package simplesorts;

import java.util.List;

import static java.util.Collections.swap;

/**
 * Created by Dasha on 8/31/2016.
 */
public class BubbleSort2 implements SortingAlgorithm {
    @Override
    public void sort(List<Integer> input) {
        boolean swapped = false;
        int finish_index = input.size()-1;
        do{
            swapped = false;
            for(int i = 0; i < finish_index; i++){
                if(input.get(i) > input.get(i+1)){
                    swap(input, i , i+1);
                    swapped = true;
                }
            }
            finish_index--;
        }while (swapped);
    }
}
