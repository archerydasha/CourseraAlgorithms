package simplesorts;

import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by Dasha on 8/31/2016.
 */
public class HeapSort implements SortingAlgorithm {
    @Override
    public void sort(List<Integer> input) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(input);
        for(int i = 0; i < input.size(); i++){
            input.set(i, heap.poll());
        }
    }
}
