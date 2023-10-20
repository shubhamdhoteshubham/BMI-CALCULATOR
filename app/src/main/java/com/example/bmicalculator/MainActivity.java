package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText weight,height;
    Button calculate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();

        MyFirstFragment myFirstFragment =new MyFirstFragment();

        weight= findViewById(R.id.editTextWeight);
        height=findViewById(R.id.editTextHeight);
        calculate=findViewById(R.id.buttonCalculate);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle =new Bundle();
                int userwweight=Integer.valueOf(weight.getText().toString());
                int userheight=Integer.valueOf(height.getText().toString());

                bundle.putInt("weight", userwweight);
                bundle.putInt("height", userheight);

                myFirstFragment.setArguments(bundle);
                fragmentTransaction.add(R.id.frame,myFirstFragment);
                fragmentTransaction.commit();

            }
        });
    }
}