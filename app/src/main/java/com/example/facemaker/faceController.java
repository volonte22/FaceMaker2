package com.example.facemaker;

import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.SeekBar;
import android.view.View;
import android.widget.Spinner;
import android.view.SurfaceView;

public class faceController implements OnClickListener, CompoundButton.OnCheckedChangeListener, SeekBar.OnSeekBarChangeListener   {
    private Face view;
    //sets the view to faceView of type Face
    public faceController(Face faceView) {
        this.view = faceView;
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {


    }


    //checks the seekBar progress and updates the variables redID, blueID, greenID in the view when changed
    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        switch(seekBar.getId()) {
            case R.id.redID:
                this.view.redID = i;
                this.view.setRGB();
                break;
            case R.id.greenID:
                this.view.greenID = i;
                this.view.setRGB();
                break;
            case R.id.blueID:
                this.view.blueID = i;
                this.view.setRGB();
                break;
        }
        this.view.invalidate();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    //checks if buttons are pressed, first case is random button, second is if hair is chosen, third is if eyes are chosen, fourth is if skin is chosen
    //updates and calls funtions inside of this.view in order to remake the face
    //also invalidates the view
    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.randomFace:
                this.view.randomize();
                break;
            case R.id.Hair:
                this.view.Hair=true;
                this.view.Eyes=false;
                this.view.Skin = false;
                this.view.setRGB();
                break;
            case R.id.Eyes:
                this.view.Eyes=true;
                this.view.Hair=false;
                this.view.Skin = false;
                this.view.setRGB();
                break;
            case R.id.Skin:
                this.view.Skin = true;
                this.view.Eyes = false;
                this.view.Hair = false;
                this.view.setRGB();
                break;
        }
        this.view.invalidate();
    }




}
