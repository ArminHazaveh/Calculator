package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class secondActivity extends AppCompatActivity {

@Override
protected void onCreate(@Nullable Bundle savedInstanceState) {
   super.onCreate(savedInstanceState);
   setContentView(R.layout.activity_second);

   TextInputEditText inputName = (TextInputEditText) findViewById(R.id.inputName);
   TextInputEditText inputFamily = (TextInputEditText) findViewById(R.id.inputFamily);
   Button btnSave = (Button) findViewById(R.id.btnSave);

   btnSave.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
         String name = inputName.getText().toString().trim();
         String family = inputFamily.getText().toString().trim();

         Intent intent = new Intent(secondActivity.this, activity_confirmation.class);
         intent.putExtra("name", name);
         intent.putExtra("family", family);
         startActivity(intent);
      }
   });
}
}
