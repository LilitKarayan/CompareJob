package edu.gatech.seclass.jobcompare6300;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import edu.gatech.seclass.jobcompare6300.ComparisonAdapter;

import java.util.ArrayList;
import edu.gatech.seclass.jobcompare6300.Job;


public class CompareActivity extends AppCompatActivity {


    RecyclerView recyclerView;
//    private ArrayList<Job> jobs = new ArrayList<Job>(); //import  Don't need to store here, just need to stored in Adapter is enough
    private ComparisonAdapter adapter;
    Button btn; //link to Compare button

    Comparison comparison = MainActivity.comparison;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ranked_job_list);

        recyclerView = findViewById(R.id.jobListRecyclerView);
        btn = findViewById(R.id.compareJobsButton);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

//
//        //FOR DEBUG!
//        Job job1 = new Job("title1","Company1","City1","State1", 2000,100000.0,10000.0,2.0,1000.0,10,false);
//        Job job2 = new Job("title2","Company2","City2","State2", 1000,200000.0,10000.0,2.0,1000.0,10,false);
//        Job job3 = new Job("title3","Company3","City3","State3", 1000,300000.0,10000.0,2.0,1000.0,10,false);
//        Job job4 = new Job("title4","Company4","City4","State4", 1000,400000.0,10000.0,2.0,1000.0,10,true);
//        MainActivity.jobs = new ArrayList<>();
//        MainActivity.jobs.add(job1);
//        MainActivity.jobs.add(job3);
//        MainActivity.jobs.add(job4);
//        MainActivity.jobs.add(job2);
//
//        //FOR DEBUG!


        ArrayList<Job> rankedJobs = comparison.rankJobs(MainActivity.jobs);//visit jobs in main and rank
        adapter = new ComparisonAdapter(this, rankedJobs);
        recyclerView.setAdapter(adapter);



//        CreateListOfData();//use for create some fake job data.



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)  {
                ArrayList<Job> selected = adapter.getSelected();
                if (selected.size() == 2){ // TODO: in our case should be ==2 and <2: need to select  >2: select too many. Warning!
//                    StringBuilder stringBUIlder = new StringBuilder();
//                    for (int i = 0; i< adpter.getSelected().size(); i++){
//
//                    }
                    //Here we need to jump to another layout to show the comparison results
                    // todo: add back lalter => done!
                    Intent intent = new Intent(CompareActivity.this, ComparisonResults.class );
                    intent.putExtra ("TwoJobs",selected);
                    startActivity(intent);

                    // Todo: also need to passed the selected two jobs  to ComparisonResults
                }



                }
        });

    }



//    private void CreateListOfData(){ //This can be for for testing?
//        // set
//    }
}