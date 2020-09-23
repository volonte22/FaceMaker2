package com.example.facemaker;//@author Jack Volonte
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.graphics.Canvas;
import android.view.View;
import android.widget.AdapterView;
import android.widget.SeekBar;

import java.util.Random;

public class Face extends SurfaceView {
    //initalizing Colors
    Color skinColor;
    Color eyeColor;
    Color hairColor;
    Color hairStyle;

    //paints
    Paint faceShape = new Paint();
    Paint eyePaint = new Paint();
    Paint mouthPaint = new Paint();
    Paint hairPaint = new Paint();
    Paint nosePaint = new Paint();
    Paint earPaint = new Paint();

    //toggles & ids that faceController.java implements
    int redID = 50;
    int greenID = 50;
    int blueID = 50;
    int hairToggle = 1;
    boolean start;
    int redProgress;
    int blueProgress;
    int greenProgress;
    boolean Hair;
    boolean Eyes;
    boolean Skin;

    ////inital constructor
    public Face(Context context, AttributeSet attrs) {
        super(context, attrs);
        setWillNotDraw(false);
        faceShape.setStrokeWidth(1);
        setBackgroundColor(Color.WHITE);
        nosePaint.setColor(Color.BLACK);
        mouthPaint.setColor(Color.BLACK);
        hairPaint.setStrokeWidth(25);
        start = true;
    }

    //constructor 2
    public void setFace(Color skin, Color eye, Color hair, Color style) {
        this.skinColor = skin;
        this.eyeColor = eye;
        this.hairColor = hair;
        this.hairStyle = style;
    }

    //randomize function, randomly assigns an int value to the instance variables
    public void randomize(){
        Random random = new Random();
        faceShape.setColor(Color.rgb(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
        earPaint.setColor(Color.rgb(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
        hairPaint.setColor(Color.rgb(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
        eyePaint.setColor(Color.rgb(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
    }

    //onDraw method, draws the face
    @Override
    public void onDraw(Canvas canvas) {
        drawEntire(canvas);
    }

    //draws the entirety of the face in order (ears before face else ears come in front of face)
    public void drawEntire(Canvas canvas) {
        if ( start ) {
            randomize();
        }
        setRGB();
        drawEars(canvas);
        drawHead(canvas);
        drawNose(canvas);
        drawMouth(canvas);
        drawEyes(canvas);
        drawHair(canvas);
        start = false;
    }

    //draws the shape of the head, uses faceShape (which is a paint) and canvas.drawCircle to do so
    public void drawHead(Canvas canvas) {
        canvas.drawCircle(900, 600, 550, faceShape);
    }

    //draws nose, uses nosePaint and canvas.drawLine to do so
    public void drawNose(Canvas canvas)  {
        nosePaint.setStrokeWidth(15);
        canvas.drawLine(910, 575, 900, 650, nosePaint);
        canvas.drawLine(900, 650, 950, 650, nosePaint);
    }

    //draws mouth, uses mouthPaint and canvas.drawLine to do so
    public void drawMouth(Canvas canvas) {
        mouthPaint.setStrokeWidth(15);
        canvas.drawLine(800, 725, 900, 750, mouthPaint);
        canvas.drawLine(1000, 725, 900, 750, mouthPaint);
    }

    //draws ears, uses earPaint and canvas.drawCircle to do so
    public void drawEars(Canvas canvas) {
        canvas.drawCircle(350, 500, 100, earPaint);
        canvas.drawCircle(1450, 500, 100, earPaint);
    }

    //draws eyes, uses eyePaint and canvas.drawCircle to do so
    public void drawEyes(Canvas canvas) {
        canvas.drawCircle(750, 450, 80, eyePaint);
        canvas.drawCircle(1050, 450, 80, eyePaint);
        Paint ePaint = new Paint();
        ePaint.setColor(Color.BLACK);
        canvas.drawCircle(750, 450, 10, ePaint);
        canvas.drawCircle(1050, 450, 10, ePaint);
    }

    //draws hair, uses hairPaint and canvas.drawLine to do so
    //split into three, spiky, straight, and short hair types
    //to be updated with the spinner through faceController
    public void drawHair(Canvas canvas) {
        //spiky
        if ( hairToggle == 0 ) {
            canvas.drawLine(600, 200, 600, 100, hairPaint);
            canvas.drawLine(700, 200, 700, 100, hairPaint);
            canvas.drawLine(800, 200, 800, 100, hairPaint);
            canvas.drawLine(900, 200, 900, 100, hairPaint);
            canvas.drawLine(1000, 200, 1000, 100, hairPaint);
            canvas.drawLine(1100, 200, 1100, 100, hairPaint);
            canvas.drawLine(1200, 200, 1200, 100, hairPaint);
        }
        //straight
        if ( hairToggle == 1) {
            canvas.drawLine(600, 200, 1200, 100, hairPaint);
            canvas.drawLine(600, 150, 1200, 50, hairPaint);
            canvas.drawLine(600, 100, 1200, 0, hairPaint);
        }
        //short
        if ( hairToggle == 2 ) {
            canvas.drawLine(600, 200, 600, 175, hairPaint);
            canvas.drawLine(650, 200, 650, 175, hairPaint);
            canvas.drawLine(700, 200, 700, 175, hairPaint);
            canvas.drawLine(750, 200, 750, 175, hairPaint);
            canvas.drawLine(800, 200, 800, 175, hairPaint);
            canvas.drawLine(850, 200, 850, 175, hairPaint);
            canvas.drawLine(900, 200, 900, 175, hairPaint);
            canvas.drawLine(950, 200, 950, 175, hairPaint);
            canvas.drawLine(1000, 200, 1000, 175, hairPaint);
            canvas.drawLine(1050, 200, 1050, 175, hairPaint);
            canvas.drawLine(1100, 200, 1100, 175, hairPaint);
            canvas.drawLine(1150, 200, 1150, 175, hairPaint);
            canvas.drawLine(1200, 200, 1200, 175, hairPaint);
        }
    }





    //sets RGB of hair, eyes, and skin colors
    //these are updated by the buttons and seekbars in faceController
    //hair, eyes, and skin are booleans
    public void setRGB() {
        if ( Hair ) {
            hairPaint.setColor(Color.rgb(redID, greenID, blueID));
        } else if ( Eyes ) {
            eyePaint.setColor(Color.rgb(redID, greenID, blueID));
        } else if ( Skin ) {
            faceShape.setColor(Color.rgb(redID, greenID, blueID));
        }
    }

    public void setHairToggle(int i) {
        hairToggle = i;
    }



}
