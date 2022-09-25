package hu.home.android.clickcounter;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button hozzaadButton;
    private Button kivonButton;
    private TextView szamTextView;
    private int counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        hozzaadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter++;
                szamValtozik();
            }
        });
        kivonButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter--;
                szamValtozik();
            }
        });
        szamTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter = 0;
                szamValtozik();
            }
        });
        szamTextView.setLongClickable(true);
        szamTextView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                counter = 0;
                szamValtozik();
                return false;
            }
        });
    }

    private void szamValtozik(){
        szamTextView.setText(Integer.toString(counter));
        if (counter >= 1){
            szamTextView.setTextColor(getResources().getColor(R.color.green));
        } else if (counter == 0){
            szamTextView.setTextColor(Color.parseColor("#0000fe"));

        }else {
            szamTextView.setTextColor(Color.parseColor("#ff0000"));
        }
    }

    private void init(){
        hozzaadButton = findViewById(R.id.hozzaadButton);
        kivonButton = findViewById(R.id.kivonButton);
        szamTextView = findViewById(R.id.szamTextView);
        counter = 0;
    }
}