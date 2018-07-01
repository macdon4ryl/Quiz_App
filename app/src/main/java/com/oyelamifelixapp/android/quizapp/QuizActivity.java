package com.oyelamifelixapp.android.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;

public class QuizActivity extends MainActivity {

    String newUser;
    int scores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.newUser = getIntent().getStringExtra("USERNAME");
        this.scores = getIntent().getIntExtra("SCORE", 0);
        setContentView(R.layout.activity_quiz);
    }

    // takes scores of the quiz first page and moves to the next page
    public void next_page(View view) {
        // try and catch is used for exceptions that may crash the app
        try {
            RadioButton questionOne = findViewById(R.id.answer_question_one);
            boolean answerOne = questionOne.isChecked();

            RadioButton questionTwo = findViewById(R.id.answer_question_two);
            boolean answerTwo = questionTwo.isChecked();

            RadioButton questionThree = findViewById(R.id.answer_question_three);
            boolean answerThree = questionThree.isChecked();

            RadioButton questionFour = findViewById(R.id.answer_question_four);
            boolean answerFour = questionFour.isChecked();

            CheckBox questionFivea = findViewById(R.id.answer_question_five_a);
            boolean answerFivea = questionFivea.isChecked();

            CheckBox questionFiveb = findViewById(R.id.answer_question_five_b);
            boolean answerFiveb = questionFiveb.isChecked();

            CheckBox questionFivec = findViewById(R.id.answer_question_five_c);
            boolean answerFivec = questionFivec.isChecked();

            CheckBox questionFived = findViewById(R.id.answer_question_five_d);
            boolean answerFived = questionFivec.isChecked();

            CheckBox questionSixa = findViewById(R.id.answer_question_six_a);
            boolean answerSixa = questionSixa.isChecked();

            CheckBox questionSixb = findViewById(R.id.answer_question_six_b);
            boolean answerSixb = questionSixb.isChecked();

            CheckBox questionSixc = findViewById(R.id.answer_question_six_c);
            boolean answerSixc = questionSixc.isChecked();

            CheckBox questionSixd = findViewById(R.id.answer_question_six_d);
            boolean answerSixd = questionSixd.isChecked();

            if (answerOne) {
                scores += 1;
            }

            if (answerTwo) {
                scores += 1;
            }

            if (answerThree) {
                scores += 1;
            }
            if (answerFour) {
                scores += 1;
            }

            if (!answerFived && answerFivea && answerFiveb && answerFivec) {
                scores += 1;
            }
            if (!answerSixd && answerSixa && answerSixb && answerSixc) {
                scores += 1;
            }
            //takes the user to the next page for the quiz
            Intent quizPageTwo = new Intent(QuizActivity.this, QuizTwoActivity.class);
            quizPageTwo.putExtra("USERNAME", newUser);
            quizPageTwo.putExtra("SCORE", this.scores);
            startActivity(quizPageTwo);
        } catch (Exception e) {
            // try and catch for the error
        }
    }
    // returns the user to the home page
    public void previous_page(View view) {
        Intent homePage = new Intent(QuizActivity.this, MainActivity.class);
        homePage.putExtra("USERNAME", newUser);
        homePage.putExtra("SCORE", this.scores);
        startActivity(homePage);
    }
}