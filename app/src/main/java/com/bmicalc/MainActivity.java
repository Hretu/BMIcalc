package com.bmicalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etHeight, etWeight,etShowBMI;
    Button btnCalc;
    TextView tvBMI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etHeight = findViewById(R.id.etHeight);
        etWeight = findViewById(R.id.etWeight);
        btnCalc = findViewById(R.id.btnCalc);
        tvBMI = findViewById(R.id.tvBMI);
        etShowBMI = findViewById(R.id.etShowBMI);

        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(etHeight.getText().toString())) {
                    etHeight.setError("Please Enter your height");
                    return;
                }
                if (TextUtils.isEmpty(etWeight.getText().toString())) {
                    etWeight.setError("Please Enter your weight");
                    return;
                }

                double etHeight1, etWeight2;
                etHeight1 = Double.parseDouble(etHeight.getText().toString());
                etWeight2 = Double.parseDouble(etWeight.getText().toString());
                Ritu_BMI Result = new Ritu_BMI(etHeight1, etWeight2);
                double myBMI = Result.calcBMI();
                etShowBMI.setText(Double.toString(myBMI));
                if (myBMI<18.5)
                {
                    Toast.makeText(MainActivity.this," Your BMI is: Underweight ",Toast.LENGTH_LONG).show();
                }
                else if (myBMI>=18.5 && myBMI<=24.9)
                {
                    Toast.makeText(MainActivity.this,"Your BMI is: Normal Weight",Toast.LENGTH_LONG).show();
                }
                else if (myBMI>=25 && myBMI<=29.9)
                {
                    Toast.makeText(MainActivity.this,"Your BMI is: Overweight",Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(MainActivity.this,"Your BMI is: Obesity",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}