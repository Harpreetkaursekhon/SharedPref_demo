package com.app.sharedprefdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {
    EditText edit1,edit2, edit3,edit4;
    Button btn_reg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        edit1 = (EditText) findViewById(R.id.edit1);
        edit2 = (EditText) findViewById(R.id.edit2);
        edit3 = (EditText) findViewById(R.id.edit3);
        edit4 = (EditText) findViewById(R.id.edit4);
        btn_reg = (Button) findViewById(R.id.btn_reg);
        btn_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences spf=getSharedPreferences("mypref", Context.MODE_PRIVATE);

                SharedPreferences.Editor spe=spf.edit();

                spe.putString("name",edit1.getText().toString());
                spe.putString("email",edit2.getText().toString());
                spe.putString("contact",edit3.getText().toString());
                spe.putString("password",edit4.getText().toString());

                spe.commit();
                finish();

            }
        });
    }

}
