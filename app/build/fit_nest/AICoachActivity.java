////package com.example.fit_nest;
////
////import android.os.Bundle;
////import android.view.View;
////import android.widget.*;
////import androidx.appcompat.app.AppCompatActivity;
////
////public class AICoachActivity extends AppCompatActivity {
////
////    EditText etMessage;
////    Button btnSend;
////    LinearLayout chatLayout;
////
////    @Override
////    protected void onCreate(Bundle savedInstanceState) {
////        super.onCreate(savedInstanceState);
////        setContentView(R.layout.activity_ai_coach);
////
////        etMessage = findViewById(R.id.etMessage);
////        btnSend = findViewById(R.id.btnSend);
////        chatLayout = findViewById(R.id.chatLayout);
////
////        btnSend.setOnClickListener(v -> {
////            String msg = etMessage.getText().toString().trim();
////
////            if(msg.isEmpty()){
////                Toast.makeText(this, "Enter message", Toast.LENGTH_SHORT).show();
////                return;
////            }
////
////            addUserMessage(msg);
////            addBotReply(msg);
////
////            etMessage.setText("");
////        });
////    }
////
////    // USER MESSAGE
////    void addUserMessage(String text){
////        TextView tv = new TextView(this);
////        tv.setText("You: " + text);
////        tv.setTextColor(getResources().getColor(android.R.color.white));
////        tv.setPadding(10,10,10,10);
////
////        chatLayout.addView(tv);
////    }
////
////    // BOT REPLY (SIMPLE AI LOGIC)
////    void addBotReply(String msg){
////        TextView tv = new TextView(this);
////        tv.setTextColor(getResources().getColor(android.R.color.holo_purple));
////
////        String reply;
////
////        msg = msg.toLowerCase();
////
////        if(msg.contains("diet")){
////            reply = "Eat high protein foods like eggs, chicken, paneer.";
////        }
////        else if(msg.contains("weight loss")){
////            reply = "Do cardio + calorie deficit diet.";
////        }
////        else if(msg.contains("muscle")){
////            reply = "Focus on strength training + protein intake.";
////        }
////        else{
////            reply = "Stay consistent 💪";
////        }
////
////        tv.setText("AI: " + reply);
////        tv.setPadding(10,10,10,10);
////
////        chatLayout.addView(tv);
////    }
////}
//package com.example.fit_nest;
//
//import android.os.Bundle;
//import android.os.Handler;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.ScrollView;
//import android.widget.TextView;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import java.util.Locale;
//
//public class AICoachActivity extends AppCompatActivity {
//
//    EditText etMessage;
//    Button btnSend;
//    TextView tvResponse;
//    ScrollView scrollView;
//
//    int rememberedWeight = -1;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_ai_coach);
//
//        etMessage = findViewById(R.id.etMessage);
//        btnSend = findViewById(R.id.btnSend);
//        tvResponse = findViewById(R.id.tvResponse);
//        scrollView = findViewById(R.id.scrollView);
//
//        btnSend.setOnClickListener(v -> {
//
//            String question = etMessage.getText().toString().trim();
//            if (question.isEmpty()) return;
//
//            appendMessage("You", question);
//            etMessage.setText("");
//
//            generateAI(question);
//        });
//    }
//
//    // ================= MAIN AI ENGINE =================
//
//    private void generateAI(String question) {
//
//        appendMessage("AI", "Thinking... 🤔");
//
//        new Handler().postDelayed(() -> {
//
//            String q = question.toLowerCase(Locale.ROOT);
//            String reply;
//
//            int weight = extractNumber(q);
//
//            if (weight > 0) {
//                rememberedWeight = weight;
//            } else if (rememberedWeight > 0) {
//                weight = rememberedWeight;
//            }
//
//            // ===== GREETING =====
//            if (q.contains("hi") || q.contains("hello")) {
//
//                reply = "Hey Champ 💪\n"
//                        + "I can help you with:\n"
//                        + "• Detailed diet plans\n"
//                        + "• Workout routines\n"
//                        + "• BMI calculation\n\n"
//                        + "Try: suggest diet for 70kg";
//            }
//
//            // ===== BMI =====
//            else if (q.contains("bmi")) {
//
//                reply = "To calculate BMI, type like:\n"
//                        + "bmi 70kg 170cm";
//            }
//
//            // ===== DIET =====
//            else if (q.contains("diet")) {
//
//                if (weight <= 0) {
//                    reply = "Please tell me your weight 🙂\nExample: suggest diet for 65kg";
//                }
//
//                else if (weight < 60) {
//
//                    reply = "🍽 Diet Plan for " + weight + "kg (Weight Gain):\n\n"
//                            + "🌅 Morning: Milk + Banana + Peanut Butter\n"
//                            + "🍳 Breakfast: Oats + Eggs / Paratha\n"
//                            + "🍚 Lunch: Rice + Chicken/Panner + Veggies\n"
//                            + "🥤 Evening: Smoothie + Dry Fruits\n"
//                            + "🥗 Dinner: Roti + Sabzi + Curd\n"
//                            + "💧 Water: 3 Litres daily";
//                }
//
//                else if (weight <= 75) {
//
//                    reply = "🍽 Diet Plan for " + weight + "kg (Maintenance):\n\n"
//                            + "🌅 Morning: Warm water + soaked almonds\n"
//                            + "🥣 Breakfast: Oats / Fruits / Eggs\n"
//                            + "🍛 Lunch: Roti + Dal + Sabzi\n"
//                            + "🥜 Evening: Nuts + Green Tea\n"
//                            + "🥗 Dinner: Light meal (protein based)\n"
//                            + "🚶 Stay active daily";
//                }
//
//                else {
//
//                    reply = "🍽 Diet Plan for " + weight + "kg (Weight Loss):\n\n"
//                            + "🌅 Morning: Warm water + Lemon\n"
//                            + "🥣 Breakfast: Fruits / Oats\n"
//                            + "🍛 Lunch: Roti + Sabzi (low oil)\n"
//                            + "🍵 Evening: Green Tea\n"
//                            + "🥗 Dinner: Soup / Salad\n"
//                            + "❌ Avoid sugar & junk food";
//                }
//
//                reply += "\n\nDo you want workout plan also? 💪";
//            }
//
//            // ===== WORKOUT =====
//            else if (q.contains("workout") || q.contains("gym") || q.contains("exercise")) {
//
//                if (weight <= 0) {
//                    reply = "Please mention your weight 🙂\nExample: suggest workout for 70kg";
//                }
//
//                else if (weight < 60) {
//
//                    reply = "🏋️ Workout Plan for " + weight + "kg (Muscle Gain):\n\n"
//                            + "Day 1: Chest + Triceps\n"
//                            + "Day 2: Back + Biceps\n"
//                            + "Day 3: Legs\n"
//                            + "Progressive overload training\n"
//                            + "8 hours proper sleep 😴";
//                }
//
//                else if (weight <= 75) {
//
//                    reply = "🏋️ Workout Plan for " + weight + "kg (Fitness):\n\n"
//                            + "Push-ups – 3 sets\n"
//                            + "Squats – 3 sets\n"
//                            + "Plank – 3 sets\n"
//                            + "Cardio – 20 mins\n"
//                            + "1 Rest Day";
//                }
//
//                else {
//
//                    reply = "🔥 Workout Plan for " + weight + "kg (Fat Loss):\n\n"
//                            + "Cardio – 30 mins\n"
//                            + "HIIT Training\n"
//                            + "Jumping Jacks\n"
//                            + "Planks + Core\n"
//                            + "Light weights\n"
//                            + "Calorie deficit";
//                }
//            }
//
//            // ===== HELP =====
//            else if (q.contains("help")) {
//
//                reply = "You can ask me:\n"
//                        + "• suggest diet for 70kg\n"
//                        + "• suggest workout for 80kg\n"
//                        + "• bmi 70kg 170cm";
//            }
//
//            // ===== DEFAULT =====
//            else {
//
//                reply = "I didn’t understand 🤔\n"
//                        + "Try asking:\n"
//                        + "suggest diet for 60kg\n"
//                        + "suggest workout for 80kg";
//            }
//
//            appendMessage("AI", reply + "\n\n💡 Tip: Consistency beats intensity.");
//
//        }, 1200);
//    }
//
//    // ================= CHAT FORMAT =================
//
//    private void appendMessage(String sender, String message) {
//
//        tvResponse.append("\n" + sender + ": " + message + "\n");
//        scrollView.post(() -> scrollView.fullScroll(View.FOCUS_DOWN));
//    }
//
//    // ================= HELPER =================
//
//    private int extractNumber(String text) {
//
//        text = text.replaceAll("[^0-9 ]", " ");
//        String[] parts = text.split(" ");
//
//        for (String part : parts) {
//            if (!part.isEmpty()) {
//                try {
//                    return Integer.parseInt(part);
//                } catch (Exception ignored) {}
//            }
//        }
//        return -1;
//    }
package com.example.fit_nest;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class AICoachActivity extends AppCompatActivity {

    EditText etMessage;
    Button btnSend;
    LinearLayout chatLayout;
    ScrollView scrollView;

    String userName = "";
    String lastTopic = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ai_coach);

        etMessage = findViewById(R.id.etMessage);
        btnSend = findViewById(R.id.btnSend);
        chatLayout = findViewById(R.id.chatLayout);
        scrollView = findViewById(R.id.scrollView);

        btnSend.setOnClickListener(v -> sendMessage());

        // WELCOME MESSAGE

        addMessage(
                "👋 Hello! I am your AI Fitness Coach.\nAsk me anything about workout, diet or fitness 💪",
                false
        );
    }

    // SEND MESSAGE

    private void sendMessage() {

        String msg =
                etMessage.getText().toString().trim();

        if (msg.isEmpty()) return;

        // USER MESSAGE

        addMessage(msg, true);

        etMessage.setText("");

        // TYPING EFFECT

        TextView typing = addTypingBubble();

        new Handler().postDelayed(() -> {

            chatLayout.removeView(typing);

            String reply = getAIResponse(msg);

            addMessage(reply, false);

            scrollView.post(() ->
                    scrollView.fullScroll(View.FOCUS_DOWN));

        }, 1200);
    }

    // ADD CHAT BUBBLE

    private void addMessage(String text, boolean isUser) {

        TextView tv = new TextView(this);

        tv.setText(text);

        tv.setTextColor(Color.WHITE);

        tv.setTextSize(15);

        tv.setPadding(30, 20, 30, 20);

        LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );

        params.setMargins(12, 12, 12, 12);

        if (isUser) {

            tv.setBackgroundResource(R.drawable.bg_user_msg);

            params.gravity = Gravity.END;

        } else {

            tv.setBackgroundResource(R.drawable.bg_ai_msg);

            params.gravity = Gravity.START;
        }

        tv.setLayoutParams(params);

        chatLayout.addView(tv);

        scrollView.post(() ->
                scrollView.fullScroll(View.FOCUS_DOWN));
    }

    // TYPING ANIMATION

    private TextView addTypingBubble() {

        TextView tv = new TextView(this);

        tv.setText("Typing...");

        tv.setTextColor(Color.LTGRAY);

        tv.setPadding(25, 15, 25, 15);

        tv.setBackgroundResource(R.drawable.bg_ai_msg);

        LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );

        params.gravity = Gravity.START;

        params.setMargins(12, 12, 12, 12);

        tv.setLayoutParams(params);

        chatLayout.addView(tv);

        return tv;
    }

    // AI ENGINE

    private String getAIResponse(String msg) {

        msg = msg.toLowerCase().trim();

        // NAME

        if (msg.startsWith("my name is")) {

            userName =
                    msg.replace("my name is", "").trim();

            return "Nice to meet you " + userName + " 💪";
        }

        if (msg.startsWith("i am")) {

            userName =
                    msg.replace("i am", "").trim();

            return "Great " + userName + " 🔥 Let's transform your body.";
        }

        // GREETING

        if (msg.contains("hi") ||
                msg.contains("hello") ||
                msg.contains("hey") ||
                msg.contains("namaste")) {

            return "Hey " +
                    (userName.isEmpty() ? "bro" : userName)
                    + " 👋";
        }

        // FAT LOSS

        if (msg.contains("fat") ||
                msg.contains("weight loss") ||
                msg.contains("motapa") ||
                msg.contains("mota")) {

            lastTopic = "fatloss";

            return "🔥 Fat Loss Tips:\n\n" +
                    "• Cardio daily\n" +
                    "• Avoid sugar\n" +
                    "• High protein diet\n" +
                    "• Walk 8k steps\n" +
                    "• Stay in calorie deficit";
        }

        // BULK / GAIN

        if (msg.contains("bulk") ||
                msg.contains("weight gain") ||
                msg.contains("muscle gain") ||
                msg.contains("skinny") ||
                msg.contains("patla")) {

            lastTopic = "bulk";

            return "💪 Muscle Gain Tips:\n\n" +
                    "• Calorie surplus\n" +
                    "• Heavy workout\n" +
                    "• Protein intake\n" +
                    "• Peanut butter\n" +
                    "• Banana shake";
        }

        // CHEST

        if (msg.contains("chest")) {

            lastTopic = "chest";

            return "🏋 Chest Workout:\n\n" +
                    "• Bench Press\n" +
                    "• Incline Press\n" +
                    "• Pushups\n" +
                    "• Cable Fly";
        }

        // BICEPS

        if (msg.contains("bicep") ||
                msg.contains("arm")) {

            return "💪 Biceps Workout:\n\n" +
                    "• Barbell Curl\n" +
                    "• Hammer Curl\n" +
                    "• Concentration Curl";
        }

        // TRICEPS

        if (msg.contains("tricep")) {

            return "🔥 Triceps Workout:\n\n" +
                    "• Dips\n" +
                    "• Rope Pushdown\n" +
                    "• Skull Crushers";
        }

        // BACK

        if (msg.contains("back")) {

            return "🏋 Back Workout:\n\n" +
                    "• Pullups\n" +
                    "• Deadlift\n" +
                    "• Lat Pulldown";
        }

        // LEGS

        if (msg.contains("leg")) {

            return "🦵 Leg Workout:\n\n" +
                    "• Squats\n" +
                    "• Lunges\n" +
                    "• Leg Press\n" +
                    "• Calf Raises";
        }

        // ABS

        if (msg.contains("abs") ||
                msg.contains("six pack")) {

            return "🔥 Abs Guide:\n\n" +
                    "• Crunches\n" +
                    "• Plank\n" +
                    "• Leg Raises\n" +
                    "• Calorie deficit";
        }

        // DIET

        if (msg.contains("diet") ||
                msg.contains("food") ||
                msg.contains("khana")) {

            lastTopic = "diet";

            return "🥗 Healthy Diet:\n\n" +
                    "• Eggs\n" +
                    "• Chicken\n" +
                    "• Rice\n" +
                    "• Fruits\n" +
                    "• Dry fruits";
        }

        // PROTEIN

        if (msg.contains("protein")) {

            return "🍗 Protein Sources:\n\n" +
                    "• Eggs\n" +
                    "• Paneer\n" +
                    "• Chicken\n" +
                    "• Milk\n" +
                    "• Whey Protein";
        }

        // WATER

        if (msg.contains("water")) {

            return "💧 Drink at least 3-4 litres water daily.";
        }

        // CARDIO

        if (msg.contains("cardio") ||
                msg.contains("running") ||
                msg.contains("treadmill")) {

            return "🏃 Cardio improves heart health and burns calories 🔥";
        }

        // SLEEP

        if (msg.contains("sleep")) {

            return "😴 Sleep 7-8 hours daily for recovery and muscle growth.";
        }

        // HEART

        if (msg.contains("heart") ||
                msg.contains("cardiac")) {

            return "❤️ Avoid overtraining if you feel chest pain or dizziness.";
        }

        // BMI

        if (msg.contains("bmi")) {

            return "📊 BMI Formula:\n\nWeight / (Height × Height)";
        }

        // MOTIVATION

        if (msg.contains("motivation") ||
                msg.contains("sad") ||
                msg.contains("depressed")) {

            String[] motivation = {

                    "🔥 No pain no gain.",
                    "💪 Stay disciplined.",
                    "🚀 Small progress is still progress.",
                    "🏋 Winners never quit.",
                    "⚡ Push yourself daily."
            };

            return motivation[
                    new Random().nextInt(motivation.length)
                    ];
        }

        // MORE FOLLOW UP

        if (msg.contains("more")) {

            if (lastTopic.equals("fatloss")) {

                return "🔥 More Fat Loss Tips:\n\n" +
                        "• Avoid cold drinks\n" +
                        "• Track calories\n" +
                        "• Increase steps";
            }

            if (lastTopic.equals("bulk")) {

                return "💪 More Bulk Tips:\n\n" +
                        "• Increase calories slowly\n" +
                        "• Train heavy\n" +
                        "• Sleep properly";
            }

            if (lastTopic.equals("diet")) {

                return "🥗 Extra Diet Tips:\n\n" +
                        "• Eat every 3 hours\n" +
                        "• Avoid junk food\n" +
                        "• Drink water";
            }
        }

        // DEFAULT REPLIES

        String[] fallback = {

                "🤖 Ask me about workout, diet or fitness 💪",

                "🔥 I can help with chest, abs, cardio & fat loss.",

                "🏋 Tell me your fitness goal.",

                "💪 Ask in Hindi or English 😎"
        };

        return fallback[
                new Random().nextInt(fallback.length)
                ];
    }
}