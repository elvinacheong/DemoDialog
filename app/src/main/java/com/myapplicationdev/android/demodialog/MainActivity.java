package com.myapplicationdev.android.demodialog;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button btnDemo1, btnDemo2, btnDemo3, btnEx3, btnDemo4, btnDemo5;
    TextView tvDemo2, tvDemo3, tvEx3, tvDemo4, tvDemo5;
    EditText etInput, etFirst, etSecond;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDemo1 = findViewById(R.id.buttonDemo1);
        btnDemo2 = findViewById(R.id.buttonDemo2);
        btnDemo3 = findViewById(R.id.buttonDemo3);
        btnEx3 = findViewById(R.id.buttonEx3);
        btnDemo4 = findViewById(R.id.buttonDemo4);
        btnDemo5 = findViewById(R.id.buttonDemo5);

        tvDemo2 = findViewById(R.id.textViewDemo2);
        tvDemo3 = findViewById(R.id.textViewDemo3);
        tvEx3 = findViewById(R.id.textViewEx3);
        tvDemo4 = findViewById(R.id.textViewDemo4);
        tvDemo5 = findViewById(R.id.textViewDemo5);

        etInput = findViewById(R.id.editTextInput);
        etFirst = findViewById(R.id.editTextFirst);
        etSecond = findViewById(R.id.editTextSecond);

        btnDemo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Create the Dialog Builder
                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);

                // Set the dialog details
                /*
                myBuilder.setTitle("Demo 1-Simple Dialog");
                myBuilder.setMessage("I can develop Android App.");
                myBuilder.setCancelable(false);
                myBuilder.setPositiveButton("Close", null);
                */

                myBuilder.setTitle("Congratulations");
                myBuilder.setMessage("You have completed a simple Dialog Box");
                myBuilder.setCancelable(true);
                myBuilder.setPositiveButton("Dismiss", null);
                myBuilder.setNegativeButton("Dismiss", null);

                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });

        btnDemo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
                myBuilder.setTitle("Demo 2 Buttons Dialog");
                myBuilder.setMessage("Select one of the Buttons below.");
                myBuilder.setCancelable(false);

                // Configure the 'positive' button
                myBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        tvDemo2.setText("You have selected Positive.");
                    }
                });

                myBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        tvDemo2.setText("You have selected Negative.");
                    }
                });

                // Configure the 'neutral' button
                myBuilder.setNeutralButton("Cancel", null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });

        btnDemo3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Inflate the input.xml layout file
                LayoutInflater inflater =
                        (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View viewDialog = inflater.inflate(R.layout.input, null);

                // Obtain the UI component in the input.xml layout
                // It needs to be defined as "final", so that it can used in the onClick() method later
                final EditText etInput = viewDialog.findViewById(R.id.editTextInput);

                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
                myBuilder.setView(viewDialog);  // Set the view of the dialog
                myBuilder.setTitle("Demo 3-Text Input Dialog");
                myBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Extract the text entered by the user
                        String message = etInput.getText().toString();
                        // Set the text to the TextView
                        tvDemo3.setText(message);
                    }
                });
                myBuilder.setNegativeButton("CANCEL", null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });

        btnEx3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater =
                        (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View viewDialog = inflater.inflate(R.layout.input2, null);

                final EditText etFirst = viewDialog.findViewById(R.id.editTextFirst);
                final EditText etSecond = viewDialog.findViewById(R.id.editTextSecond);

                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
                myBuilder.setView(viewDialog);
                myBuilder.setTitle("Exercise 3");
                myBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String input1 = etFirst.getText().toString();
                        String input2 = etSecond.getText().toString();

                        int num1 = Integer.parseInt(input1);
                        int num2 = Integer.parseInt(input2);

                        int total = num1 + num2;

                        tvEx3.setText("The sum is " + total);
                    }
                });
                myBuilder.setNegativeButton("CANCEL", null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();

            }
        });

        btnDemo4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int thisYear =  calendar.get(Calendar.YEAR);
                int thisMonth = calendar.get(Calendar.MONTH);
                int thisDay = calendar.get(Calendar.DAY_OF_MONTH);

                // Create the Listener to set the date
                DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        tvDemo4.setText("Date: " + dayOfMonth + "/" + (month + 1) + "/" + year);
                    }
                };

                // Create the Date Picker Dialog
                DatePickerDialog myDateDialog = new DatePickerDialog(MainActivity.this,
                        myDateListener, thisYear, thisMonth, thisDay);
                myDateDialog.show();
            }
        });

        btnDemo5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int currentHour = calendar.get(Calendar.HOUR_OF_DAY);
                int currentMinute = calendar.get(Calendar.MINUTE);

                // Create the Listener to set the time
                TimePickerDialog.OnTimeSetListener myTimeListener = new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        tvDemo5.setText("Time: " + hourOfDay + ":" + minute);
                    }
                };

                // Create the Time Picker Dialog
                TimePickerDialog myTimeDialog = new TimePickerDialog(MainActivity.this,
                        myTimeListener, currentHour, currentMinute, false);
                myTimeDialog.show();
            }
        });

    }
}