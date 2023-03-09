package edu.gatech.seclass.jobcompare6300;

import android.text.TextUtils;
import android.widget.ExpandableListAdapter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;



import edu.gatech.seclass.jobcompare6300.Job;

public class Comparison {
    public static final String COMPARISON_FILE = "comparison.txt";
    public File savePath = new File("./");
    public double yearlySalaryWeight = 1;
    public double yearlyBonusWeight = 1;
    public double rsuWeight = 1;
    public double relocationStipendWeight = 1;
    public double personalChoiceHolidaysWeight = 1;
    public double total_weight;

    public Comparison(File savePath){
        this();
        this.savePath = savePath;
    }

    public Comparison(){
        // the constructor
        try{
            this.readWights(); // if previous setting is stored in the disk, then read in weights and change attributes
        }
        catch (Exception e){
            // do nothing and use the default
        }
    }



    public void setWeights(double yearlySalaryWeight,double yearlyBonusWeight,
                           double rsuWeight, double relocationStipendWeight, double personalChoiceHolidaysWeight){

        this.yearlySalaryWeight = yearlySalaryWeight;
        this.yearlyBonusWeight = yearlyBonusWeight;
        this.rsuWeight = rsuWeight;
        this.relocationStipendWeight = relocationStipendWeight;
        this.personalChoiceHolidaysWeight = personalChoiceHolidaysWeight;
        this.total_weight = this.yearlySalaryWeight+this.yearlyBonusWeight+
                this.rsuWeight+this.relocationStipendWeight+this.personalChoiceHolidaysWeight;
        this.saveWeights();

    }


    public ArrayList<Job> rankJobs(ArrayList<Job> joblist){
        // Comment to Grace: Largely change the structure of this function.
        Map<Job, Double> jobScores = new HashMap<Job, Double>();
        for(Job job : joblist) {
            double job_score = computeJobScore(job);
            jobScores.put(job, job_score);
        }
        ArrayList<Map.Entry<Job, Double>> sortedScores = new ArrayList<>(jobScores.entrySet());
        Collections.sort(sortedScores, new Comparator<Map.Entry<Job, Double>>() {
            public int compare(Map.Entry<Job, Double> o1, Map.Entry<Job, Double> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
//        int rank = 1;
        ArrayList<Job> results = new ArrayList<>();
        for (Map.Entry<Job, Double> entry : sortedScores) {
            Job thisjob = entry.getKey();
            results.add(thisjob);

//            String title = job.getTitle();
//            String company = job.getCompany();
//            int score = entry.getValue();
//            rank++;
            }
        return results;
        }
        
    //TODO: comment: this function needs to return something, not void. ====> Done!

    public double computeJobScore(Job job){
        double ays = job.getYearlySalary();
        double ayb = job.getYearlyBonus();
        double rsu = job.getRestrictedStockUnitAward();
        double relo = job.getRelocationStipend();
        double pch = job.getPersonalChoiceHolidays();
        double score = (this.yearlySalaryWeight/this.total_weight)*ays
                +(this.yearlyBonusWeight/this.total_weight)*ayb
                +(this.rsuWeight/this.total_weight)*(rsu/4)
                +(this.relocationStipendWeight/this.total_weight)*relo
                +(this.personalChoiceHolidaysWeight/this.total_weight)*(pch*ays/260);
        return score;

    }
    // TODO: possible comments: put 4 and 260 here as CONSTANT variable with meaningful name
    // TODO: discussion with L&D Job implementation on the interface.
    // comment to Grace: all change to double other wise 1/5 = 0



    public void saveWeights(){
//        File externalStorageDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
//        if (!externalStorageDir.exists()) {
//            boolean success = externalStorageDir.mkdirs();
//            if (!success) {
////                Log.e("TAG", "Failed to create directory");
//            }
//        }


        File file = new File (this.savePath,COMPARISON_FILE);
        try {
            FileWriter fileWriter = new FileWriter(file, false);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println(this.yearlySalaryWeight);
            printWriter.println(this.yearlyBonusWeight);
            printWriter.println(this.rsuWeight);
            printWriter.println(this.relocationStipendWeight);
            printWriter.println(this.personalChoiceHolidaysWeight);
            printWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void readWights() throws Exception{ //If file not exist. Also need to change constructor
//        File externalStorageDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
//        if (!externalStorageDir.exists()) {
//            boolean success = externalStorageDir.mkdirs();
//            if (!success) {
////                Log.e("TAG", "Failed to create directory");
//            }
//        }
//
//
//        File inputFile = new File (externalStorageDir,COMPARISON_FILE);
        File inputFile = new File (this.savePath,COMPARISON_FILE);
        try {
            Scanner scan = new Scanner(inputFile);
            ArrayList<Double> weights = new ArrayList<Double>();
            while (scan.hasNext()) {

                String line = scan.nextLine();
                weights.add(Double.parseDouble(line));
            }
//            this.yearlySalaryWeight = weights.get(0);
//            this.yearlyBonusWeight = weights.get(1);
//            this.rsuWeight = weights.get(2);
//            this.relocationStipendWeight = weights.get(3);
//            this.personalChoiceHolidaysWeight = weights.get(4);
            this.setWeights(weights.get(0),weights.get(1),weights.get(2),weights.get(3),weights.get(4));
        }
        catch(Exception e){
            System.out.println("Error when reading weights from disk, maybe due to firstly time using the app or true errors");
            throw new Exception("readWeights error");
        }


    }

//    public void checkPath(){
//        File externalStorageDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
//
//// Check if the directory exists, and create it if it doesn't
//        if (!externalStorageDir.exists()) {
//            boolean success = externalStorageDir.mkdirs();
//            if (!success) {
//                Log.e("TAG", "Failed to create directory");
//            }
//        }
//
//// Use the external storage directory to create a file
//        File file = new File(externalStorageDir, "myFile.txt");
//
//// Perform file operations on the file
//// ...
//
//    }


}
