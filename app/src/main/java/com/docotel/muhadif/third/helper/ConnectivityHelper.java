package com.docotel.muhadif.third.helper;

import android.content.Context;
import android.net.ConnectivityManager;

import static android.net.NetworkInfo.State;

public class ConnectivityHelper {
    public static boolean isConnectedToNetwork(Context context) {
        ConnectivityManager connectivityManager =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);


        boolean isConnected = false;
        if (connectivityManager != null) {
            if (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == State.CONNECTED ||
                    connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == State.CONNECTED) {
                isConnected = true;
            }
        }

        return isConnected;
    }
}
