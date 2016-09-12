package scheduling;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Created by Dasha on 9/11/2016.
 */
public class SchedulingAppTest {

    @Test
    public void testWeeklyAssignment1() throws IOException {
        testJobsFromFile("jobs.txt", SchedulingApp.getAppWithSubstractionAlgorithm(), 69119377652l);
    }

    @Test
    public void testWeeklyAssignment2() throws IOException {
        testJobsFromFile("jobs.txt", SchedulingApp.getAppWithDivisionAlgorithm(), 67311454237l);
    }



    private void testJobsFromFile(String fileName, SchedulingApp app, long expectedResult) throws IOException {
        String pathToFile = getClass().getResource(fileName).getPath();
        assertEquals(expectedResult, app.computeSumOfCompletionTimes(pathToFile));
    }

    @Test
    public void testSmallJobs1SubstractionAlgorithm() throws IOException {
        testJobsFromFile("small_jobs1.txt", SchedulingApp.getAppWithSubstractionAlgorithm(), 88);
    }

    @Test
    public void testSmallJobs1DivisionAlgorithm() throws IOException {
        testJobsFromFile("small_jobs1.txt", SchedulingApp.getAppWithDivisionAlgorithm(), 85);
    }

    @Test
    public void testJobsFromForum1SubstractionAlgorithm() throws IOException{
        testJobsFromFile("jobs_from_forum1.txt", SchedulingApp.getAppWithSubstractionAlgorithm(), 31814);
    }

    @Test
    public void testJobsFromForum1DivisionAlgorithm() throws IOException{
        testJobsFromFile("jobs_from_forum1.txt", SchedulingApp.getAppWithDivisionAlgorithm(), 31814);
    }

    @Test
    public void testJobsFromForum2SubstractionAlgorithm() throws IOException{
        testJobsFromFile("jobs_from_forum2.txt", SchedulingApp.getAppWithSubstractionAlgorithm(), 61545);
    }

    @Test
    public void testJobsFromForum2DivisionAlgorithm() throws IOException{
        testJobsFromFile("jobs_from_forum2.txt", SchedulingApp.getAppWithDivisionAlgorithm(), 60213);
    }

}
