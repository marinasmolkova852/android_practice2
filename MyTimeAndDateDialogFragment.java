package ru.mirea.smolkova.dialog;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MyTimeAndDateDialogFragment implements View.OnClickListener{

    private int mYear, mMonth, mDay, mHour, mMinute;
    TextView time, date;
    Context context;

    MyTimeAndDateDialogFragment(TextView t, TextView d, Context c){
        time = t;
        date = d;
        context = c;
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.textView){
            callTimePicker();
        }
        else if (v.getId() == R.id.textView2){
            callDatePicker();
        }
    }

    private void callTimePicker() {
        final Calendar cal = Calendar.getInstance();
        mHour = cal.get(Calendar.HOUR_OF_DAY);
        mMinute = cal.get(Calendar.MINUTE);

        TimePickerDialog tpd = new TimePickerDialog(context,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        String editTime = hourOfDay + " : " + minute;
                        time.setText(editTime);
                    }
                }, mHour, mMinute, false);
        tpd.show();
    }

    private  void callDatePicker(){
        final Calendar cal = Calendar.getInstance();
        mYear = cal.get(Calendar.YEAR);
        mMonth = cal.get(Calendar.MONTH);
        mDay = cal.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog dpd = new DatePickerDialog(context,
                (view, year, month, day) -> {
                    String editDate = day + "." + (month + 1) + "." + year;
                    date.setText(editDate);
                }, mYear, mMonth, mDay);
        dpd.show();
    }
}
