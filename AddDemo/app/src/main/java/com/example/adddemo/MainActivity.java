package com.example.adddemo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText et1,et2;
    TextView tvResult;
    Button btnAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1=findViewById(R.id.et1);
        et2=findViewById(R.id.et2);
        tvResult=findViewById(R.id.tvResult);
        btnAdd=findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(v->{
            int a=Integer.parseInt(et1.getText().toString());
            int b=Integer.parseInt(et2.getText().toString());
            int sum=a+b;
            tvResult.setText("结果："+sum);
        });
    }
}