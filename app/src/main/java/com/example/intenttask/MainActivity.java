package com.example.intenttask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private EditText numOne;
    private EditText numTwo;

    private Button btnSumar;
    private Button btnRestar;
    private Button btnMultiplicar;
    private Button btnDividir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Operations op = new Operations();

        numOne = findViewById(R.id.numOneText);
        numTwo = findViewById(R.id.numTwoText);

        btnSumar = findViewById(R.id.btnSumar);
        btnRestar = findViewById(R.id.btnRestar);
        btnMultiplicar = findViewById(R.id.btnMultiplicar);
        btnDividir = findViewById(R.id.btnDividir);

        btnSumar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int[] textNums = getNums(numOne, numTwo);

                int numf = textNums[0];
                int nums = textNums[1];

                int resOp = op.suma(numf, nums);

                Intent intent = new Intent(MainActivity.this, SumarView.class);
                startActivity(intent);
            }
        });

        btnRestar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int[] textNums = getNums(numOne, numTwo);

                int numf = textNums[0];
                int nums = textNums[1];

                int resOp = op.resta(numf, nums);

                Intent intent = new Intent(MainActivity.this, RestarView.class);
                startActivity(intent);
            }
        });

        btnMultiplicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int[] textNums = getNums(numOne, numTwo);

                int numf = textNums[0];
                int nums = textNums[1];

                int resOp = op.multiplicacion(numf, nums);

                Intent intent = new Intent(MainActivity.this, MultiplicarView.class);
                startActivity(intent);
            }
        });

        btnDividir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int[] textNums = getNums(numOne, numTwo);

                int numf = textNums[0];
                int nums = textNums[1];

                int resOp = op.division(numf, nums);

                Intent intent = new Intent(MainActivity.this, DividirView.class);
                startActivity(intent);
            }
        });
    }

    public int[] getNums(EditText numOne, EditText numTwo) {
        int[] res = {0,0};

        String numf = this.numOne.getText().toString().trim();
        String nums = this.numTwo.getText().toString().trim();

        int numParse1 = Integer.parseInt(numf);
        int numParse2 = Integer.parseInt(nums);

        res[0] = numParse1;
        res[1] = numParse2;

        numOne.setText("");
        numTwo.setText("");

        return res;
    }
}