/* @author Jack Volonte */
package com.example.facemaker;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.SurfaceView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.view.SurfaceHolder;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //creating spinner and adding string values from array in strings.xml
        //learned this through the android studio src
        Spinner mySpinner = (Spinner)findViewById(R.id.spinner);
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.spinnerStuff));
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(spinnerAdapter);

        //setting up view & controller
        Face faceView = findViewById(R.id.faceView);
        final faceController controller = new faceController(faceView);

        //creating buttons to pass onto listener events to the controller below
        Button randomize = findViewById(R.id.randomFace);
        SeekBar redId = findViewById(R.id.redID);
        SeekBar greenId = findViewById(R.id.greenID);
        SeekBar blueId = findViewById(R.id.blueID);
        RadioButton hairButton = findViewById(R.id.Hair);
        RadioButton eyesButton = findViewById(R.id.Eyes);
        RadioButton skinButton = findViewById(R.id.Skin);


        //setting up listener events, passing controller as an arg for each
        randomize.setOnClickListener(controller);
        redId.setOnSeekBarChangeListener(controller);
        greenId.setOnSeekBarChangeListener(controller);
        blueId.setOnSeekBarChangeListener(controller);
        hairButton.setOnClickListener(controller);
        eyesButton.setOnClickListener(controller);
        skinButton.setOnClickListener(controller);


        //spinner listener event, created tons of bugs so had to declare contrller as final and create a method inside of that controller
        // to update the value of hairToggle in the view
        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id)
            {
                controller.setHairStyle(pos);
            }

            public void onNothingSelected(AdapterView<?> parent)
            {

            }
        });









    }


}



