package com.example.lesson_1_3;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button bute;
    EditText edemail,edmassage,edtext;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      bute = findViewById(R.id.button);
      edemail =findViewById(R.id.ed_email);
      edmassage=findViewById(R.id.ed_massage);
      edtext=findViewById(R.id.ed_text);
      bute.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              if (edemail.getText().toString().isEmpty()||edmassage.getText().toString().isEmpty() ||edtext.getText().toString().isEmpty()){
                  Toast.makeText(getApplicationContext(),"заполнить все тексты",Toast.LENGTH_SHORT).show();
              }else{
                  Intent email_intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto",edemail.getText().toString(), null));
                  email_intent.putExtra(android.content.Intent.EXTRA_SUBJECT, edmassage.getText().toString());
                  email_intent.putExtra(android.content.Intent.EXTRA_TEXT,edtext.getText().toString());

                  startActivity(Intent.createChooser(email_intent, "Send email..."));
              }
          }
      });
    }


}