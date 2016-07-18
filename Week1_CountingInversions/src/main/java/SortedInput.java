import java.util.List;

/**
 * Created by Dasha on 7/16/2016.
 */
public class SortedInput {
    private List<Integer> input;
    private long inversionCount;

    public SortedInput(List<Integer> input, long inversionCount) {
        this.input = input;
        this.inversionCount = inversionCount;
    }

    public List<Integer> getInput() {
        return input;
    }

    public long getInversionCount() {
        return inversionCount;
    }

}
