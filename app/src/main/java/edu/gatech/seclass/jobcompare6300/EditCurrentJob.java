package edu.gatech.seclass.jobcompare6300;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class EditCurrentJob extends AppCompatActivity {

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
        setContentView(R.layout.edit_current_job);

        this.title = (EditText) findViewById(R.id.offerTitleInput);
        this.company = (EditText) findViewById(R.id.offerCompanyInput);
        this.city = (EditText) findViewById(R.id.offerLocationCityInput);
        this.state = (EditText) findViewById(R.id.offerLocationStateInput);
        this.costOfLiving = (EditText) findViewById(R.id.offerCostOfLivingInput);
        this.yearlySalary = (EditText) findViewById(R.id.offerYearlySalaryInput);
        this.yearlyBonus = (EditText) findViewById(R.id.offerYearlyBonus);
        this.restrictedStockUnitAward = (EditText) findViewById(R.id.offerRSUInput);
        this.relocationStipend = (EditText) findViewById(R.id.offerReloInput);
        this.personalChoiceHolidays = (EditText) findViewById(R.id.offerPCHInput);

        this.saveButton = (Button) findViewById(R.id.offerSaveButton);
        this.cancelButton = (Button) findViewById(R.id.offerCancelButton);

        this.saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Current Job is Edited", Toast.LENGTH_SHORT).show();
                startActivity((new Intent(EditCurrentJob.this, MainActivity.class).putExtra("job_offer", editCurrentJob())));
            }
        });

        this.cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Canceled", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(EditCurrentJob.this, MainActivity.class));
            }
        });
    }

    private Job editCurrentJob() {
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