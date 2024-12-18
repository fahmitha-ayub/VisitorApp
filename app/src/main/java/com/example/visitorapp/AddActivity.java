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

public class AddActivity extends AppCompatActivity {


    Button b1,b2;
    EditText ed1,ed2,ed3,ed4;
    String fname,lname,meet,purpose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add);
        b1=(Button) findViewById(R.id.back);
        b2=(Button) findViewById(R.id.sub);
        ed1=(EditText) findViewById(R.id.fname);
        ed2=(EditText) findViewById(R.id.lname);
        ed3=(EditText) findViewById(R.id.purpose);
        ed4=(EditText) findViewById(R.id.meet);

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fname=ed1.getText().toString();
                lname=ed2.getText().toString();
                purpose=ed3.getText().toString();
                meet=ed4.getText().toString();

                Toast.makeText(getApplicationContext(),fname+" "+lname+" "+purpose+" "+meet,Toast.LENGTH_LONG).show();

            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent ob1= new Intent(getApplicationContext(),MainActivity.class);
                startActivity(ob1);
            }
        });
    }
}