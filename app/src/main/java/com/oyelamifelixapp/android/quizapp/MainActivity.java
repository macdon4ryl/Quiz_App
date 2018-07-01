package com.oyelamifelixapp.android.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText userna;
    String newUser;
    int scores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.newUser = getIntent().getStringExtra("USERNAME");
        this.scores = getIntent().getIntExtra("SCORE", 0);
        setContentView(R.layout.activity_main);
    }

    // button that enables user to take the quiz
    public void take_quiz(View view) {
        this.userna = findViewById(R.id.user_name);
        newUser = this.userna.getText().toString();
        //  checks if the user inputs name before taking quiz
        if (newUser.trim().isEmpty()) {
            Toast.makeText(getApplication(), "Name is required!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplication(), "Welcome " + newUser, Toast.LENGTH_SHORT).show();
            Intent quizPage = new Intent(MainActivity.this, QuizActivity.class);
            quizPage.putExtra("USERNAME", newUser);
            quizPage.putExtra("SCORE", this.scores);
            startActivity(quizPage);
        }
    }

}