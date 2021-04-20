package com.app2gate.hedaya.Utilities.appconfighelper;

import android.text.TextUtils;


public class ValidateData {
    public static boolean isValid(String text)
    {
        if(text!=null) {
            return !text.equals("") && !TextUtils.isEmpty(text) && text.length() > 0;
        }
        else
        {
            return false;
        }
    }
}
