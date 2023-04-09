package com.example.intenttask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    private EditText numOne;
    private EditText numTwo;

    private Button btnSumar;
    private Button btnRestar;
    private Button btnMultiplicar;
    private Button btnDividir;
    private Button btnMaps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Operations op = new Operations();
        DialogError dialogError = new DialogError();

        numOne = findViewById(R.id.numOneText);
        numTwo = findViewById(R.id.numTwoText);

        btnSumar = findViewById(R.id.btnSumar);
        btnRestar = findViewById(R.id.btnRestar);
        btnMultiplicar = findViewById(R.id.btnMultiplicar);
        btnDividir = findViewById(R.id.btnDividir);

        btnMaps = findViewById(R.id.maps);

        btnSumar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num1 = numOne.getText().toString();
                String num2 = numTwo.getText().toString();

                if(num1.equals("") || num2.equals("")) {
                    dialogError.show(getSupportFragmentManager(), "invalid");
                } else {
                    int[] textNums = getNums(numOne, numTwo);

                    int numf = textNums[0];
                    int nums = textNums[1];

                    int resOp = op.suma(numf, nums);

                    Intent intent = new Intent(MainActivity.this, SumarView.class);
                    intent.putExtra("res", Integer.toString(resOp));
                    startActivity(intent);
                }
            }
        });

        btnRestar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num1 = numOne.getText().toString();
                String num2 = numTwo.getText().toString();

                if(num1.equals("") || num2.equals("")) {
                    dialogError.show(getSupportFragmentManager(), "invalid");
                } else {
                    int[] textNums = getNums(numOne, numTwo);

                    int numf = textNums[0];
                    int nums = textNums[1];

                    int resOp = op.resta(numf, nums);

                    Intent intent = new Intent(MainActivity.this, RestarView.class);
                    intent.putExtra("res", Integer.toString(resOp));
                    startActivity(intent);
                }
            }
        });

        btnMultiplicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num1 = numOne.getText().toString();
                String num2 = numTwo.getText().toString();

                if(num1.equals("") || num2.equals("")) {
                    dialogError.show(getSupportFragmentManager(), "invalid");
                } else {
                    int[] textNums = getNums(numOne, numTwo);

                    int numf = textNums[0];
                    int nums = textNums[1];

                    int resOp = op.multiplicacion(numf, nums);

                    Intent intent = new Intent(MainActivity.this, MultiplicarView.class);
                    intent.putExtra("res", Integer.toString(resOp));
                    startActivity(intent);
                }
            }
        });

        btnDividir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num1 = numOne.getText().toString();
                String num2 = numTwo.getText().toString();

                if (num1.equals("") || num2.equals("")) {
                    dialogError.show(getSupportFragmentManager(), "invalid");
                } else {
                    int[] textNums = getNums(numOne, numTwo);

                    float numf = textNums[0];
                    float nums = textNums[1];

                    float resOp = op.division(numf, nums);

                    Intent intent = new Intent(MainActivity.this, DividirView.class);
                    intent.putExtra("res", Float.toString(resOp));
                    startActivity(intent);
                }
            }
        });

        btnMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MapsActivity.class);
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