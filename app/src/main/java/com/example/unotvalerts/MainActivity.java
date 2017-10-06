package com.example.unotvalerts;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);
        if (getIntent().getExtras() != null) {
            if (getIntent().getExtras().get("number") != null) {
                textView.setText(getIntent().getExtras().getString("number"));
            }
        }
    }
}
