package jp.wings.nikkeibp.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class resultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
    }

    public static class ResultActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_result);

            TextView resultLabel = findViewById(R.id.resultLabel);
            TextView totalScoreLabel = findViewById(R.id.totalScoreLabel);

            int score = getIntent().getIntExtra("RIGHT_ANSWER_COUNT",0);

            //トータルスコアの読みだし
            SharedPreferences prefs = getSharedPreferences("quizApp", Context.MODE_PRIVATE);
            int totalScore = prefs.getInt("totalScore",0);
            //トータルスコアに今回のスコアを加算
            totalScore += score;

            //TectViewに表示する
            resultLabel.setText("5問中"+score+"問正解");
            totalScoreLabel.setText("トータルスコア　:"+totalScore);

            //トータルスコアを保存
            SharedPreferences.Editor editor = prefs.edit();
            editor.putInt("totalScore",totalScore);
            editor.apply();
        }

        public void returnTop(View view) {
            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);
        }

    }
}