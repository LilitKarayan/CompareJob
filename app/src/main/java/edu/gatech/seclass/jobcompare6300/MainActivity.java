package edu.gatech.seclass.jobcompare6300;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.File;
import java.util.ArrayList;

import edu.gatech.seclass.jobcompare6300.Comparison;
import edu.gatech.seclass.jobcompare6300.Job;

import android.os.Environment;

public class MainActivity extends AppCompatActivity {

    // We visit by these in other activities by MainActivity.jobs  MainActivity.comparison
    public static Comparison comparison;

    private Button enterCurrentJobButton;
    private Button enterJobOfferButton;
    private Button adjustComparisonSettingsButton;
    private Button compareJobButton;
    public static ArrayList<Job> jobs;
    public static int currentJobIndexPlusOne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.e("TEST", "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Do not create arrayList with every onCreate, only first time
        try{
            Log.e("TEST", String.valueOf(jobs.size()) );
            Log.v("bundle", "Restored");

        } catch(Exception e) {
            this.jobs = new ArrayList<>();
            Log.e("if Null", "Yes, array is created again");
        }
        try{
            if(this.currentJobIndexPlusOne > -1){
                String isCurrentJobAdded = "currentJob";
            }
        }
        catch(Exception e) {
            this.currentJobIndexPlusOne = 0;
        }
        this.enterCurrentJobButton = (Button) findViewById(R.id.enterCurrentJobButton);
        this.enterJobOfferButton = (Button) findViewById(R.id.enterJobOfferButton);
        this.adjustComparisonSettingsButton = (Button) findViewById(R.id.adjustCompSetButton);
        this.compareJobButton = (Button) findViewById(R.id.compareJobsButtons);

        this.enterCurrentJobButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("currentJobIndexGG", String.valueOf(currentJobIndexPlusOne-1));

                if(currentJobIndexPlusOne -1 == -1){
                    startActivity(new Intent(MainActivity.this, EnterCurrentJob.class));
                }
                else {
                    startActivity(new Intent(MainActivity.this, EditCurrentJob.class));
                }
            }
        });

        this.enterJobOfferButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, EnterJobOffer.class));
            }
        });

        this.adjustComparisonSettingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, AdjustWeight.class));
            }
        });

        this.compareJobButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, CompareActivity.class));
            }
        });


        if (comparison == null){
            File savePath = checkPath();
            comparison = new Comparison(savePath);
        }
    }

    // Everytime you are back to main menu
    @Override
    protected void onResume() {
        Log.e("TEST", "onResume1");

        super.onResume();
        if (getIntent().getSerializableExtra("job_offer") != null) {
            Job theNewJob = (Job) getIntent().getSerializableExtra("job_offer");
            if(theNewJob.getCurrent() == true && currentJobIndexPlusOne > 0) {         // if there is current job, edit it
                jobs.set(currentJobIndexPlusOne - 1, theNewJob);
            } else if(theNewJob.getCurrent() == true){                                // if there is no current job, add it
                jobs.add(theNewJob);
                currentJobIndexPlusOne = jobs.size();
            } else {                                                                 // add job offer (it is not current job)
                jobs.add(theNewJob);
            }
            Log.e("title", theNewJob.getTitle());
        }
        Log.e("TEST", String.valueOf(jobs.size()) );
    }

    //When leaving main menu page turns on pause
    @Override
    protected void onPause() {
        super.onPause();
        Log.e("TEST", "onPause");
    }

    public File checkPath(){
        File externalStorageDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        if (!externalStorageDir.exists()) {
            boolean success = externalStorageDir.mkdirs();
            if (!success) {
//           Log.e("TAG", "Failed to create directory");
            }
        }
        return externalStorageDir;
    }
}