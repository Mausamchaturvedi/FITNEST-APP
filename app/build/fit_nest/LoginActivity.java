package com.example.fit_nest;

import android.content.*;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    EditText etUser, etPass;
    Button btnLogin;
    TextView btnSignup;

    protected void onCreate(Bundle b){
        super.onCreate(b);
        setContentView(R.layout.activity_login);

        etUser = findViewById(R.id.etUsername);
        etPass = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnSignup = findViewById(R.id.btnSignup);

        SharedPreferences sp = getSharedPreferences("user",MODE_PRIVATE);

        btnLogin.setOnClickListener(v -> {
            if(etUser.getText().toString().equals(sp.getString("u","")) &&
                    etPass.getText().toString().equals(sp.getString("p",""))){

                startActivity(new Intent(this,MainActivity.class));
            } else {
                Toast.makeText(this,"Invalid Login",Toast.LENGTH_SHORT).show();
            }
        });

        btnSignup.setOnClickListener(v ->
                startActivity(new Intent(this,SignupActivity.class)));
    }
}