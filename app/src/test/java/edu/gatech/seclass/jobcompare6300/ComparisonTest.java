package edu.gatech.seclass.jobcompare6300;


import org.junit.Test;

import static org.junit.Assert.*;


import java.util.ArrayList;

import edu.gatech.seclass.jobcompare6300.Comparison;
import edu.gatech.seclass.jobcompare6300.Job;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ComparisonTest {

//    private Comparison myComparision;

    @Test
    public void addition_isCorrect() {
        Comparison myComparision = new Comparison();
        ArrayList<Job> jobs = new ArrayList<Job>();
        Job job1 = new Job("title1","Company1","City1","State1", 2000,100000.0,10000.0,2.0,1000.0,10,false);
        jobs.add(job1);
        Job job2 = new Job("title2","Company2","City2","State2", 1000,200000.0,10000.0,2.0,1000.0,10,false);
        jobs.add(job2);
//        double score1 = myComparision.computeJobScore(job1);
//        double score2 = myComparision.computeJobScore(job2);
        ArrayList<Job> rankedJobs = myComparision.rankJobs(jobs);
//        assertEquals(rankedJobs.get(0).getCompany(), "Company2");
        double rankedScore1 = myComparision.computeJobScore(rankedJobs.get(0));
        double rankedScore2 = myComparision.computeJobScore(rankedJobs.get(1));



        assertEquals(rankedScore1>rankedScore2, true);

//            public Job(String title, String company,String city,  String state,
//            int costOfLiving,double yearlySalary,double yearlyBonus, double restrictedStockUnitAward,double relocationStipend,
//            int personalChoiceHolidays,boolean isCurrent)
    }



}