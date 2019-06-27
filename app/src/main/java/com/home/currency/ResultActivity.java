package com.home.currency;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        TextView result = findViewById(R.id.result);
        float usd=getIntent().getFloatExtra("USD",0);
        float jpy=getIntent().getFloatExtra("JPY",0);
        result.setText(getString(R.string.usd_is)+usd+"\n"+getString(R.string.jpy_is)+jpy);
    }
}
