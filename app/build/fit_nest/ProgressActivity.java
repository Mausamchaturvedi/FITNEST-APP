package com.example.fit_nest;

import android.app.AlertDialog;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class ProgressActivity extends AppCompatActivity {

    int currentWeight = 75; // default

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);

        Button weight = findViewById(R.id.btnWeightProgress);
        Button workout = findViewById(R.id.btnWorkoutProgress);
        Button diet = findViewById(R.id.btnDietProgress);
        Button add = findViewById(R.id.btnAddWeight);

        // WEIGHT PROGRESS
        weight.setOnClickListener(v -> {
            new AlertDialog.Builder(this)
                    .setTitle("Weight Progress")
                    .setMessage(
                            "• Initial Weight: 70kg\n" +
                                    "• Current Weight: " + currentWeight + "kg\n" +
                                    "• Goal Weight: 80kg"
                    )
                    .setPositiveButton("OK", null)
                    .show();
        });

        // WORKOUT PROGRESS
        workout.setOnClickListener(v -> {
            new AlertDialog.Builder(this)
                    .setTitle("Workout Progress")
                    .setMessage(
                            "• Started with 30 min/day\n" +
                                    "• Now doing 60 min/day\n" +
                                    "• Goal: 90 min/day"
                    )
                    .setPositiveButton("OK", null)
                    .show();
        });

        // DIET PROGRESS
        diet.setOnClickListener(v -> {
            new AlertDialog.Builder(this)
                    .setTitle("Diet Progress")
                    .setMessage(
                            "• Started High Calorie Diet\n" +
                                    "• Maintaining Protein Intake\n" +
                                    "• Tracking Calories Daily"
                    )
                    .setPositiveButton("OK", null)
                    .show();
        });

        // ADD WEIGHT
        add.setOnClickListener(v -> showInputDialog());
    }

    void showInputDialog() {
        EditText input = new EditText(this);
        input.setHint("Enter Your Current Weight (kg)");

        new AlertDialog.Builder(this)
                .setTitle("Enter Your Current Weight (kg)")
                .setView(input)
                .setNegativeButton("Cancel", null)
                .setPositiveButton("OK", (dialog, which) -> {

                    String w = input.getText().toString();

                    if (!w.isEmpty()) {
                        currentWeight = Integer.parseInt(w);
                        Toast.makeText(this, "Updated!", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(this, "Enter weight!", Toast.LENGTH_SHORT).show();
                    }
                })
                .show();
    }
}