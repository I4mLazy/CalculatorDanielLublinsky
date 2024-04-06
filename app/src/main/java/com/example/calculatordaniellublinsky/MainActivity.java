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
    int prevtemp;
    String prevaction = "";


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
            temp = Integer.parseInt(String.valueOf(input.getText()));
            if(counter > 0)
            {
                total = Total(total,temp,prevaction,prevtemp);
                input.setHint(input.getHint() + "" +temp + "+");
            }
            else
            {
                total = temp;
                input.setHint(temp + "+");
            }
            input.setText("");
            counter++;
            prevaction ="+";
        }
    }


    public void minus(View view)
    {
        if(!input.getText().toString().isEmpty())
        {
            temp = Integer.parseInt(String.valueOf(input.getText()));
            if(counter > 0)
            {
                total = Total(total,temp,prevaction,prevtemp);
                input.setHint(input.getHint() + "" +temp + "-");
            }
            else
            {
                total = temp;
                input.setHint(temp + "-");
            }
            input.setText("");
            counter++;
            prevaction ="-";
        }
    }


    public void multiply(View view)
    {
        if(!input.getText().toString().isEmpty())
        {
            temp = Integer.parseInt(String.valueOf(input.getText()));
            if(counter > 0)
            {
                if(prevaction.equals("*") || prevaction.equals("/"))
                {
                    prevtemp = MDsum(prevtemp, prevaction, temp);
                }
                else
                {
                    total = Total(total,temp,prevaction,prevtemp);
                    prevtemp = temp;
                }
                input.setHint(input.getHint() + "" +temp + "*");
            }
            else
            {
                prevtemp = temp;
                input.setHint(temp + "*");
            }
            input.setText("");
            counter++;
            prevaction ="*";
        }
    }


    public void divide(View view)
    {
        if(!input.getText().toString().isEmpty())
        {
            temp = Integer.parseInt(String.valueOf(input.getText()));
            if(counter > 0)
            {
                if(prevaction.equals("*") || prevaction.equals("/"))
                {
                    prevtemp = MDsum(prevtemp, prevaction, temp);
                }
                else
                {
                    total = Total(total,temp,prevaction,prevtemp);
                    prevtemp = temp;
                }
                input.setHint(input.getHint() + "" +temp + "/");
            }
            else
            {
                prevtemp = temp;
                input.setHint(temp + "/");
            }
            input.setText("");
            counter++;
            prevaction ="/";
        }
    }


    public void equals(View view)
    {
        if(!input.getText().toString().isEmpty())
        {
            temp = Integer.parseInt(String.valueOf(input.getText()));
            if(counter > 0)
            {
                total = Total(total, temp, prevaction, prevtemp);
                input.setText(total + "");
            }
            else
            {
                total = temp;
                input.setText(temp + "");
            }
            counter=0;
            input.setHint("");
            prevaction = "";
            temp = total;
            total = 0;
        }
    }









    public int Total(int total, int temp, String prevaction, int prevtemp)
    {
        switch (prevaction)
        {
            case "+":
                return total + temp;
            case "-":
                return total - temp;
            case "*":
                return total + prevtemp * temp;
            case "/":
                return total + prevtemp / temp;
        }
        return temp;
    }

    public int MDsum(int prevtemp, String prevaction, int temp)
    {
        if(prevaction.equals("*"))
        {
            return prevtemp*temp;
        }
        else
        {
            return  prevtemp/temp;
        }
    }
}