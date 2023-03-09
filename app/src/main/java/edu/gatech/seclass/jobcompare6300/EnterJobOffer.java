package edu.gatech.seclass.jobcompare6300;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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

public class EnterJobOffer extends AppCompatActivity {

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enter_job_offer);

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
                Toast.makeText(getApplicationContext(), "Job Offer is Saved", Toast.LENGTH_SHORT).show();
                startActivity((new Intent(EnterJobOffer.this, MainActivity.class).putExtra("job_offer", addJobOffer())));
            }
        });

        this.cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Job Offer is Canceled", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(EnterJobOffer.this, MainActivity.class));
            }
        });
    }

    private Job addJobOffer() {
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

        theJob.setCurrent(false);

        return theJob;

        /*If we want to save on the txt file */
//        try {
//            // Write objects to file
////            File file = new File("./myJobs1.txt");
////            file.createNewFile();
//            FileOutputStream f = new FileOutputStream("myJobs.txt");
//            ObjectOutputStream o = new ObjectOutputStream(f);
//            o.writeObject(theJob);
//            o.close();
//            f.close();
//
//            // Read objects
////            File file = new File("./myJobs1.txt");
////            file.createNewFile();
//            FileInputStream fi = new FileInputStream("myJobs.txt");
//            ObjectInputStream oi = new ObjectInputStream(fi);
//            Job theJobRead = (Job) oi.readObject();
//            System.out.printf(theJobRead.toString());
//            oi.close();
//            fi.close();
//
//        } catch (ClassNotFoundException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (FileNotFoundException e) {
//            System.out.println("File not found");
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            System.out.println("Error initializing stream");
//            throw new RuntimeException(e);
//        }
    }
}