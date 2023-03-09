package edu.gatech.seclass.jobcompare6300;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SetComparisonActivity extends AppCompatActivity {

    private Button radioButton;
    private EditText text_weight_salary;
    private EditText text_weight_bonus;
    private EditText text_weight_stock;
    private EditText text_weight_relocation;
    private EditText text_weight_holiday;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adjust_comparison_settings);

        radioButton = (Button) findViewById(R.id.weightSettingReturnButton);
        text_weight_salary = (EditText) findViewById(R.id.weight_salary);
        text_weight_bonus = (EditText) findViewById(R.id.weight_bonus);
        text_weight_stock = (EditText) findViewById(R.id.weight_stock);
        text_weight_relocation = (EditText) findViewById(R.id.weight_relocation);
        text_weight_holiday = (EditText) findViewById(R.id.weight_holiday);

        radioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // set and save
                Comparison comparison = MainActivity.comparison;

                int weight_salary = Integer.parseInt(text_weight_salary.getText().toString());
                int weight_bonus = Integer.parseInt(text_weight_bonus.getText().toString());
                int weight_stock = Integer.parseInt(text_weight_stock.getText().toString());
                int weight_relocation = Integer.parseInt(text_weight_relocation.getText().toString());
                int weight_holiday = Integer.parseInt(text_weight_holiday.getText().toString());

                comparison.setWeights(weight_salary,weight_bonus,weight_stock,weight_relocation,weight_holiday);

                // return to homepage
                Intent intent = new Intent(SetComparisonActivity.this, MainActivity.class );
                startActivity(intent);


            }
        });


    }



}
