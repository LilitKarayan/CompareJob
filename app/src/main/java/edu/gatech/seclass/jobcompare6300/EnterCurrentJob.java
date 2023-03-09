package edu.gatech.seclass.jobcompare6300;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class EnterCurrentJob extends AppCompatActivity {

    private EditText title;
    private EditText company;
    private EditText city;
    private EditText state;
    private EditText costOfLiving;
    private EditText yearlySalary;
    private EditText yearlyBonus;
    private EditText restrictedStockUnitAward;
    private EditText relocationStipend;
    private EditText personalChoiceHolidays;
    private Button saveButton;
    private Button cancelButton;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enter_current_job);

        this.title = (EditText) findViewById(R.id.currTitleInput);
        this.company = (EditText) findViewById(R.id.currCompanyInput);
        this.city = (EditText) findViewById(R.id.currLocationCityInput);
        this.state = (EditText) findViewById(R.id.currLocationStateInput);
        this.costOfLiving = (EditText) findViewById(R.id.currCostOfLivingInput);
        this.yearlySalary = (EditText) findViewById(R.id.currYearlySalaryInput);
        this.yearlyBonus = (EditText) findViewById(R.id.currYearlyBonusInput);
        this.restrictedStockUnitAward = (EditText) findViewById(R.id.currRSUInput);
        this.relocationStipend = (EditText) findViewById(R.id.currReloInput);
        this.personalChoiceHolidays = (EditText) findViewById(R.id.currPCHInput);

        this.saveButton = (Button) findViewById(R.id.currSaveEnterButton);
        this.cancelButton = (Button) findViewById(R.id.currCancelEnterButton);

        this.saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Current Job is Saved", Toast.LENGTH_SHORT).show();
                startActivity((new Intent(EnterCurrentJob.this, MainActivity.class).putExtra("job_offer", addCurrentJob())));
            }
        });

        this.cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Current Job is Canceled", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(EnterCurrentJob.this, MainActivity.class));
            }
        });
    }

    private Job addCurrentJob() {
        Job theJob = new Job();
        theJob.setTitle(this.title.getText().toString());
        theJob.setCompany(this.company.getText().toString());
        theJob.setCity(this.city.getText().toString());
        theJob.setState(this.state.getText().toString());
        theJob.setCostOfLiving(Integer.parseInt(String.valueOf(this.costOfLiving.getText())));
        theJob.setYearlySalary(Double.parseDouble(String.valueOf(this.yearlySalary.getText())));
        theJob.setYearlyBonus(Double.parseDouble(String.valueOf(this.yearlyBonus.getText())));
        theJob.setRestrictedStockUnitAward(Double.parseDouble(String.valueOf(this.restrictedStockUnitAward.getText())));
        theJob.setRelocationStipend(Double.parseDouble(String.valueOf(this.relocationStipend.getText())));
        theJob.setPersonalChoiceHolidays(Integer.parseInt(String.valueOf(this.personalChoiceHolidays.getText())));

        theJob.setCurrent(true);

        return theJob;
    }
}