package com.example.minimo2ej;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    public static final String USUARIO = "com.example.minimo2.USUARIO";
    private Button button;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        button = (Button)findViewById(R.id.button);
        editText = (EditText)findViewById(R.id.user);
        CustomLoading custom  = new CustomLoading(this);

        //cuando cliquemos el boton
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editText.getText().toString();
                Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
                intent.putExtra(USUARIO,name);

                custom.showDialog();
                Handler handler  = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        custom.cancelDialog();
                        startActivity(intent);
                    }
                },2000);


            }
        });





    }
}