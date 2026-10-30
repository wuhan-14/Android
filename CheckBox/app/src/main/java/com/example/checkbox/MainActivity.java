package com.example.checkbox;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {
    private TextView hobby;
    private String hobbys;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CheckBox checkBox1=findViewById(R.id.checkbox1);
        CheckBox checkBox2=findViewById(R.id.checkbox2);
        CheckBox checkBox3=findViewById(R.id.checkbox3);

        hobby=findViewById(R.id.hobby);

        checkBox1.setOnCheckedChangeListener(this);
        checkBox2.setOnCheckedChangeListener(this);
        checkBox3.setOnCheckedChangeListener(this);

        hobbys=new String();
    }

    @Override
    public void onCheckedChanged(@NonNull CompoundButton buttonView, boolean isChecked) {
        String motion=buttonView.getText().toString();
        if(isChecked){
            if(!hobbys.contains(motion)){
                hobbys=hobbys+motion;
                hobby.setText(hobbys);
            }
        }else{
            if(hobbys.contains(motion)){
                hobbys=hobbys.replace(motion,"");
                hobby.setText(hobbys);
            }
        }
    }
}