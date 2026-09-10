//package com.example.fit_nest;
//
//import android.content.Intent;
//import android.net.Uri;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.ArrayAdapter;
//import android.widget.ListView;
//import android.widget.TextView;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.example.myapplication.HealthGuardActivity;
//import com.google.android.material.bottomsheet.BottomSheetDialog;
//
//public class FitnessActivity extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle b) {
//        super.onCreate(b);
//        setContentView(R.layout.activity_fitness);
//
//        // CHEST
//        findViewById(R.id.chest).setOnClickListener(v ->
//                openSheet("Chest Exercises", chestExercises, chestLinks));
//
//        // BACK
//        findViewById(R.id.back).setOnClickListener(v ->
//                openSheet("Back Exercises", backExercises, backLinks));
//
//        // SHOULDER
//        findViewById(R.id.shoulder).setOnClickListener(v ->
//                openSheet("Shoulder Exercises", shoulderExercises, shoulderLinks));
//
//        // BICEP
//        findViewById(R.id.bicep).setOnClickListener(v ->
//                openSheet("Bicep Exercises", bicepExercises, bicepLinks));
//
//        // TRICEP
//        findViewById(R.id.tricep).setOnClickListener(v ->
//                openSheet("Tricep Exercises", tricepExercises, tricepLinks));
//
//        // LEGS
//        findViewById(R.id.legs).setOnClickListener(v ->
//                openSheet("Legs Exercises", legsExercises, legsLinks));
//
//        // OTHER
//        findViewById(R.id.health).setOnClickListener(v ->
//                startActivity(new Intent(this, HealthGuardActivity.class)));
//
//        findViewById(R.id.reminder).setOnClickListener(v ->
//                startActivity(new Intent(this, ReminderActivity.class)));
//    }
//
//    // 🔥 BOTTOM SHEET FUNCTION
//    void openSheet(String title, String[] exercises, String[] links) {
//
//        BottomSheetDialog dialog = new BottomSheetDialog(this);
//        View view = getLayoutInflater().inflate(R.layout.bottom_sheet, null);
//
//        TextView titleText = view.findViewById(R.id.title);
//        ListView listView = view.findViewById(R.id.exerciseList);
//
//        titleText.setText(title);
//
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(
//                this,
//                android.R.layout.simple_list_item_1,
//                exercises
//        );
//
//        listView.setAdapter(adapter);
//
//        // CLICK → OPEN YOUTUBE
//        listView.setOnItemClickListener((parent, v, position, id) -> {
//            String url = links[position];
//            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
//        });
//
//        dialog.setContentView(view);
//        dialog.show();
//    }
//
//    // 🔥 DATA
//
//    String[] chestExercises = {
//            "Flat Bench Press",
//            "Incline Dumbbell Press",
//            "Chest Press",
//            "Butterfly",
//            "Cable Fly",
//            "Push-Ups"
//    };
//
//    String[] chestLinks = {
//            "https://www.youtube.com/watch?v=rT7DgCr-3pg",
//            "https://www.youtube.com/watch?v=8iPEnn-ltC8",
//            "https://www.youtube.com/watch?v=VmB1G1K7v94",
//            "https://www.youtube.com/watch?v=eozdVDA78K0",
//            "https://www.youtube.com/watch?v=taI4XduLpTk",
//            "https://www.youtube.com/watch?v=_l3ySVKYVJ8"
//    };
//
//    String[] backExercises = {
//            "Pull-Ups",
//            "Deadlift",
//            "Lat Pulldown",
//            "Seated Row",
//            "One-arm Dumbbell",
//            "Hyper Extension"
//    };
//
//    String[] backLinks = {
//            "https://www.youtube.com/watch?v=eGo4IYlbE5g",
//            "https://www.youtube.com/watch?v=ytGaGIn3SjE",
//            "https://www.youtube.com/watch?v=CAwf7n6Luuc",
//            "https://www.youtube.com/watch?v=HJSVR_67OlM",
//            "https://www.youtube.com/watch?v=pYcpY20QaE8",
//            "https://www.youtube.com/watch?v=ph3pddpKzzw"
//    };
//
//    String[] shoulderExercises = {
//            "Overhead Press",
//            "Lateral Raise",
//            "Front Raise",
//            "Upright Rows",
//            "Shrugs"
//    };
//
//    String[] shoulderLinks = {
//            "https://www.youtube.com/watch?v=B-aVuyhvLHU",
//            "https://www.youtube.com/watch?v=3VcKaXpzqRo",
//            "https://www.youtube.com/watch?v=-t7fuZ0KhDA",
//            "https://www.youtube.com/watch?v=IhZLB48kluc",
//            "https://www.youtube.com/watch?v=cJRVVxmytaM"
//    };
//
//    String[] bicepExercises = {
//            "Barbell Curl",
//            "Dumbbell Curl",
//            "Hammer Curl",
//            "Concentration Curl",
//            "Preacher Curl"
//    };
//
//    String[] bicepLinks = {
//            "https://www.youtube.com/watch?v=kwG2ipFRgfo",
//            "https://www.youtube.com/watch?v=ykJmrZ5v0Oo",
//            "https://www.youtube.com/watch?v=zC3nLlEvin4",
//            "https://www.youtube.com/watch?v=soxrZlIl35U",
//            "https://www.youtube.com/watch?v=fIWP-FRFNU0"
//    };
//
//    String[] tricepExercises = {
//            "Dips",
//            "Overhead Extension",
//            "Rope Pushdown",
//            "Close-Grip",
//            "Skull Crusher"
//    };
//
//    String[] tricepLinks = {
//            "https://www.youtube.com/watch?v=2z8JmcrW-As",
//            "https://www.youtube.com/watch?v=nRiJVZDpdL0",
//            "https://www.youtube.com/watch?v=2-LAMcpzODU",
//            "https://www.youtube.com/watch?v=nEF0bv2FW94",
//            "https://www.youtube.com/watch?v=d_KZxkY_0cM"
//    };
//
//    String[] legsExercises = {
//            "Squats",
//            "Lunges",
//            "Leg Press",
//            "Leg Extension",
//            "Leg Curl",
//            "Sumo Squats"
//    };
//
//    String[] legsLinks = {
//            "https://www.youtube.com/watch?v=aclHkVaku9U",
//            "https://www.youtube.com/watch?v=QOVaHwm-Q6U",
//            "https://www.youtube.com/watch?v=IZxyjW7MPJQ",
//            "https://www.youtube.com/watch?v=YyvSfVjQeL0",
//            "https://www.youtube.com/watch?v=1Tq3QdYUuHs",
//            "https://www.youtube.com/watch?v=6xwGFn-J_Q0"
//    };
package com.example.fit_nest;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.fit_nest.R;
import com.example.fit_nest.ReminderActivity;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class FitnessActivity extends AppCompatActivity {

    Button btnChest, btnBack, btnShoulder, btnBicep, btnTricep, btnLegs, fit, btnHealthGuard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fitness);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btnChest = findViewById(R.id.btnChest);
        btnBack = findViewById(R.id.btnBack);
        btnShoulder = findViewById(R.id.btnShoulder);
        btnBicep = findViewById(R.id.btnBicep);
        btnTricep = findViewById(R.id.btnTricep);
        btnLegs = findViewById(R.id.btnLegs);
        fit = findViewById(R.id.btnfit);

        // 🧠 NEW FEATURE BUTTON
        btnHealthGuard = findViewById(R.id.btnHealthGuard);

        btnChest.setOnClickListener(v -> showChest());
        btnBack.setOnClickListener(v -> showBack());
        btnShoulder.setOnClickListener(v -> showShoulder());
        btnBicep.setOnClickListener(v -> showBicep());
        btnTricep.setOnClickListener(v -> showTricep());
        btnLegs.setOnClickListener(v -> showLegs());

        fit.setOnClickListener(view -> {
            Intent i = new Intent(FitnessActivity.this, ReminderActivity.class);
            startActivity(i);
        });

        // 🚑 Health Guard Feature
        btnHealthGuard.setOnClickListener(v -> {
            Intent intent = new Intent(FitnessActivity.this, HealthGuardActivity.class);
            startActivity(intent);
        });
    }

    private void showChest() {
        showExerciseDialog("Chest", new String[]{
                "Flat Bench Press",
                "Incline Dumbbell Press",
                "Chest Press",
                "Butterfly",
                "Cable Fly",
                "Push-Ups"
        }, new String[]{
                "https://youtu.be/rT7DgCr-3pg",
                "https://youtu.be/8iPEnn-ltC8",
                "https://youtu.be/IZxyjW7MPJQ",
                "https://youtu.be/eozdVDA78K0",
                "https://youtu.be/taI4XduLpTk",
                "https://youtu.be/IODxDxX7oi4"
        });
    }

    private void showBack() {
        showExerciseDialog("Back", new String[]{
                "Pull-Ups",
                "Deadlift",
                "Lat Pulldown",
                "Seated Row",
                "One-arm Dumbbell",
                "Hyper Extension"
        }, new String[]{
                "https://youtu.be/eGo4IYlbE5g",
                "https://youtu.be/op9kVnSso6Q",
                "https://youtu.be/CAwf7n6Luuc",
                "https://youtu.be/GZbfZ033f74",
                "https://youtu.be/pYcpY20QaE8",
                "https://youtu.be/ph3pddpKzzw"
        });
    }

    private void showShoulder() {
        showExerciseDialog("Shoulder", new String[]{
                "Overhead Press",
                "Lateral Raise",
                "Front Raise",
                "Upright Rows",
                "Shrugs"
        }, new String[]{
                "https://youtu.be/2yjwXTZQDDI",
                "https://youtu.be/3VcKaXpzqRo",
                "https://youtu.be/-t7fuZ0KhDA",
                "https://youtu.be/IhZLB48kluc",
                "https://youtu.be/cJRVVxmytaM"
        });
    }

    private void showBicep() {
        showExerciseDialog("Bicep", new String[]{
                "Barbell Curl",
                "Dumbbell Curl",
                "Hammer Curl",
                "Concentration Curl",
                "Preacher Curl"
        }, new String[]{
                "https://youtu.be/kwG2ipFRgfo",
                "https://youtu.be/ykJmrZ5v0Oo",
                "https://youtu.be/zC3nLlEvin4",
                "https://youtu.be/soxrZlIl35U",
                "https://youtu.be/fIWP-FRFNU0"
        });
    }

    private void showTricep() {
        showExerciseDialog("Tricep", new String[]{
                "Dips",
                "Overhead Extension",
                "Rope Pushdown",
                "Close-Grip",
                "Skull Crusher"
        }, new String[]{
                "https://youtu.be/2z8JmcrW-As",
                "https://youtu.be/YbX7Wd8jQ-Q",
                "https://youtu.be/2-LAMcpzODU",
                "https://youtu.be/nEF0bv2FW94",
                "https://youtu.be/d_KZxkY_0cM"
        });
    }

    private void showLegs() {
        showExerciseDialog("Legs", new String[]{
                "Squats",
                "Lunges",
                "Leg Press",
                "Leg Extension",
                "Leg Curl",
                "Sumo-Squats"
        }, new String[]{
                "https://youtu.be/aclHkVaku9U",
                "https://youtu.be/QOVaHwm-Q6U",
                "https://youtu.be/IZxyjW7MPJQ",
                "https://youtu.be/YyvSfVjQeL0",
                "https://youtu.be/1Tq3QdYUuHs",
                "https://youtu.be/nbTSPt0gA6M"
        });
    }

    private void showExerciseDialog(String title, String[] exercises, String[] links) {

        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
        View view = getLayoutInflater().inflate(R.layout.bottom_sheet, null);

        TextView tvTitle = view.findViewById(R.id.tvTitle);
        TextView tvExercises = view.findViewById(R.id.tvExercises);

        tvTitle.setText(title + " Exercises");

        StringBuilder builder = new StringBuilder();
        for (String exercise : exercises) {
            builder.append("🎥 ").append(exercise).append("\n\n");
        }

        String message = builder.toString();
        SpannableString spannable = new SpannableString(message);

        int index = 0;

        for (int i = 0; i < exercises.length; i++) {

            String exercise = exercises[i];
            int start = message.indexOf(exercise, index);
            int end = start + exercise.length();
            index = end;

            String url = links[i];

            spannable.setSpan(new ClickableSpan() {
                @Override
                public void onClick(View widget) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    startActivity(intent);
                }

                @Override
                public void updateDrawState(android.text.TextPaint ds) {
                    ds.setUnderlineText(false);
                    ds.setColor(android.graphics.Color.parseColor("#D0B3FF"));
                }
            }, start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }

        tvExercises.setText(spannable);
        tvExercises.setMovementMethod(LinkMovementMethod.getInstance());

        bottomSheetDialog.setContentView(view);
        bottomSheetDialog.show();
    }
}