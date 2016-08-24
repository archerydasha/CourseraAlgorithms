package median;

import com.google.common.base.Throwables;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Dasha on 8/18/2016.
 */
public class MedianMaintenance {
    public static long countNMedians(int numberOfMedians, String fileName) throws IOException {
        long result = 0;
        PriorityQueue<Long> lowerHeap = new PriorityQueue<>(new Comparator<Long>() {
            @Override
            public int compare(Long o1, Long o2) {
                return -o1.compareTo(o2);
            }
        }); //this will hopefully give a reverse order in the heap
        PriorityQueue<Long> higherHeap = new PriorityQueue<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)))) {
            String thisLine;
            int i = 0;
            while ((thisLine = reader.readLine()) != null && i < numberOfMedians) {
                long newValue = Long.valueOf(thisLine);
                long nextMedian = countNextMedian(newValue, lowerHeap, higherHeap);
                result += nextMedian;
                System.out.println(newValue + " Median is " + nextMedian);
                i++;
            }
        }
        return result;
    }

    private static long countNextMedian(long newValue, PriorityQueue<Long> lowerHeap, PriorityQueue<Long> higherHeap) {
        Long maximumOfLower = lowerHeap.peek();
        if(maximumOfLower == null || newValue <= maximumOfLower){
            lowerHeap.add(newValue);
            if((lowerHeap.size()-higherHeap.size())>1){
                higherHeap.add(lowerHeap.poll());
            }
        }else {
            higherHeap.add(newValue);
            if(higherHeap.size() > lowerHeap.size()){
                lowerHeap.add(higherHeap.poll());
            }
        }
        return lowerHeap.peek();
    }
    /*
        high level idea:
        heap 1 - with extract max (name this element El1)
        heap 2 - with extract mean (name this element El2)
        getting every next element:
        if(nextOne < El1)
            insert to heap 1
        else
            insert to heap 2
        heap size 1 = heap 1.size()
        heap size 2 = heap 2.size()
         if(heapSize1 == heapSize2){
            result = heap2.getMin();
            //don't forget to get that element back into heap
       }
        if((heapSize1 - heapSize2) > 1){
            heap 2. insert(heap 1.getMax());
            heapSize1 --;
            heapSize2 ++;
        }
        if((heapSize2 - heapSize1)>1){
            heap 1.insert(heap2.getMin());
            heapSize1++;
            heapSize2--;
        }
       if(heapSize1 > heapSize2){
            result = heap1.getMax();
            //put element back
       }else{
            result = heap2.getMin();
            //put element back
       }


       ideas for test cases:
       really, compute just some of N medians.
       so make array like [1,2,3,4,5,6,7,8,9, some more stochastic data]
       compute sum of 3 /4/15 medians
       assert to expected result
       maybe compute already modulo 10000, because it will not affect my small test case, but will help avoid overflow
       though... this way I will not notice overflow, so maybe no, just compute the sum itself!

       so, to do:
       [x]  how heaps are implemented in Java
            priority queue - extracts minimum. has peek and pop, by the way!
       [] write test cases
       [] write algorithm itself
       [] eat pasta
    */
}
