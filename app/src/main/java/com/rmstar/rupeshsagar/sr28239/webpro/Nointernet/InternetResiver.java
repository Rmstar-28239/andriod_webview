package com.rmstar.rupeshsagar.sr28239.webpro.Nointernet;
import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.rmstar.rupeshsagar.sr28239.webpro.R;
public class InternetResiver extends BroadcastReceiver {
    Dialog dialog;
    @Override
    public void onReceive(Context context, Intent intent) {
        String status=CheckInternet.getNetworkInfo(context);
        dialog = new Dialog(context,android.R.style.Theme_NoTitleBar_Fullscreen);
        dialog.setContentView(R.layout.dilog_internet);
        Button restartapp = (Button)dialog.findViewById(R.id.restartapp);
        if(status.equals("Connected"))
        {
            dialog.dismiss();
           // Toast.makeText(context.getApplicationContext(), "Internet Connection Available", Toast.LENGTH_SHORT).show();
        }else
        {
            dialog.show();
            Toast.makeText(context.getApplicationContext(), "Not Available Internet Connection ", Toast.LENGTH_SHORT).show();
        }

        restartapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=((Activity) context).getIntent();
                ((Activity) context).finish();
                context.startActivity(intent1);

            }
        });
    }
}
