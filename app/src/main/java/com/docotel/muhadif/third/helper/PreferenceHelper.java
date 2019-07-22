package com.docotel.muhadif.third.helper;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.Gson;

import java.util.Arrays;
import java.util.List;

public class PreferenceHelper {

    public static final String LOGIN_STATE = "login_state";
    public static final String LOGGED_ACCOUNT = "logged_account";
    public static final String NEWS_DATA = "news_data";
    public static final String ARTICLE_DATA = "article_data";
    public static final String NEWEST_DATA = "newest_data";
    public static final String BOOKMARK_NEWS = "bookmark_NEWS";


    private SharedPreferences sharedPreferences;

    public PreferenceHelper(Context context) {
        sharedPreferences = getSharedPreferences(context);
    }

    public SharedPreferences getSharedPreferences(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    public void putString(String key, String content) {
        sharedPreferences.edit().putString(key, content).apply();
    }



    public <T> void putList(String key, List<T> list){
        Gson gson = new Gson();
        String json = gson.toJson(list);
        putString(key, json);
    }

    public String getString(String key){
        return sharedPreferences.getString(key, null);
    }

    public <T> List<T> getList(String key, final Class<T[]> cls){
        Gson gson = new Gson();
        String json = getString(key);
        T[] list = gson.fromJson(json, cls);
        return list != null ? Arrays.asList(list) : null;
    }

    public void putBoolean(String key, Boolean content) {
        sharedPreferences.edit().putBoolean(key, content).apply();
    }

    public Boolean getBoolean(String key) {
        return sharedPreferences.getBoolean(key, false);
    }

    public static Boolean isLogin(Context context){
        return new PreferenceHelper(context).getBoolean(LOGIN_STATE);
    }
}
