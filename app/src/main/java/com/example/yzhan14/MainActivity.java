package com.example.yzhan14.numbaseconverer;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button)findViewById(R.id.convertButton);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick (View view){
                try {
                    int base1 = Integer.parseInt(((EditText) findViewById(R.id.base1)).getText().toString());
                    EditText num1Edit = (EditText) findViewById(R.id.num1);
                    //get rid of possible red background
                    num1Edit.setBackgroundColor(Color.TRANSPARENT);

                    String num1 = (num1Edit).getText().toString();
                    int base2 = Integer.parseInt(((EditText) findViewById(R.id.base2)).getText().toString());
                    String num2 = Integer.toString(Integer.parseInt(num1, base1), base2);
                    EditText answer = (EditText) findViewById(R.id.num2);
                    answer.setText(num2);
                }catch (Exception e){
                    ((EditText) findViewById(R.id.num1)).setBackgroundResource(R.color.errorBackground);
                    ((EditText) findViewById(R.id.num2)).setText("");
                    Toast.makeText(MainActivity.this, R.string.error_msg, Toast.LENGTH_SHORT).show();
                }
            }

        });
    }
}
