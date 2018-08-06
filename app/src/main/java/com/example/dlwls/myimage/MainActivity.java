package com.example.dlwls.myimage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private int i;
    private  int size;
    private  ArrayList<Integer> imageList;
    private  ImageView imgUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageList = new ArrayList<Integer>();
        imageList.add(R.drawable.img01);
        imageList.add(R.drawable.img02);
        imageList.add(R.drawable.img03);
        imageList.add(R.drawable.img04);
        imageList.add(R.drawable.img05);
        imageList.add(R.drawable.img06);
        imageList.add(R.drawable.img07);
        imageList.add(R.drawable.img08);
        imageList.add(R.drawable.img09);
        imageList.add(R.drawable.img10);
        size = imageList.size();
        imgUp = (ImageView) findViewById(R.id.img_up);
        final ImageView imgDown = (ImageView) findViewById(R.id.img_down);
        Button prev = (Button) findViewById(R.id.prev_btn);
        final Button next = (Button) findViewById(R.id.next_btn);
        this.i = 1;

        imgUp.setOnTouchListener(new TestEvent());

    }
        class TestEvent implements View.OnTouchListener {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                float downPos = 0;
                float upPos = 0;
                switch (motionEvent.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        Log.d("ACTION_DOWN", Float.toString(motionEvent.getX()));
                        downPos = motionEvent.getX();
                        break;
                    case MotionEvent.ACTION_UP:
                        Log.d("ACTION_UP", "motion UP!!!!");
                        upPos = motionEvent.getX();
                        if(downPos - upPos > 50){
                            if(i >= size){i=1;}
                            imgUp.setImageResource(imageList.get(i));
                             i++;
                        } else if (downPos - upPos < -50){
                            if(i < 0){i = size-1;}
                            imgUp.setImageResource(imageList.get(i));
                            i--;
                        }
                        break;
                    case MotionEvent.ACTION_MOVE:

                        break;
                }


                return true;
            }


        }
//        prev.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view) {
//                if(i >= size){i=1;}
//                imgUp.setImageResource(imageList.get(i));
//                imgDown.setImageResource(imageList.get(i));
//                i++;
//            }
//        });
//
//
//
//        next.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view) {
//                ImageView imgUp = (ImageView) findViewById(R.id.img_up);
//                ImageView imgDown = (ImageView) findViewById(R.id.img_down);
//                imgUp.setImageResource(R.drawable.img02);
//                imgDown.setImageResource(R.drawable.img02);
//            }
//        });
}



