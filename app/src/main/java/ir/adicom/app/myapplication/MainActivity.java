package ir.adicom.app.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private int index = 0;
    private ArrayList<EditText> btnList = new ArrayList();
    private TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ViewGroup layout = (ViewGroup) findViewById(R.id.linearLayout);
        txt = (TextView) findViewById(R.id.textView);
        Button btnAdd = (Button) findViewById(R.id.button);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(index<9) {
                    EditText bt = new EditText(MainActivity.this);
                    btnList.add(bt);
                    bt.setText("Player " + index);
                    index++;
                    bt.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT,
                            ViewGroup.LayoutParams.WRAP_CONTENT));
                    layout.addView(bt);
                } else {
                    Toast.makeText(getApplicationContext(), "Max Player is 9", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button btnDraw  = (Button) findViewById(R.id.button2);
        btnDraw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (index > 0) {
                    Random random = new Random(System.currentTimeMillis());
                    int r = random.nextInt(index);
                    Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                    intent.putExtra("INDEX", r);
                    String[] names = new String[index];
                    for(int i=0; i<index; i++)
                        names[i] = String.valueOf(btnList.get(i).getText());
                    intent.putExtra("NAMES", names);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Please add player!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
