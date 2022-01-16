package com.example.progress;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends Activity {
    int percent = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ProgressBar progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        final ObjectAnimator objectAnimator = ObjectAnimator.ofInt(progressBar, "progress", progressBar.getProgress(), 100).setDuration(2500);
        TextView btn = (TextView) findViewById(R.id.text_view_button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                objectAnimator.start();
                runPercentageInButton();
            }
        });

    }

    private void runPercentageInButton(){
        TextView btn = (TextView) findViewById(R.id.text_view_button);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                String result = Integer.toString(percent) + "%";
                 btn.setText(result);
                 if (percent < 100){
                 percent++;
                 }
                 handler.postDelayed(this, 1);
            }
        });
    }
}
