package scheduling;

import com.google.common.base.Splitter;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by Dasha on 9/11/2016.
 */
public class SchedulingApp {
    public static SchedulingApp getAppWithSubstractionAlgorithm() {
        return new SchedulingApp(new SubstractionAlgorithm());
    }

    public static SchedulingApp getAppWithDivisionAlgorithm() {
        return new SchedulingApp(new DivisionAlgorithm());
    }


    Splitter lineSplitter = Splitter.on(' ').omitEmptyStrings();
    private GreedyAlgorithm algorithm;

    public SchedulingApp(GreedyAlgorithm algorithm) {
        this.algorithm = algorithm;
    }

    public long computeSumOfCompletionTimes(String fileName) throws IOException {
        List<JobWithScore> input = readJobsFromFile(fileName);
        PriorityQueue<JobWithScore> jobs = new PriorityQueue<>(new JobsComparator());
        jobs.addAll(input);
        long result = 0l;
        long completionTime = 0l;
        JobWithScore job;
        while ((job = jobs.poll()) != null) {
            completionTime += job.getLength();
            long currentCost = completionTime * job.getWeight();
            result += currentCost;
        }
        return result;
    }

    public static class JobsComparator implements Comparator<JobWithScore> {
        @Override
        public int compare(JobWithScore o1, JobWithScore o2) {
            if (o2.getScore().equals(o1.getScore())) return o2.getWeight().compareTo(o1.getWeight());
            return o2.getScore().compareTo(o1.getScore());
        }
    }

    public List<JobWithScore> readJobsFromFile(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        List<JobWithScore> jobs = new ArrayList<>();
        int numberOfJobs = Integer.valueOf(reader.readLine());
        String line;
        while ((line = reader.readLine()) != null) {
            List<String> elements = lineSplitter.splitToList(line);
            int jobWeight = Integer.valueOf(elements.get(0));
            int jobLength = Integer.valueOf(elements.get(1));
            JobWithScore newJob = createJob(jobWeight, jobLength);            ;
            jobs.add(newJob);
        }
        return jobs;
    }

    private JobWithScore createJob(int jobWeight, int jobLength) {
        double score = algorithm.computeScore(jobWeight, jobLength);
        return new JobWithScore(jobWeight, jobLength, score);
    }
}
