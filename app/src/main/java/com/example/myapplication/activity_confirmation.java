package com.example.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class activity_confirmation extends AppCompatActivity {

TextView txtName, txtFamily, showData;
Button btnFetch, btnClear;
SharedPreferences shpref;
SharedPreferences.Editor shEdit;

@Override
protected void onCreate(Bundle savedInstanceState) {
   super.onCreate(savedInstanceState);
   EdgeToEdge.enable(this);
   setContentView(R.layout.activity_confirmation);
   ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
      Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
      v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
      return insets;
   });

   txtName = findViewById(R.id.textViewName);
   txtFamily = findViewById(R.id.textViewFamily);
   showData = findViewById(R.id.showFetchData);

   Intent reciveData = getIntent();
   String name = reciveData.getStringExtra("name");
   String family = reciveData.getStringExtra("family");

   txtName.setText("Your name is :" + " " + name);
   txtFamily.setText("Your family is :" + " " + family);
   btnFetch = findViewById(R.id.btnFetch);
   btnClear = findViewById(R.id.btnClear);

   btnFetch.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {

         shpref = getSharedPreferences("saveData", MODE_PRIVATE);
         shEdit = shpref.edit();
         shEdit.putString("saveNameData", name);
         shEdit.putString("saveFamilyData", family);

         if (shEdit.commit() == true) {
            String nameValue = shpref.getString("saveNameData", "notFound").toString();
            String familyValue = shpref.getString("saveFamilyData", "notFound").toString();
            showData.setText(nameValue + " " + familyValue);
            Toast.makeText(getApplicationContext(), "Data storage and retrieval completed successfully.", Toast.LENGTH_LONG).show();
         }

      }
   });

   btnClear.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
         shEdit.clear();
         if (shEdit.commit() == true) {
            showData.setText("");
            Toast.makeText(getApplicationContext(), "Saved data cleared.", Toast.LENGTH_LONG).show();
         }
      }
   });
}
}