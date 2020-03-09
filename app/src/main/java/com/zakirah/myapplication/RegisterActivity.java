package com.zakirah.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {

    // declare views
    private EditText mv_email, mv_password, mv_confirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // initialize views
        mv_email = findViewById(R.id.edit_email);
        mv_password = findViewById(R.id.edit_password);
        mv_confirm = findViewById(R.id.edit_confirm);
    }

    public void onClickSignup(View view){
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);

        startActivity(intent);
    }

    public void onClickSignin(View view){
        Intent intent = new Intent(this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        startActivity(intent);
        finish();
    }
}
