package com.example.visitorapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
public class MainActivity extends AppCompatActivity {

    Button b1,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

    b1=(Button) findViewById(R.id.add);
    b2=(Button) findViewById(R.id.view);

    b1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent ob2=new Intent(getApplicationContext(),AddActivity.class);
            startActivity(ob2);
        }
    });
    b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ob3=new Intent(getApplicationContext(),viewAllActivity.class);
                startActivity(ob3);
            }
    });
    }
}