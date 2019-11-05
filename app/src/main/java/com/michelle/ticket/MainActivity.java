package com.michelle.ticket;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText ed_Num1;
    private EditText ed_Num2;
    private EditText ed_Num3;
    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed_Num1 = findViewById(R.id.num1);
        ed_Num2 = findViewById(R.id.num2);
        ed_Num3 = findViewById(R.id.num3);
        image = findViewById(R.id.image);
    }
    public void enter(View view){
        int num1 = Integer.parseInt(ed_Num1.getText().toString());
        int num2 = Integer.parseInt(ed_Num2.getText().toString());
        int num3 = Integer.parseInt(ed_Num3.getText().toString());
        image.setAlpha(1.0f);
        image.setVisibility(View.VISIBLE);
        if(num1*300 + num2*250 + num3*400 > 1000){
            image.animate().alpha(0.0f).setDuration(1500);
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("訂購失敗")
                    .setMessage("餘額不足 !需再加值"+ ((num1*300 + num2*250 + num3*400-1000)))
                    .setPositiveButton("OK",null)
                    .show();
            Toast.makeText(MainActivity.this,"失敗   !",Toast.LENGTH_LONG).show();
        }
        else{
            image.animate().alpha(0.0f).setDuration(1500);
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("訂購成功")
                    .setMessage("餘額還有"+ (1000-(num1*300 + num2*250 + num3*400)))
                    .setPositiveButton("OK",null)
                    .show();
            Toast.makeText(MainActivity.this,"成功    !",Toast.LENGTH_LONG).show();
        }
    }
}
