package com.example.fit_nest;

import android.content.*;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class SignupActivity extends AppCompatActivity {

    protected void onCreate(Bundle b){
        super.onCreate(b);
        setContentView(R.layout.activity_signup);

        EditText u = findViewById(R.id.etNewUsername);
        EditText p = findViewById(R.id.etNewPassword);
        Button btn = findViewById(R.id.btnRegister);

        SharedPreferences sp = getSharedPreferences("user",MODE_PRIVATE);

        btn.setOnClickListener(v -> {
            sp.edit().putString("u",u.getText().toString())
                    .putString("p",p.getText().toString()).apply();

            Toast.makeText(this,"Registered",Toast.LENGTH_SHORT).show();
            finish();
        });
    }
}