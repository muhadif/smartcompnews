package com.docotel.muhadif.third.helper;

import android.content.Context;
import android.provider.Settings;

import com.docotel.muhadif.third.MainApplication;

public class ApplicationHelper {
    public static Context context() {
        return MainApplication.CONTEXT;
    }

    public static String getUID() {
        return Settings.Secure.getString(context().getContentResolver(), Settings.Secure.ANDROID_ID);
    }

}
