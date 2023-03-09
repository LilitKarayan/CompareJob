package edu.gatech.seclass.jobcompare6300;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import edu.gatech.seclass.jobcompare6300.Job;

import static org.junit.Assert.assertEquals;
public class ComparisonUnitTest {

    private Comparison comparison;
    ArrayList<Job> jobs = new ArrayList<Job>();
    Job job1 = new Job("title1","Company1","City1","State1", 2000,100000.0,10000.0,2.0,1000.0,10,false);
    Job job2 = new Job("title2","Company2","City2","State2", 1000,200000.0,10000.0,2.0,1000.0,10,false);


    @Before
    public void setUp() {
        comparison = new Comparison();
        jobs.add(job1);
        jobs.add(job2);
    }

    @Test
    public void testComputeJobScore() {
        double score = comparison.computeJobScore(job1);
        double expectedScore = 26205.18;
        assertEquals(expectedScore, score, 0.1);
    }

    @Test
    public void testRankJobs() {
        ArrayList<Job> result = comparison.rankJobs(jobs);
        Job firstJob = result.get(0);
        Job secondJob = result.get(1);
        assertEquals("title2", firstJob.getTitle());
        assertEquals("Company2", firstJob.getCompany());
        assertEquals("title1", secondJob.getTitle());
        assertEquals("Company1", secondJob.getCompany());
    }

    @Test
    public void testSetWeights() {
        comparison.setWeights(2, 3, 1, 2, 1);
        double expectedWeight = 9.0;
        assertEquals(expectedWeight, comparison.total_weight, 0.1);
    }

    @Test
    public void testRankJobsEmpty() {
        Comparison comparison = new Comparison();
        ArrayList<Job> emptyJobList = new ArrayList<>();
        ArrayList<Job> sortedJobs = comparison.rankJobs(emptyJobList);
        assertEquals(emptyJobList, sortedJobs);
    }

    @Test
    public void testSaveAndRead(){
        Comparison comparison = new Comparison();
        comparison.setWeights(2, 3, 1, 2, 1);
        comparison.saveWeights();

        Comparison comparison2 = new Comparison(); //this new comparison created should read what saved
        assertEquals(comparison2.total_weight, 9,0.1);

    }

}
