package components;

import java.util.Collections;

/**
 * Created by Dasha on 8/6/2016.
 */
public class StronglyConnectedComponent implements Comparable<StronglyConnectedComponent>{
    long source;
    long size;

    public StronglyConnectedComponent(long source) {
        this.source = source;
        this.size = 0l;
    }

    public long getSource() {
        return source;
    }

    public long getSize() {
        return size;
    }

    public void setSize(Long size){
        this.size = size;
    }

    public int compareTo(StronglyConnectedComponent o) {
        long difference = o.getSize() - size;
        if ( difference == 0l) return 0;
        return difference > 0 ? 1 : -1;
    }
}
