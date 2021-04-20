package com.app2gate.hedaya.Utilities.sharedprefrencehelper;


import android.content.Context;
import android.content.SharedPreferences;


import com.google.gson.Gson;

import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;

public class SharedPrefHelper {

    //public static final String SHARED_PREFERENCE_SHOW_GUIDE_KEY = "myres_showGuide";
    public static final String SHARED_PREFERENCE_LANGUAGE_KEY = "hedaya_language";

    public static String getSharedString(Context context, String key) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(context.getPackageName(), MODE_PRIVATE);
        return sharedPreferences.getString(key, "");

    }

    public static int getSharedInt(Context context, String key) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(context.getPackageName(), MODE_PRIVATE);
        return sharedPreferences.getInt(key, 0);
    }

    public static float getSharedFloat(Context context, String key) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(context.getPackageName(), MODE_PRIVATE);
        return sharedPreferences.getFloat(key, 0);
    }

    public static boolean getSharedBoolean(Context context, String key) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(context.getPackageName(), MODE_PRIVATE);
        return sharedPreferences.getBoolean(key, false);
    }

    public static void setSharedString(Context context, String key, String value) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(context.getPackageName(), MODE_PRIVATE);
        sharedPreferences.edit().putString(key, value).apply();
    }

    public static void setSharedInt(Context context, String key, int value) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(context.getPackageName(), MODE_PRIVATE);
        sharedPreferences.edit().putInt(key, value).apply();
    }

    public static void setSharedFloat(Context context, String key, float value) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(context.getPackageName(), MODE_PRIVATE);
        sharedPreferences.edit().putFloat(key, value).apply();
    }

    public static void setSharedBoolean(Context context, String key, boolean value) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(context.getPackageName(), MODE_PRIVATE);
        sharedPreferences.edit().putBoolean(key, value).apply();
    }

    public static void setSharedOBJECT(Context context, String key, Object value) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(context.getPackageName(), MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(value);
        prefsEditor.putString(key, json);
        prefsEditor.apply();
    }

/*    public static Object getSharedOBJECT(Context context, String key) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(context.getPackageName(), MODE_PRIVATE);
        String json = sharedPreferences.getString(key, "");
        Data objData = new Gson().fromJson(json, Data.class);
        return objData;
    }*/



/*    //Arrays
    public static void saveData(Context context, ArrayList<CartModel> mExampleList, String key) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(context.getPackageName(), MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(mExampleList);
        editor.putString(key, json);
        editor.apply();
    }*/

/*    private void loadData(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(context.getPackageName(), MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("task list", null);
        Type type = new TypeToken<ArrayList<CartModel>>() {
        }.getType();
        mExampleList = gson.fromJson(json, type);

        if (mExampleList == null) {
            mExampleList = new ArrayList<>();
        }
    }*/
}
