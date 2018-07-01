package com.oyelamifelixapp.android.quizapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class QuizTwoActivity extends MainActivity {

    String newUser;
    int scores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.newUser = getIntent().getStringExtra("USERNAME");
        this.scores = getIntent().getIntExtra("SCORE", 0);
        setContentView(R.layout.activity_quiz_two);
    }

    public void submit_quiz(View view) {

        try {

            String answerSev = "Android Debug Bridge";
            EditText questionSeven = findViewById(R.id.question_seven_answer);
            String answerSeven = questionSeven.getText().toString().trim();

            CheckBox questionEighta = findViewById(R.id.answer_question_eight_a);
            boolean answerEighta = questionEighta.isChecked();

            CheckBox questionEightb = findViewById(R.id.answer_question_eight_b);
            boolean answerEightb = questionEightb.isChecked();

            CheckBox questionEightc = findViewById(R.id.answer_question_eight_c);
            boolean answerEightc = questionEightc.isChecked();

            CheckBox questionEightd = findViewById(R.id.answer_question_eight_d);
            boolean answerEightd = questionEightd.isChecked();

            String answerNin = "Software Development Kit";
            EditText questionNine = findViewById(R.id.answer_question_nine);
            String answerNine = questionNine.getText().toString().trim();

            String answertn = "Android Virtual Device";
            EditText questionTen = findViewById(R.id.answer_question_ten);
            String answerTen = questionTen.getText().toString();

            if (answerSeven.equalsIgnoreCase(answerSev)) {
                scores += 1;

            }

            if (!answerEightc && !answerEightd && answerEighta && answerEightb) {
                scores += 1;
            }
            if (answerNine.equalsIgnoreCase(answerNin)) {
                scores += 1;

            }
            if (answerTen.equalsIgnoreCase(answertn)) {
                scores += 1;
            }
            if (scores > 0) {
                Toast message = Toast.makeText(getApplicationContext(), this.newUser + "" + " you have scored " + this.scores + " points in this quiz", Toast.LENGTH_LONG);
                message.show();
                AlertDialog.Builder builder = new AlertDialog.Builder(QuizTwoActivity.this);
                builder.setMessage("Thank you for taking this quiz!" + "\n" + "\n" + "YOU SCORED: " + this.scores + " OUT OF 10")
                        .setPositiveButton("OKAY", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                setContentView(R.layout.activity_main);
                                }

                        });
                builder.show();
            } else {
                Toast retry = Toast.makeText(getApplicationContext(), this.newUser + "" + " You have not taken this quiz, please take the quiz", Toast.LENGTH_LONG);
                retry.show();

            }

        } catch (Exception e) {
            // Try and catch for errors
        }
    }

    public void previous_page_two(View view) {
        Intent quizPageTwo = new Intent(QuizTwoActivity.this, QuizActivity.class);
        quizPageTwo.putExtra("USERNAME", this.newUser);
        quizPageTwo.putExtra("SCORE", this.scores);
        startActivity(quizPageTwo);
    }


}
