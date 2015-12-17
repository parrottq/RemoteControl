package com.parrott.quinn.remotecontrol;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.TextView;

public class ControllerActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_controller);

        textView = (TextView) findViewById(R.id.speed);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i("Controler", Float.toString(event.getY()));
        textView.setText(Integer.toString((int) event.getY() - 150));
        int yPos = (int) event.getY() - 150;

        if (event.getActionMasked() == MotionEvent.ACTION_UP){
            textView.setText(R.string.default_speed);
        } else {
            if (yPos <= 0) {
                yPos = 0;
            } else if (yPos >= 1000) {
                yPos = 1000;
            }
            textView.setText(Integer.toString((int)(yPos * (0.255))));
        }
        return false;
    }

}
