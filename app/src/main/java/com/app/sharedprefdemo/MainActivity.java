package com.app.sharedprefdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText ed1,ed2;
Button b1, b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1=(EditText)findViewById(R.id.ed1);
        ed2=(EditText)findViewById(R.id.ed2);
        b1=(Button)findViewById(R.id.b1);
b1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        SharedPreferences spf=getSharedPreferences("mypref", Context.MODE_PRIVATE);

        SharedPreferences.Editor spe=spf.edit();

        //get the value from the shared perfefernces
        String name=spf.getString("name", "no  value");
        String password=spf.getString("password", "no  value");

        if(ed1.getText().toString().equalsIgnoreCase(name) && ed2.getText().toString().equalsIgnoreCase(password)){
        Toast.makeText(getApplicationContext(), "successfull", Toast.LENGTH_SHORT).show();
    }else{

            Toast.makeText(getApplicationContext(), "unsuccessfull", Toast.LENGTH_SHORT).show();
        }

    }
});

        b2=(Button)findViewById(R.id.b2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });


    }
}
