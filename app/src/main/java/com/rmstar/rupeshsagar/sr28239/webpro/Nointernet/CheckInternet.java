package com.rmstar.rupeshsagar.sr28239.webpro.Nointernet;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
public class CheckInternet {
    public static String getNetworkInfo(Context context)
    {
        String status=null;
        ConnectivityManager connectivityManager=(ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo=connectivityManager.getActiveNetworkInfo();
        if(networkInfo!=null)
        {
            status="Connected";
            return status;
        }else
        {
            status="Disconnected";
            return status;
        }
    }
}
