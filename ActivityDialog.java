package ru.mirea.smolkova.dialog;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityDialog extends AppCompatActivity implements View.OnClickListener{

    TextView time, date;
    Button btn_round;
    Button btn_line;
    MyTimeAndDateDialogFragment mtdf;
    MyProgressDialogFragment mpdf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

        time = (TextView) findViewById(R.id.textView);
        date = (TextView) findViewById(R.id.textView2);
        btn_round = findViewById(R.id.button2);
        btn_line = findViewById(R.id.button3);

        time.setOnClickListener(this);
        date.setOnClickListener(this);
        btn_round.setOnClickListener(this);
        btn_line.setOnClickListener(this);

        mtdf = new MyTimeAndDateDialogFragment(time, date, this);
        mpdf = new MyProgressDialogFragment(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.textView:
            case R.id.textView2:
                mtdf.onClick(v);
                break;
            case R.id.button2:
            case R.id.button3:
                mpdf.onClick(v);
                break;
        }
    }

    public void onClickShowDialog(View view) {
        MyDialogFragment dialog = new MyDialogFragment();
        dialog.show(getSupportFragmentManager(), "mirea");
    }
    public void onOkClicked(){
        Toast.makeText(getApplicationContext(), "You choose the button" +
                "---Moving on---", Toast.LENGTH_LONG).show();
    }
    public void onCancelClicked(){
        Toast.makeText(getApplicationContext(), "You choose the button" +
                "---No---", Toast.LENGTH_LONG).show();
    }
    public void onNeutralClicked(){
        Toast.makeText(getApplicationContext(), "You choose the button" +
                "---On pause---", Toast.LENGTH_LONG).show();
    }

}