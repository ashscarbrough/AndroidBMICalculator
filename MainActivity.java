package scarbrough.bmicalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText heightFeet;  //Input height in feet from user
    private EditText heightInches;  //Input height in inches from user
    private EditText weightPounds;  //Input weight in pounds from user
    private double bmi = 0.0;  //bmi value set as double
    private TextView bmiTextView;  //Return value for calculation

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Upon button click, of Calculate button
    public void buttonOnClick (View calculateBMI){

        bmiTextView = (TextView) findViewById(R.id.bmiTextView);
        Button bmiButton = (Button) calculateBMI;

        heightFeet = (EditText) findViewById(R.id.feetEditText);    //Associate height feet with proper Edit text field
        heightInches = (EditText) findViewById(R.id.InchesEditText);  //Associate height inches with proper Edit text field
        weightPounds = (EditText) findViewById(R.id.poundsEditText);  //Associate weight with proper Edit text field

        int feet = Integer.parseInt(heightFeet.getText().toString());  //Read height input from user
        int inches =  Integer.parseInt(heightInches.getText().toString());  //Read Input from user
        double totalHeight = (double) ((feet * 12) + inches);  // Convert feet to inches and add user supplied inch input

        int weight =  Integer.parseInt(weightPounds.getText().toString());  //Read Input from user
        bmi = ((weight *703)/ (totalHeight * totalHeight));  // BMI Calculation

        bmiTextView.setText("" + bmi);  // Set text of bmi Textview to calculated amount
    }
}
