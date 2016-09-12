package scheduling;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static org.junit.Assert.*;

/**
 * Created by Dasha on 9/11/2016.
 */
public class JobsComparatorTest {

    private void testJobsFromFile(String fileName, SchedulingApp app, List<JobWithScore>  expectedResult) throws IOException {
        String pathToFile = getClass().getResource(fileName).getPath();
        List<JobWithScore> jobs = app.readJobsFromFile(pathToFile);
        Collections.sort(jobs, new SchedulingApp.JobsComparator());
        for(int i = 0; i < jobs.size(); i++){
            assertEquals(expectedResult.get(i), jobs.get(i));
        }
    }


    @Test
    public void testComparatorSmallJobs1Substraction() throws IOException {
        SchedulingApp app = SchedulingApp.getAppWithSubstractionAlgorithm();
        List<JobWithScore> expectedResult = new ArrayList<>();
        expectedResult.add(new JobWithScore(5,4,1d));
        expectedResult.add(new JobWithScore(2,1,1d));
        expectedResult.add(new JobWithScore(4,6,-2d));
        expectedResult.add(new JobWithScore(1,3,-2d));
        testJobsFromFile("small_jobs1.txt", app, expectedResult);
    }

    @Test
    public void testComparatorSmallJobs1Division() throws IOException {
        SchedulingApp app = SchedulingApp.getAppWithDivisionAlgorithm();
        List<JobWithScore> expectedResult = new ArrayList<>();
        expectedResult.add(new JobWithScore(2,1,2d));
        expectedResult.add(new JobWithScore(5,4,(double)5/(double)4));
        expectedResult.add(new JobWithScore(4,6,(double)4/(double)6));
        expectedResult.add(new JobWithScore(1,3,(double)1/(double)3));
        testJobsFromFile("small_jobs1.txt", app, expectedResult);
    }

}
