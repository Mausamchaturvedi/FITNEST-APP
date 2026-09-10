package com.example.fit_nest;

import android.app.AlertDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DietActivity extends AppCompatActivity {

    String selectedType = "gain";

    Button btnWeightGain, btnWeightLoss,
            btnMaintenance, btnGetPlan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet);

        // INIT BUTTONS

        btnWeightGain = findViewById(R.id.btnWeightGain);
        btnWeightLoss = findViewById(R.id.btnWeightLoss);
        btnMaintenance = findViewById(R.id.btnMaintenance);
        btnGetPlan = findViewById(R.id.btnGetPlan);

        // WEIGHT GAIN

        btnWeightGain.setOnClickListener(v -> {

            selectedType = "gain";

            Toast.makeText(
                    this,
                    "💪 Weight Gain Selected",
                    Toast.LENGTH_SHORT
            ).show();
        });

        // WEIGHT LOSS

        btnWeightLoss.setOnClickListener(v -> {

            selectedType = "loss";

            Toast.makeText(
                    this,
                    "🔥 Weight Loss Selected",
                    Toast.LENGTH_SHORT
            ).show();
        });

        // MAINTENANCE

        btnMaintenance.setOnClickListener(v -> {

            selectedType = "maintain";

            Toast.makeText(
                    this,
                    "⚖ Maintenance Selected",
                    Toast.LENGTH_SHORT
            ).show();
        });

        // GET PLAN BUTTON

        btnGetPlan.setOnClickListener(v -> {

            openWeightDialog();

        });
    }

    // WEIGHT INPUT DIALOG

    private void openWeightDialog() {

        EditText editText = new EditText(this);

        editText.setHint("Enter Weight in KG");

        AlertDialog.Builder builder =
                new AlertDialog.Builder(this);

        builder.setTitle("AI Diet Generator 🍽");

        builder.setView(editText);

        builder.setPositiveButton("Generate", (dialog, which) -> {

            String value =
                    editText.getText().toString().trim();

            if (value.isEmpty()) {

                Toast.makeText(
                        this,
                        "Please enter weight",
                        Toast.LENGTH_SHORT
                ).show();

                return;
            }

            int weight = Integer.parseInt(value);

            showDietPlan(weight);

        });

        builder.setNegativeButton("Cancel", null);

        builder.show();
    }

    // DYNAMIC AI DIET PLAN

    private void showDietPlan(int weight) {

        String result = "";

        // ================= WEIGHT GAIN =================

        if (selectedType.equals("gain")) {

            if (weight < 45) {

                result =
                        "💪 EXTREME MASS GAIN PLAN\n\n" +

                                "🍳 Breakfast:\n" +
                                "4 Eggs + Peanut Butter + Banana Shake\n\n" +

                                "🍗 Lunch:\n" +
                                "2 Plates Rice + Chicken + Paneer\n\n" +

                                "🥤 Evening:\n" +
                                "Mass Gainer + Dry Fruits\n\n" +

                                "🍛 Dinner:\n" +
                                "6 Roti + Dal + Paneer\n\n" +

                                "🔥 Calories: 3200+";
            }

            else if (weight < 60) {

                result =
                        "💪 LEAN BULK PLAN\n\n" +

                                "🍳 Breakfast:\n" +
                                "3 Eggs + Oats + Milk\n\n" +

                                "🍗 Lunch:\n" +
                                "Rice + Chicken + Salad\n\n" +

                                "🥤 Evening:\n" +
                                "Protein Shake + Banana\n\n" +

                                "🍛 Dinner:\n" +
                                "Roti + Paneer + Vegetables\n\n" +

                                "🔥 Calories: 2800";
            }

            else {

                result =
                        "💪 CLEAN BULK PLAN\n\n" +

                                "🍳 Breakfast:\n" +
                                "Oats + Eggs + Fruits\n\n" +

                                "🍗 Lunch:\n" +
                                "Chicken + Rice + Veggies\n\n" +

                                "🥤 Evening:\n" +
                                "Protein Shake\n\n" +

                                "🍛 Dinner:\n" +
                                "Balanced Protein Meal\n\n" +

                                "🔥 Calories: 2500";
            }
        }

        // ================= WEIGHT LOSS =================

        else if (selectedType.equals("loss")) {

            if (weight > 100) {

                result =
                        "🔥 EXTREME FAT LOSS PLAN\n\n" +

                                "🥗 Breakfast:\n" +
                                "Green Tea + Oats\n\n" +

                                "🍲 Lunch:\n" +
                                "Brown Rice + Salad\n\n" +

                                "🥜 Snack:\n" +
                                "Almonds + Fruits\n\n" +

                                "🥦 Dinner:\n" +
                                "Soup + Boiled Veggies\n\n" +

                                "🏃 Cardio:\n60 Minutes Daily\n\n" +

                                "🔥 Calories: 1500";
            }

            else if (weight > 80) {

                result =
                        "🔥 FAT CUTTING PLAN\n\n" +

                                "🥗 Breakfast:\n" +
                                "Boiled Eggs + Green Tea\n\n" +

                                "🍲 Lunch:\n" +
                                "Chicken + Veggies\n\n" +

                                "🥜 Snack:\n" +
                                "Fruits + Black Coffee\n\n" +

                                "🥦 Dinner:\n" +
                                "Light Protein Meal\n\n" +

                                "🏃 Cardio:\n45 Minutes Daily\n\n" +

                                "🔥 Calories: 1800";
            }

            else {

                result =
                        "🔥 LEAN CUT PLAN\n\n" +

                                "🥗 Breakfast:\n" +
                                "Oats + Fruits\n\n" +

                                "🍲 Lunch:\n" +
                                "Rice + Chicken\n\n" +

                                "🥜 Snack:\n" +
                                "Green Tea\n\n" +

                                "🥦 Dinner:\n" +
                                "Salad + Soup\n\n" +

                                "🔥 Calories: 2000";
            }
        }

        // ================= MAINTENANCE =================

        else {

            if (weight < 60) {

                result =
                        "⚖ LEAN MAINTENANCE PLAN\n\n" +

                                "🥚 Breakfast:\n" +
                                "Milk + Banana + Oats\n\n" +

                                "🍗 Lunch:\n" +
                                "Rice + Chicken\n\n" +

                                "🥤 Evening:\n" +
                                "Protein Shake\n\n" +

                                "🍛 Dinner:\n" +
                                "Roti + Veggies\n\n" +

                                "🔥 Calories: 2300";
            }

            else {

                result =
                        "⚖ BALANCED MAINTENANCE PLAN\n\n" +

                                "🥚 Breakfast:\n" +
                                "Eggs + Oats\n\n" +

                                "🍗 Lunch:\n" +
                                "Balanced Meal\n\n" +

                                "🥤 Evening:\n" +
                                "Dry Fruits\n\n" +

                                "🍛 Dinner:\n" +
                                "Protein + Salad\n\n" +

                                "🔥 Calories: 2500";
            }
        }

        // SHOW RESULT

        AlertDialog.Builder dialog =
                new AlertDialog.Builder(this);

        dialog.setTitle("Your AI Diet Plan 🍽");

        dialog.setMessage(result);

        dialog.setPositiveButton(
                "Awesome 💪",
                null
        );

        dialog.show();
    }
}