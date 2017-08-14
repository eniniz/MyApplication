package com.example.yas.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

import static com.example.yas.myapplication.R.id.quantityTextView;

public class MainActivity extends AppCompatActivity {
    private int numberOfCoffees=2;
    TextView quantityTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.test2);
        quantityTextView = (TextView) findViewById(R.id.quantityTextView);
        display(numberOfCoffees);
    }

    public void submitOrder(View view) {
        numberOfCoffees=Integer.valueOf(quantityTextView.getText().toString());
        display(numberOfCoffees);
        displayPrice(numberOfCoffees*50);
    }
    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        quantityTextView.setText("" + number);
    }
    private void displayPrice(int number){
        TextView priceTextView = (TextView) findViewById(R.id.priceTextView);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    public void increment(View view){
        numberOfCoffees++;
        display(numberOfCoffees);
    }
    public void decriment(View view){
        if(numberOfCoffees>0) {
            numberOfCoffees--;
        }
        display(numberOfCoffees);
    }
}
