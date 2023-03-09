package edu.gatech.seclass.jobcompare6300;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class AdjustWeight extends AppCompatActivity {
    private EditText yearlySalaryWeight;

    private EditText yearlyBonusWeight;
    private EditText rsuWeight;
    private EditText relocationStipendWeight;
    private EditText personalChoiceHolidaysWeight;

    private Button save_weight_button;
    private Button weightSettingReturnButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adjust_comparison_settings);

        save_weight_button = findViewById(R.id.save_weight_button);
        weightSettingReturnButton = findViewById(R.id.weightSettingReturnButton);


        yearlySalaryWeight = findViewById(R.id.weight_salary);
        yearlyBonusWeight = findViewById(R.id.weight_bonus);
        rsuWeight = findViewById(R.id.weight_stock);
        relocationStipendWeight = findViewById(R.id.weight_relocation);
        personalChoiceHolidaysWeight = findViewById(R.id.weight_holiday);
        save_weight_button = findViewById(R.id.save_weight_button);
        weightSettingReturnButton = findViewById(R.id.weightSettingReturnButton);

        Comparison comparison = MainActivity.comparison;
        yearlySalaryWeight.setText(String.valueOf(comparison.yearlySalaryWeight));
        yearlyBonusWeight.setText(String.valueOf(comparison.yearlyBonusWeight));
        rsuWeight.setText(String.valueOf(comparison.rsuWeight));
        relocationStipendWeight.setText(String.valueOf(comparison.relocationStipendWeight));
        personalChoiceHolidaysWeight.setText(String.valueOf(comparison.personalChoiceHolidaysWeight));




        save_weight_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean salary_weight_valid = !notValidArg(yearlySalaryWeight.getText().toString());
                boolean bonus_weight_valid = !notValidArg(yearlyBonusWeight.getText().toString());
                boolean rsu_weight_valid = !notValidArg(rsuWeight.getText().toString());
                boolean relo_weight_valid = !notValidArg(relocationStipendWeight.getText().toString());
                boolean holiday_weight_valid = !notValidArg(personalChoiceHolidaysWeight.getText().toString());

                if (salary_weight_valid & bonus_weight_valid & rsu_weight_valid&relo_weight_valid&holiday_weight_valid){
                    double salary_weight = Double.parseDouble(yearlySalaryWeight.getText().toString());
                    double bonus_weight = Double.parseDouble(yearlyBonusWeight.getText().toString());
                    double rsu_weight = Double.parseDouble(rsuWeight.getText().toString());
                    double relo_weight = Double.parseDouble(relocationStipendWeight.getText().toString());
                    double holiday_weight = Double.parseDouble(personalChoiceHolidaysWeight.getText().toString());
                    comparison.setWeights(salary_weight,bonus_weight,rsu_weight,relo_weight,holiday_weight);
                    Toast.makeText(getApplicationContext(), "Weights are Saved", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(AdjustWeight.this, MainActivity.class));
                }
                else {
                    if (!salary_weight_valid) {
                        yearlySalaryWeight.setError("Invalid Entry Text");
                    }
                    if (!bonus_weight_valid) {
                        yearlyBonusWeight.setError("Invalid Entry Text");
                    }
                    if (!rsu_weight_valid) {
                        rsuWeight.setError("Invalid Entry Text");
                    }
                    if (!relo_weight_valid) {
                        relocationStipendWeight.setError("Invalid Entry Text");
                    }
                    if (!holiday_weight_valid) {
                        personalChoiceHolidaysWeight.setError("Invalid Entry Text");
                    }
                }
            }
        });

        weightSettingReturnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdjustWeight.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
    private boolean notValidArg(String arg) {
        return (TextUtils.isEmpty(arg) || !isNumber(arg));
    }

    public boolean isNumber(String input) {
        try {
            Double.parseDouble(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


}


