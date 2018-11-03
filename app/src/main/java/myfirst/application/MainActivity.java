package myfirst.application;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;

import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //TextViews and Buttons
    Button  number0,number1,number2,number3,number4,
            number5,number6,number7,number8,number9;

    Button  d100,d20,d12,d10,d8,d6,d4,d3,d2;

    Button calcSub, calcAdd, rollDie;

    EditText calculation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeViews();
        setButtonListeners();
    }

    public void initializeViews(){
        number0 = (Button) findViewById(R.id.number0);
        number1 = (Button) findViewById(R.id.number1);
        number2 = (Button) findViewById(R.id.number2);
        number3 = (Button) findViewById(R.id.number3);
        number4 = (Button) findViewById(R.id.number4);
        number5 = (Button) findViewById(R.id.number5);
        number6 = (Button) findViewById(R.id.number6);
        number7 = (Button) findViewById(R.id.number7);
        number8 = (Button) findViewById(R.id.number8);
        number9 = (Button) findViewById(R.id.number9);

        d100 = (Button) findViewById(R.id.d100);
        d20 = (Button) findViewById(R.id.d20);
        d12 = (Button) findViewById(R.id.d12);
        d10= (Button) findViewById(R.id.d10);
        d8 = (Button) findViewById(R.id.d8);
        d6= (Button) findViewById(R.id.d6);
        d4 = (Button) findViewById(R.id.d4);
        d3 = (Button) findViewById(R.id.d3);
        d2= (Button) findViewById(R.id.d2);

        calcSub = (Button) findViewById(R.id.subtract);
        calcAdd = (Button) findViewById(R.id.addition);
        rollDie = (Button) findViewById(R.id.rollDice);

        calculation = (EditText) findViewById(R.id.calculation);

    }

    public void setButtonListeners(){
        number0.setOnClickListener(this);
        number1.setOnClickListener(this);
        number2.setOnClickListener(this);
        number3.setOnClickListener(this);
        number4.setOnClickListener(this);
        number5.setOnClickListener(this);
        number6.setOnClickListener(this);
        number7.setOnClickListener(this);
        number8.setOnClickListener(this);
        number9.setOnClickListener(this);
        calcAdd.setOnClickListener(this);
        calcSub.setOnClickListener(this);
        rollDie.setOnClickListener(this);

        d100.setOnClickListener(this);
        d20.setOnClickListener(this);
        d12.setOnClickListener(this);
        d10.setOnClickListener(this);
        d8.setOnClickListener(this);
        d6.setOnClickListener(this);
        d4.setOnClickListener(this);
        d3.setOnClickListener(this);
        d2.setOnClickListener(this);
    }

    public int calculateRoll(){
        String roll = calculation.getText().toString();
        roll = roll.replaceAll("-","+-");
        StringTokenizer parsedRoll = new StringTokenizer(roll, "+");
        int calculatedRoll = 0;
        while (parsedRoll.hasMoreTokens()){
            String temp = parsedRoll.nextToken();
            if (temp.contains("d")){
                calculatedRoll += calculateDice(temp);
            }
            else{
                calculatedRoll += Integer.parseInt(temp);
            }
        }
        Log.i("Calculated Roll:", "" + calculatedRoll);
        //Log.i("Roll", " is: " + roll);
        return calculatedRoll;
    }

    public int calculateDice(String dice){
        String temp = dice;
        int calculatedDice = 0;
        int firstToken = 1;
        boolean isSecondToken = false;
        boolean isNegative;

        if (temp.contains("-")){
            isNegative = true;
        }
        else{
            isNegative = false;
        }

        Log.i("Temp", " " + temp);
        StringTokenizer parsedDice = new StringTokenizer(temp, "d");
        while (parsedDice.hasMoreTokens()){
            if (!isSecondToken && parsedDice.countTokens() > 1) {
                try {
                    firstToken = Integer.parseInt(parsedDice.nextToken());
                }
                catch (NumberFormatException e){
                    firstToken = -1;
                }
                Log.i("Calculated Dice", "" + calculatedDice + " token " + firstToken);
                isSecondToken = true;
            }
            else if (isSecondToken){
                int count = 0;
                int diceType = Integer.parseInt(parsedDice.nextToken());
                Log.i("Dice Type", "" + diceType);
                if (!isNegative) {
                    while (count < firstToken) {
                        int rollDice = ((int) (Math.random() * diceType) + 1);
                        calculatedDice += rollDice;
                        Log.i("Calculated Dice", "" + calculatedDice + " Dice roll:" + rollDice);
                        count++;
                    }
                }
                else{
                    while (count > firstToken) {
                        int rollDice = -1 * ((int) (Math.random() * diceType) + 1);
                        calculatedDice += rollDice;
                        Log.i("Calculated Dice", "" + calculatedDice + " Dice roll:" + rollDice);
                        count--;
                    }
                }
            }
            else{
                int diceType = Integer.parseInt(parsedDice.nextToken());
                int rollDice = ((int) (Math.random() * diceType) + 1);
                calculatedDice +=  rollDice;
                Log.i("Calculated Dice", "" + calculatedDice + " Dice roll:" + rollDice);
            }
        }
        return calculatedDice;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.number0:
                calculation.setText(calculation.getText() + "0");
                break;
            case R.id.number1:
                calculation.setText(calculation.getText() + "1");
                break;
            case R.id.number2:
                calculation.setText(calculation.getText() + "2");
                break;
            case R.id.number3:
                calculation.setText(calculation.getText() + "3");
                break;
            case R.id.number4:
                calculation.setText(calculation.getText() + "4");
                break;
            case R.id.number5:
                calculation.setText(calculation.getText() + "5");
                break;
            case R.id.number6:
                calculation.setText(calculation.getText() + "6");
                break;
            case R.id.number7:
                calculation.setText(calculation.getText() + "7");
                break;
            case R.id.number8:
                calculation.setText(calculation.getText() + "8");
                break;
            case R.id.number9:
                calculation.setText(calculation.getText() + "9");
                break;
            case R.id.subtract:
                calculation.setText(calculation.getText() + "-");
                break;
            case R.id.addition:
                calculation.setText(calculation.getText() + "+");
                break;
            case R.id.rollDice:
                calculation.setText(Integer.toString(calculateRoll()));
                break;
            case R.id.d100:
                calculation.setText(calculation.getText() + "d100");
                break;
            case R.id.d20:
                calculation.setText(calculation.getText() + "d20");
                break;
            case R.id.d12:
                calculation.setText(calculation.getText() + "d12");
                break;
            case R.id.d10:
                calculation.setText(calculation.getText() + "d10");
                break;
            case R.id.d8:
                calculation.setText(calculation.getText() + "d8");
                break;
            case R.id.d6:
                calculation.setText(calculation.getText() + "d6");
                break;
            case R.id.d4:
                calculation.setText(calculation.getText() + "d4");
                break;
            case R.id.d3:
                calculation.setText(calculation.getText() + "d3");
                break;
            case R.id.d2:
                calculation.setText(calculation.getText() + "d2");
                break;
        }
    }
}
