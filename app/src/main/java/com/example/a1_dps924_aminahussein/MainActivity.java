package com.example.a1_dps924_aminahussein;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendOutput(View view){
        Button b = (Button)view;
        ViewParent linearLayout = view.getParent().getParent();
        TextView mainOutput = (TextView) ((View) linearLayout).findViewById(R.id.mainLabel);
        CalculatorBrain calculation = new CalculatorBrain();
        String value = b.getText().toString();
        String divide = "/";
        switch(value){
            case "C":
                System.out.println("clear the output");
                mainOutput.setText("");
                calculation.clear();
                break;
            case "=":
                mainOutput.append(value);
                if(calculation.verify()){
                    try{
                        int results = calculation.calculate();
                        mainOutput.append(" " + String.valueOf(results));
                    }catch(Exception e){
                        mainOutput.append(" Error!");
                    }
                }else {
                    mainOutput.append(" Error!");
                }
                break;
            default:
                mainOutput.append(value + " ");
                calculation.push(value);
                break;

        }
        System.out.println("after use case" + b.getText().toString());
    }
}