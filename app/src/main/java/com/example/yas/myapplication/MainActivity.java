package com.example.yas.myapplication;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

import static android.R.attr.name;
import static android.R.id.message;
import static com.example.yas.myapplication.R.id.quantityTextView;

public class MainActivity extends AppCompatActivity {
    private int quantity = 2;
    TextView quantityTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test2);
        quantityTextView = (TextView) findViewById(R.id.quantityTextView);
        display(quantity);
    }

    public void submitOrder(View view) {
        CheckBox whipped_cream = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        CheckBox chocolate = (CheckBox) findViewById(R.id.Chocolate_checkbox);
        String name = ((EditText) findViewById(R.id.name_input)).getText().toString();
        boolean whippedCreameChecked = whipped_cream.isChecked();
        boolean chocolateChecked = chocolate.isChecked();
        quantity = Integer.valueOf(quantityTextView.getText().toString());
        int price = calculate(quantity, whippedCreameChecked, chocolateChecked);
        String message = createOrderSumary(price, whippedCreameChecked, chocolateChecked, name);

displayPrice(message);
//        Intent intent = new Intent(Intent.ACTION_SEND);
//        intent.setType("*/*");
//        intent.putExtra(Intent.EXTRA_SUBJECT,"Order summury");
//        intent.putExtra(Intent.EXTRA_TEXT,message);
//        if (intent.resolveActivity(getPackageManager()) != null) {
//            startActivity(intent);
//        }
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int quantity) {
        quantityTextView.setText("" + quantity);
    }

    private void displayPrice(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.orderSummary);
        priceTextView.setText(message);
    }

    public void increment(View view) {
        quantity++;
        display(quantity);
    }

    public void decriment(View view) {
        if (quantity > 0) {
            quantity--;
        } else {
            Toast.makeText(this, "Cannot decrease under 0 !!!", Toast.LENGTH_SHORT).show();
        }
        display(quantity);
    }


    public String createOrderSumary(int price, boolean whippedCreamChecked, boolean chocolateChecked, String name) {
        String message = getString(R.string.input_name, name);
        message += "\n" +getString(R.string.add_whipped_cream)+ " ? "+whippedCreamChecked;
        message += "\n" +getString(R.string.add_chocolate)+ " ? "+chocolateChecked;
        message += "\n " +getString(R.string.quantity)+" : "+ quantity;
        message += "\n "+getString(R.string.total) +" :$" + price;
        message += "\n "+getString(R.string.thank_you);
        return message;
    }

    private int calculate(int quantity, boolean whippedCreameChecked, boolean chocolateChecked) {
        int price = 5;
        if (whippedCreameChecked) {
            price += 1;
        }
        if (chocolateChecked) {
            price += 2;
        }
        return price *= quantity;
    }
}
