//package com.example.fit_nest;
//
//import android.app.NotificationChannel;
//import android.app.NotificationManager;
//import android.content.Context;
//import android.os.Build;
//import android.os.Bundle;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.TextView;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.core.app.NotificationCompat;
//
//import com.example.fit_nest.R;
//
//public class HealthGuardActivity extends AppCompatActivity {
//
//    EditText etAge, etHeight, etWeight, etDuration;
//    Button btnCheck;
//    TextView tvResult;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_health_guard);
//
//        etAge = findViewById(R.id.etAge);
//        etHeight = findViewById(R.id.etHeight);
//        etWeight = findViewById(R.id.etWeight);
//        etDuration = findViewById(R.id.etDuration);
//        btnCheck = findViewById(R.id.btnCheck);
//        tvResult = findViewById(R.id.tvResult);
//
//        btnCheck.setOnClickListener(v -> calculateRisk());
//    }
//
//    private void calculateRisk() {
//
//        if (etAge.getText().toString().isEmpty() ||
//                etHeight.getText().toString().isEmpty() ||
//                etWeight.getText().toString().isEmpty() ||
//                etDuration.getText().toString().isEmpty()) {
//
//            tvResult.setText("Please fill all fields");
//            return;
//        }
//
//        int age = Integer.parseInt(etAge.getText().toString());
//        double height = Double.parseDouble(etHeight.getText().toString()) / 100;
//        double weight = Double.parseDouble(etWeight.getText().toString());
//        int duration = Integer.parseInt(etDuration.getText().toString());
//
//        double bmi = weight / (height * height);
//
//        String result;
//
//        if (bmi > 30 && duration > 20) {
//
//            result = "⚠ HIGH RISK\nBMI: " + String.format("%.1f", bmi) +
//                    "\nLimit treadmill to 10-15 minutes.\nRisk of cardiac stress.";
//
//            sendWarning();
//
//        } else if (bmi > 25) {
//
//            result = "⚠ Overweight\nBMI: " + String.format("%.1f", bmi) +
//                    "\nSafe cardio: 20 minutes.";
//
//        } else {
//
//            result = "✔ SAFE\nBMI: " + String.format("%.1f", bmi) +
//                    "\nWorkout normally.";
//        }
//
//        if (age > 45 && duration > 25) {
//
//            result += "\n⚠ Age risk: Avoid very intense cardio.";
//
//        }
//
//        tvResult.setText(result);
//    }
//
//    private void sendWarning() {
//
//        String channelId = "health_alert";
//
//        NotificationManager manager =
//                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
//
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//
//            NotificationChannel channel =
//                    new NotificationChannel(channelId,
//                            "Health Alert",
//                            NotificationManager.IMPORTANCE_HIGH);
//
//            manager.createNotificationChannel(channel);
//        }
//
//        NotificationCompat.Builder builder =
//                new NotificationCompat.Builder(this, channelId)
//                        .setContentTitle("⚠ Health Risk Warning")
//                        .setContentText("High risk workout detected. Reduce intensity.")
//                        .setSmallIcon(R.drawable.ic_launcher_foreground)
//                        .setPriority(NotificationCompat.PRIORITY_HIGH);
//
//        manager.notify(300, builder.build());
//    }
//}package com.example.fit_nest;
//
//import android.app.NotificationChannel;
//import android.app.NotificationManager;
//import android.content.Context;
//import android.graphics.Color;
//import android.os.Build;
//import android.os.Bundle;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.TextView;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.core.app.NotificationCompat;
//
//public class HealthGuardActivity extends AppCompatActivity {
//
//    EditText etAge, etHeight, etWeight, etDuration;
//    Button btnCheck;
//    TextView tvResult;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_health_guard);
//
//        etAge = findViewById(R.id.etAge);
//        etHeight = findViewById(R.id.etHeight);
//        etWeight = findViewById(R.id.etWeight);
//        etDuration = findViewById(R.id.etDuration);
//
//        btnCheck = findViewById(R.id.btnCheck);
//
//        tvResult = findViewById(R.id.tvResult);
//
//        btnCheck.setOnClickListener(v -> calculateRisk());
//    }
//
//    private void calculateRisk() {
//
//        String ageStr = etAge.getText().toString().trim();
//        String heightStr = etHeight.getText().toString().trim();
//        String weightStr = etWeight.getText().toString().trim();
//        String durationStr = etDuration.getText().toString().trim();
//
//        // VALIDATION
//
//        if (ageStr.isEmpty() ||
//                heightStr.isEmpty() ||
//                weightStr.isEmpty() ||
//                durationStr.isEmpty()) {
//
//            tvResult.setText("⚠ Please fill all fields properly.");
//            tvResult.setTextColor(Color.RED);
//            return;
//        }
//
//        int age = Integer.parseInt(ageStr);
//
//        double height =
//                Double.parseDouble(heightStr) / 100.0;
//
//        double weight =
//                Double.parseDouble(weightStr);
//
//        int duration =
//                Integer.parseInt(durationStr);
//
//        double bmi =
//                weight / (height * height);
//
//        String result = "";
//
//        // BMI STATUS
//
//        if (bmi < 18.5) {
//
//            result += "🟡 UNDERWEIGHT\n\n";
//            result += "BMI: " + String.format("%.1f", bmi);
//            result += "\nYou should increase healthy calorie intake.";
//            result += "\nFocus on strength training and protein diet.";
//
//        }
//
//        else if (bmi >= 18.5 && bmi <= 24.9) {
//
//            result += "🟢 HEALTHY BODY\n\n";
//            result += "BMI: " + String.format("%.1f", bmi);
//            result += "\nYour body condition looks good.";
//            result += "\nContinue regular workouts and balanced diet.";
//
//        }
//
//        else if (bmi >= 25 && bmi <= 29.9) {
//
//            result += "🟠 OVERWEIGHT\n\n";
//            result += "BMI: " + String.format("%.1f", bmi);
//            result += "\nRisk of fat gain and blood pressure.";
//            result += "\nRecommended cardio: 20-30 mins.";
//
//        }
//
//        else {
//
//            result += "🔴 HIGH RISK / OBESE\n\n";
//            result += "BMI: " + String.format("%.1f", bmi);
//            result += "\nPossible cardiac stress risk.";
//            result += "\nAvoid heavy cardio and extreme workouts.";
//            result += "\nConsult fitness trainer or doctor.";
//
//            sendWarning();
//        }
//
//        // AGE RISK
//
//        if (age > 45) {
//
//            result += "\n\n⚠ AGE ALERT";
//            result += "\nHigh intensity training not recommended.";
//
//        }
//
//        // WORKOUT DURATION CHECK
//
//        if (duration > 90) {
//
//            result += "\n\n⚠ LONG WORKOUT WARNING";
//            result += "\nToo much exercise may stress the heart.";
//
//        }
//
//        // SMART AI TIPS
//
//        result += "\n\n💡 AI FITNESS TIPS";
//
//        if (bmi > 25) {
//
//            result += "\n• Drink more water";
//            result += "\n• Avoid junk food";
//            result += "\n• Walk daily 8k steps";
//            result += "\n• Sleep 7-8 hours";
//
//        } else {
//
//            result += "\n• Maintain consistency";
//            result += "\n• Increase protein intake";
//            result += "\n• Continue progressive overload";
//        }
//
//        tvResult.setTextColor(Color.WHITE);
//
//        tvResult.setText(result);
//    }
//
//    private void sendWarning() {
//
//        String channelId = "health_alert";
//
//        NotificationManager manager =
//                (NotificationManager)
//                        getSystemService(Context.NOTIFICATION_SERVICE);
//
//        // ANDROID 8+
//
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//
//            NotificationChannel channel =
//                    new NotificationChannel(
//                            channelId,
//                            "Health Alert",
//                            NotificationManager.IMPORTANCE_HIGH
//                    );
//
//            channel.setDescription("Fitness Risk Alerts");
//
//            manager.createNotificationChannel(channel);
//        }
//
//        NotificationCompat.Builder builder =
//                new NotificationCompat.Builder(this, channelId)
//
//                        .setSmallIcon(R.drawable.ic_launcher_foreground)
//
//                        .setContentTitle("⚠ Health Risk Detected")
//
//                        .setContentText(
//                                "High BMI detected. Reduce workout intensity."
//                        )
//
//                        .setPriority(NotificationCompat.PRIORITY_HIGH)
//
//                        .setAutoCancel(true);
//
//        manager.notify(101, builder.build());
//    }
//}
package com.example.fit_nest;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

public class HealthGuardActivity extends AppCompatActivity {

    EditText etAge, etHeight, etWeight, etDuration;
    Button btnCheck;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_guard);

        etAge = findViewById(R.id.etAge);
        etHeight = findViewById(R.id.etHeight);
        etWeight = findViewById(R.id.etWeight);
        etDuration = findViewById(R.id.etDuration);

        btnCheck = findViewById(R.id.btnCheck);

        tvResult = findViewById(R.id.tvResult);

        btnCheck.setOnClickListener(v -> calculateRisk());
    }

    private void calculateRisk() {

        String ageStr = etAge.getText().toString().trim();
        String heightStr = etHeight.getText().toString().trim();
        String weightStr = etWeight.getText().toString().trim();
        String durationStr = etDuration.getText().toString().trim();

        // VALIDATION

        if (ageStr.isEmpty() ||
                heightStr.isEmpty() ||
                weightStr.isEmpty() ||
                durationStr.isEmpty()) {

            tvResult.setText("⚠ Please fill all fields properly.");
            tvResult.setTextColor(Color.RED);
            return;
        }

        int age = Integer.parseInt(ageStr);

        double height =
                Double.parseDouble(heightStr) / 100.0;

        double weight =
                Double.parseDouble(weightStr);

        int duration =
                Integer.parseInt(durationStr);

        double bmi =
                weight / (height * height);

        String result = "";

        // BMI STATUS

        if (bmi < 18.5) {

            result += "🟡 UNDERWEIGHT\n\n";
            result += "BMI: " + String.format("%.1f", bmi);
            result += "\nYou should increase healthy calorie intake.";
            result += "\nFocus on strength training and protein diet.";

        }

        else if (bmi >= 18.5 && bmi <= 24.9) {

            result += "🟢 HEALTHY BODY\n\n";
            result += "BMI: " + String.format("%.1f", bmi);
            result += "\nYour body condition looks good.";
            result += "\nContinue regular workouts and balanced diet.";

        }

        else if (bmi >= 25 && bmi <= 29.9) {

            result += "🟠 OVERWEIGHT\n\n";
            result += "BMI: " + String.format("%.1f", bmi);
            result += "\nRisk of fat gain and blood pressure.";
            result += "\nRecommended cardio: 20-30 mins.";

        }

        else {

            result += "🔴 HIGH RISK / OBESE\n\n";
            result += "BMI: " + String.format("%.1f", bmi);
            result += "\nPossible cardiac stress risk.";
            result += "\nAvoid heavy cardio and extreme workouts.";
            result += "\nConsult fitness trainer or doctor.";

            sendWarning();
        }

        // AGE RISK

        if (age > 45) {

            result += "\n\n⚠ AGE ALERT";
            result += "\nHigh intensity training not recommended.";

        }

        // WORKOUT DURATION CHECK

        if (duration > 90) {

            result += "\n\n⚠ LONG WORKOUT WARNING";
            result += "\nToo much exercise may stress the heart.";

        }

        // SMART AI TIPS

        result += "\n\n💡 AI FITNESS TIPS";

        if (bmi > 25) {

            result += "\n• Drink more water";
            result += "\n• Avoid junk food";
            result += "\n• Walk daily 8k steps";
            result += "\n• Sleep 7-8 hours";

        } else {

            result += "\n• Maintain consistency";
            result += "\n• Increase protein intake";
            result += "\n• Continue progressive overload";
        }

        tvResult.setTextColor(Color.WHITE);

        tvResult.setText(result);
    }

    private void sendWarning() {

        String channelId = "health_alert";

        NotificationManager manager =
                (NotificationManager)
                        getSystemService(Context.NOTIFICATION_SERVICE);

        // ANDROID 8+

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            NotificationChannel channel =
                    new NotificationChannel(
                            channelId,
                            "Health Alert",
                            NotificationManager.IMPORTANCE_HIGH
                    );

            channel.setDescription("Fitness Risk Alerts");

            manager.createNotificationChannel(channel);
        }

        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(this, channelId)

                        .setSmallIcon(R.drawable.ic_launcher_foreground)

                        .setContentTitle("⚠ Health Risk Detected")

                        .setContentText(
                                "High BMI detected. Reduce workout intensity."
                        )

                        .setPriority(NotificationCompat.PRIORITY_HIGH)

                        .setAutoCancel(true);

        manager.notify(101, builder.build());
    }
}
