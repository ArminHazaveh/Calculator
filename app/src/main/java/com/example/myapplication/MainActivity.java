package com.example.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    // start define variable section and accessing to viewData
//    public TextView myTextView;
//    public Button changeColor;
//    public String tempStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // start myCode section
//
//        myTextView = (TextView) findViewById(R.id.textView1);
//        changeColor = (Button) findViewById(R.id.btnChangeColor);
//        tempStr = "lorem episum";
//
//        changeColor.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                myTextView.setTextColor(Color.BLACK);
//                myTextView.setText(tempStr);
//            }
//        });
//
//        changeColor.setOnLongClickListener(new View.OnLongClickListener() {
//            @Override
//            public boolean onLongClick(View v) {
//                myTextView.setTextColor(Color.WHITE);
//                return true;
//            }
//        });

        // start myCode section 2


    }

}