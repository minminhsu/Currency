package com.home.currency;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText ntd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ntd = findViewById(R.id.ntd);

        Button go = findViewById(R.id.button_go);
        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ntd_string= ntd.getText().toString();
                if (ntd_string.trim().length() == 0) {
                    new AlertDialog.Builder(MainActivity.this)
                            .setTitle(getString(R.string.problem))
                            .setMessage(getString(R.string.pls_enter_ntd))
                            .setPositiveButton(getString(R.string.ok),null)
                            .show();
                }
                else{
                   float ntd_d=Float.parseFloat(ntd_string);
                  /*   new AlertDialog.Builder(MainActivity.this)
                            .setTitle(getString(R.string.result))
                            .setMessage(getString(R.string.usd_is) +calculate_us(ntd_d)+"\n" +getString(R.string.jpy_is) + calculate_jp(ntd_d) )
                            .setPositiveButton(getString(R.string.ok),null)
                            .show();*/
                   Intent intent=  new Intent( MainActivity.this , ResultActivity.class);
                   intent.putExtra("USD",calculate_us(ntd_d)) ;
                   intent.putExtra("JPY",calculate_jp(ntd_d)) ;
                   startActivity(intent);
                }
            }
        });

    }

    private float calculate_us(float ntd_d){
        float us = (float) (ntd_d /30.9);
        return us;
    }
    private float calculate_jp(float ntd_d){
        float jp = (float) (ntd_d * 0.28);
        return jp;
    }
}
