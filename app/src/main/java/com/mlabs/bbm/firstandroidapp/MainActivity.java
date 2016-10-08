package com.mlabs.bbm.firstandroidapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends  AppCompatActivity {
    public ImageView rc;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rc = (ImageView) findViewById(R.id.rc);


        rc.setOnTouchListener(new View.OnTouchListener() {

            float x1, x2, x3;
            float y1, y2, y3;
            String Quad="";
            String Swipe ="";
            String Swipe1="";

            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {
                TextView tx = (TextView) findViewById(R.id.textView10);
                TextView ty = (TextView) findViewById(R.id.textView16);
                TextView tv3 = (TextView) findViewById(R.id.textView15);
                TextView tv4 = (TextView) findViewById(R.id.textView13);
                TextView tv5 = (TextView) findViewById(R.id.textView12);
                TextView tv6 = (TextView) findViewById(R.id.textView11);
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        x1 = motionEvent.getX();
                        y1 = motionEvent.getY();

                        tx.setText(" ");
                        ty.setText(" ");
                        tv3.setText(" ");
                        tv4.setText(" ");
                        tv5.setText(" ");
                        tv6.setText(" ");
                        /* Toast.makeText(getBaseContext(), "x1=" + x1 + "y1=" + y1, Toast.LENGTH_SHORT).show();*/
                        break;
                    }

                    case MotionEvent.ACTION_UP: {
                        x2 = motionEvent.getX();
                        y2 = motionEvent.getY();

                        if (x1 > x2) {
                            /*Toast.makeText(getBaseContext(), "SWIPE RIGHT TO LEFT. x2=" + x2 + "y2=" + y2, Toast.LENGTH_SHORT).show();*/
                            Swipe="RIGHT TO LEFT , ";
                        }
                        if (x1 < x2) {
                            /*Toast.makeText(getBaseContext(), "SWIPE LEFT TO RIGHT. x2=" + x2 + "y2=" + y2, Toast.LENGTH_SHORT).show();*/
                            Swipe="LEFT TO RIGHT , ";
                        }
                        if (y1 < y2) {
                            /*Toast.makeText(getBaseContext(), "SWIPE BOTTOM TO TOP. x2=" + x2 + "y2=" + y2, Toast.LENGTH_SHORT).show();*/
                            Swipe1="TOP TO BOTTOM";
                        }
                        if (y1 > y2) {
                            /*Toast.makeText(getBaseContext(), "SWIPE TOP TO BOTTOM. x2=" + x2 + "y2=" + y2, Toast.LENGTH_SHORT).show();*/
                            Swipe1="BOTTOM TO TOP.";
                        }
                        if (x2>(rc.getMeasuredWidth()/2) && y2>(rc.getMeasuredHeight()/2)){
                            /*Toast.makeText(getBaseContext(), "QUADRANT 4", Toast.LENGTH_SHORT).show();*/
                            Quad="Quadrant 4";
                        }
                        else if(x2<(rc.getMeasuredWidth()/2) && y2>(rc.getMeasuredHeight()/2)){
                            /*Toast.makeText(getBaseContext(), "QUADRANT 3", Toast.LENGTH_SHORT).show();*/
                            Quad="Quadrant 3";
                        }
                        else if(x2>(rc.getMeasuredWidth()/2) && y2<(rc.getMeasuredHeight()/2)){
                            /**Toast.makeText(getBaseContext(), "QUADRANT 1", Toast.LENGTH_SHORT).show();*/
                            Quad="Quadrant 1";
                        }
                        else if(x2<(rc.getMeasuredWidth()/2) && y2<(rc.getMeasuredHeight()/2)){
                            /*Toast.makeText(getBaseContext(), "QUADRANT 2", Toast.LENGTH_SHORT).show();*/
                            Quad="Quadrant 2";
                        }
                        else if (x2==(rc.getMeasuredWidth()/2) && y2==(rc.getMeasuredHeight()/2)) {
                            /*Toast.makeText(getBaseContext(), "NO QUADRANT", Toast.LENGTH_SHORT).show();*/
                            Quad="No Quadrant";
                        }
                        if(x1>x2){
                            x3= x1-x2;
                        }
                        else if(x1<x2){
                            x3=x2-x1;
                        }
                        if(y1>y2){
                            y3= y1-y2;
                        }
                        else if(y1<y2){
                            y3=y2-y1;
                        }
                        if (x1==x2){
                            x3=0;
                            //Quad="";

                        }
                        if (y1==y2){
                            y3=0;
                           // Quad="";

                        if ((y1==y2) && (x1==x2))
                        {
                            Swipe="";
                            Swipe1="";
                        }
                        }
                        if(x2 < 20 && y2 <20){
                            Swipe="";
                            Swipe1="";

                        }
                        /*break;*/
                        tx.setText("x1="+x1+" to x2="+x2);
                        ty.setText("y1="+y1+" to y2="+y2);
                        tv3.setText("Diff. of x= "+(x3));
                        tv4.setText("Diff. of y= "+(y3));
                        tv5.setText(Swipe +""+ Swipe1 );
                        tv6.setText("Quadrant: "+ Quad );

                        //intent2.getString;



                    }

                }
                //return false;
                return true;
            }

        });
    }


}
