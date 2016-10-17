package ir.adicom.app.myapplication;

import android.os.Looper;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        final String[] names = getIntent().getExtras().getStringArray("NAMES");
        final int r = getIntent().getExtras().getInt("INDEX");

        TextView textView = (TextView) findViewById(R.id.textView2);
        for(String str:names)
            textView.setText(textView.getText() + "\n" + str);

        final TextView tvWinner = (TextView) findViewById(R.id.tvWinner);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                tvWinner.post(new Runnable() {
                    @Override
                    public void run() {
                        tvWinner.setText("Winner is : " + names[r]);
                    }
                });
                Log.e("TAG", "Time!!!!");
            }
        }, 5000);


        Button btnBack = (Button) findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
