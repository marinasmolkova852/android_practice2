package ru.mirea.smolkova.dialog;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import android.view.View;

public class MyProgressDialogFragment implements View.OnClickListener{

    Context context;
    ProgressDialog pd;
    Handler handler;

    MyProgressDialogFragment(Context c){
        context = c;
    }

    @SuppressLint("HandlerLeak")
    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.button2){
            pd = new ProgressDialog(context);
            pd.setMax(100);
            pd.setTitle("Идет загрузка...");
            pd.setMessage("Round ProgressDialog");
            pd.setButton(Dialog.BUTTON_POSITIVE, "Oк", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                }
            });
            pd.show();
        }
        else if (v.getId() == R.id.button3){
            pd = new ProgressDialog(context);
            pd.setMax(100);
            pd.setMessage("Идет загрузка...");
            pd.setTitle("Line ProgressDialog");
            pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            pd.show();

            handler = new Handler() {
                public void handleMessage(Message msg) {
                    // и обновляем идикатор, пока шкала не заполнится
                    if (pd.getProgress() < pd.getMax()) {
                        // обновляем индикаторы на 3 пункта за 1 секунду (1000 милисекунд)
                        pd.incrementProgressBy(3);
                        handler.sendEmptyMessageDelayed(0, 1000);
                    } else {
                        // когда шкала заполнилась, диалог пропадает
                        pd.dismiss();
                    }
                }
            };
            handler.sendEmptyMessageDelayed(0, 1000);
        }


    }
}
