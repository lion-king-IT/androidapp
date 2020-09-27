package jp.wings.nikkeibp.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class title1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title1);

        Button startButton = findViewById(R.id.securityButton);
        startButton.setOnClickListener(new View.OnClickListener() {
                @Override
            public void onClick(View v) {
                    Intent intent = new Intent(getApplication(),MainActivity.class);
                    startActivity(intent);
                }
        });

        final Button nextpageButton = findViewById(R.id.nextpage);
        nextpageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),title2Activity.class);
                startActivity(intent);
            }
        });
    }


}