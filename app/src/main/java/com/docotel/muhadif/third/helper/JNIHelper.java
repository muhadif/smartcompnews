package com.docotel.muhadif.third.helper;

import android.util.Log;

public class JNIHelper {
    static {
        System.loadLibrary("native-lib");
    }

    private static native String getApiKey();
    private static native String getCertificateKey();
    private static native String getEncryptionKey();

    public static String getApi(){
        return getApiKey();
    }

    public static String getCertificate(){
        Log.d("CERT", getCertificateKey());
        return getCertificateKey();
    }

    public static String getEncryption(){
        return getEncryptionKey();
    }
}
