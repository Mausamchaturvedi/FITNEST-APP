//package com.example.fit_nest;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.widget.Button;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.google.android.material.bottomnavigation.BottomNavigationView;
//
//public class MainActivity extends AppCompatActivity {
//
//    BottomNavigationView bottomNav;
//    Button btnAI;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        // INIT
//        bottomNav = findViewById(R.id.bottomNav);
//        btnAI = findViewById(R.id.btnAI);
//
//        // AI BUTTON CLICK
//
//        btnAI.setOnClickListener(v -> {
//
//            Intent intent = new Intent(MainActivity.this, AICoachActivity.class);
//            startActivity(intent);
//
//        });
//
//        // SELECTED TAB
//
//        bottomNav.setSelectedItemId(R.id.navHome);
//
//        // BOTTOM NAVIGATION
//
//        bottomNav.setOnItemSelectedListener(item -> {
//
//            int id = item.getItemId();
//
//            if (id == R.id.navHome) {
//
//                return true;
//
//            } else if (id == R.id.navFitness) {
//
//                startActivity(new Intent(MainActivity.this, FitnessActivity.class));
//                return true;
//
//            } else if (id == R.id.navDiet) {
//
//                startActivity(new Intent(MainActivity.this, DietActivity.class));
//                return true;
//
//            } else if (id == R.id.navProgress) {
//
//                startActivity(new Intent(MainActivity.this, ProgressActivity.class));
//                return true;
//
//            } else if (id == R.id.navBell) {
//
//                startActivity(new Intent(MainActivity.this, ReminderActivity.class));
//                return true;
//            }
//
//            return false;
//        });
//    }
//}
package com.example.fit_nest;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNav;
    Button btnAI;
    ImageView btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // INIT VIEWS

        bottomNav = findViewById(R.id.bottomNav);
        btnAI = findViewById(R.id.btnAI);
        btnLogout = findViewById(R.id.btnLogout);

        // AI BUTTON

        btnAI.setOnClickListener(v -> {

            Intent intent =
                    new Intent(
                            MainActivity.this,
                            AICoachActivity.class
                    );

            startActivity(intent);

        });

        // LOGOUT BUTTON

        btnLogout.setOnClickListener(v -> {

            Toast.makeText(
                    MainActivity.this,
                    "Logged Out Successfully",
                    Toast.LENGTH_SHORT
            ).show();

            Intent intent =
                    new Intent(
                            MainActivity.this,
                            LoginActivity.class
                    );

            startActivity(intent);

            finish();

        });

        // SELECTED TAB

        bottomNav.setSelectedItemId(R.id.navHome);

        // BOTTOM NAVIGATION

        bottomNav.setOnItemSelectedListener(item -> {

            int id = item.getItemId();

            if (id == R.id.navHome) {

                return true;

            }

            else if (id == R.id.navFitness) {

                startActivity(
                        new Intent(
                                MainActivity.this,
                                FitnessActivity.class
                        )
                );

                overridePendingTransition(
                        android.R.anim.fade_in,
                        android.R.anim.fade_out
                );

                return true;

            }

            else if (id == R.id.navDiet) {

                startActivity(
                        new Intent(
                                MainActivity.this,
                                DietActivity.class
                        )
                );

                overridePendingTransition(
                        android.R.anim.fade_in,
                        android.R.anim.fade_out
                );

                return true;

            }

            else if (id == R.id.navProgress) {

                startActivity(
                        new Intent(
                                MainActivity.this,
                                ProgressActivity.class
                        )
                );

                overridePendingTransition(
                        android.R.anim.fade_in,
                        android.R.anim.fade_out
                );

                return true;

            }

            else if (id == R.id.navBell) {

                startActivity(
                        new Intent(
                                MainActivity.this,
                                ReminderActivity.class
                        )
                );

                overridePendingTransition(
                        android.R.anim.fade_in,
                        android.R.anim.fade_out
                );

                return true;

            }

            return false;
        });
    }
}