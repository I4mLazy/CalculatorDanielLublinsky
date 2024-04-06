package com.example.calculatordaniellublinsky;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity
{
    EditText input;
    Button plus;
    Button minus;
    Button multiply;
    Button divide;
    Button equals;
    Button AC;
    Button credits;
    int temp;
    int counter;
    int total;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) ->
        {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        input = findViewById(R.id.input);
        plus = findViewById(R.id.plus);
        minus = findViewById(R.id.minus);
        multiply = findViewById(R.id.multiply);
        divide = findViewById(R.id.divide);
        equals = findViewById(R.id.equals);
        AC = findViewById(R.id.AC);
        credits = findViewById(R.id.credits);

    }


    public void plus(View view)
    {
        if(!input.getText().toString().isEmpty())
        {

            total = total + temp;
            temp = Integer.parseInt(String.valueOf(input.getText()));
            if(counter > 0)
            {
                input.setHint(input.getHint() + "" +temp + "+");
            }
            else
            {
                input.setHint(temp + "+");
            }
            input.setText("");
            counter++;
        }
    }


    public void minus(View view)
    {
        if(!input.getText().toString().isEmpty())
        {

            total = total - temp;
            temp = Integer.parseInt(String.valueOf(input.getText()));
            if(counter > 0)
            {
                input.setHint(input.getHint() + "" +temp + "-");
            }
            else
            {
                input.setHint(temp + "-");
            }
            input.setText("");
            counter++;
        }
    }
}