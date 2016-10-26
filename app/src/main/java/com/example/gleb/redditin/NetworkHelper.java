package com.example.gleb.redditin;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetworkHelper {
    private final String LOG_TAG = this.getClass().getCanonicalName();
    private Context context;
    private static NetworkHelper instance = null;

    public static NetworkHelper getInstance(Context context) {
        if (instance == null){
            instance = new NetworkHelper(context);
        }

        return instance;
    }

    private NetworkHelper(Context context) {
        this.context = context;
    }

    /*
    * Check has device a network connection
    * @return boolean        Has device network connection
    * */
    public boolean isNetworkConnection(){
        boolean hasConnection = false;

        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = cm.getActiveNetworkInfo();

        if (networkInfo != null){
            hasConnection = true;
        }

        return hasConnection;
    }
}
