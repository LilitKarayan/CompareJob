package edu.gatech.seclass.jobcompare6300;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import edu.gatech.seclass.jobcompare6300.Job;

public class ComparisonResults extends AppCompatActivity{
    Button another_comparison_button;
    Button return_to_main_button;
    TextView title_1,title_2,company_1,company_2,location_1,location_2,salary_1,salary_2,bonus_1,bonus_2,rsu_1,rsu_2,relo_1,relo_2,holidays_1,holidays_2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.compare_jobs);

        title_1 = findViewById(R.id.title_1);
        title_2 = findViewById(R.id.title_2);
        company_1 = findViewById(R.id.company_1);
        company_2 = findViewById(R.id.company_2);
        location_1 = findViewById(R.id.location_1);
        location_2 = findViewById(R.id.location_2);
        salary_1 = findViewById(R.id.salary_1);
        salary_2 = findViewById(R.id.salary_2);
        bonus_1 = findViewById(R.id.bonus_1);
        bonus_2 = findViewById(R.id.bonus_2);
        rsu_1 = findViewById(R.id.rsu_1);
        rsu_2 = findViewById(R.id.rsu_2);
        relo_1 = findViewById(R.id.relo_1);
        relo_2 = findViewById(R.id.relo_2);
        holidays_1 = findViewById(R.id.holidays_1);
        holidays_2 = findViewById(R.id.holidays_2);
        another_comparison_button = findViewById(R.id.another_comparison_button);
        return_to_main_button = findViewById(R.id.return_to_main_button);
        Intent intent = getIntent();
        ArrayList<Job> jobs = (ArrayList<Job>) intent.getSerializableExtra("TwoJobs");
        Job job1 = jobs.get(0);
        Job job2 = jobs.get(1);
        title_1.setText(job1.getTitle());
        title_2.setText(job2.getTitle());
        company_1.setText(job1.getCompany());
        company_2.setText(job2.getCompany());
        location_1.setText(job1.getCity()+","+job1.getState());
        location_2.setText(job2.getCity()+","+job2.getState());
        salary_1.setText(Double.toString(job1.getYearlySalary()));
        salary_2.setText(Double.toString(job2.getYearlySalary()));
        bonus_1.setText(Double.toString(job1.getYearlyBonus()));
        bonus_2.setText(Double.toString(job2.getYearlyBonus()));
        rsu_1.setText(Double.toString(job1.getRestrictedStockUnitAward()));
        rsu_2.setText(Double.toString(job2.getRestrictedStockUnitAward()));
        relo_1.setText(Double.toString(job1.getRelocationStipend()));
        relo_2.setText(Double.toString(job2.getRelocationStipend()));
        holidays_1.setText(Integer.toString(job1.getPersonalChoiceHolidays()));
        holidays_2.setText(Integer.toString(job2.getPersonalChoiceHolidays()));
        another_comparison_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ComparisonResults.this, CompareActivity.class);
                startActivity(intent);
                finish();
            }
        });
        return_to_main_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ComparisonResults.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
    }
