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

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Queue;

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
                if(fname.isEmpty()||lname.isEmpty()||purpose.isEmpty()||meet.isEmpty()){
                    Toast.makeText(getApplicationContext(),"All Inputs are mandatory",Toast.LENGTH_LONG).show();
                }
                else {
                    callApi();
                }

            }

            private void callApi() {
                String apiUrl="https://log-app-demo-api.onrender.com/addvisitor";
                JSONObject data=new JSONObject();
                try {
                    data.put("firstname",fname);
                    data.put("lastname",lname);
                    data.put("purpose",purpose);
                    data.put("whomToMeet",meet);
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
                JsonObjectRequest request=new JsonObjectRequest(
                        Request.Method.POST,
                        apiUrl,
                        data,
                        response -> Toast.makeText(getApplicationContext(),"Successfully Added",Toast.LENGTH_LONG).show(),
                        error -> Toast.makeText(getApplicationContext(),"Something Went Wrong",Toast.LENGTH_LONG).show()
                );
                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                queue.add(request);}

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