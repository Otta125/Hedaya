package com.app2gate.hedaya.Utilities;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

import com.app2gate.hedaya.Utilities.sharedprefrencehelper.SharedPrefHelper;


public class MyTextViewBold extends androidx.appcompat.widget.AppCompatTextView {
    String Lang;

    public MyTextViewBold(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        Lang = new SharedPrefHelper().getSharedString(context, SharedPrefHelper.SHARED_PREFERENCE_LANGUAGE_KEY);
        init();


    }

    public MyTextViewBold(Context context, AttributeSet attrs) {
        super(context, attrs);
        Lang = new SharedPrefHelper().getSharedString(context, SharedPrefHelper.SHARED_PREFERENCE_LANGUAGE_KEY);
        init();
    }

    public MyTextViewBold(Context context) {
        super(context);
        Lang = new SharedPrefHelper().getSharedString(context, SharedPrefHelper.SHARED_PREFERENCE_LANGUAGE_KEY);
        init();
    }

    private void init() {
        if (!isInEditMode()) {
            if (Lang.equals("ar")) {
                Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/kufibold.ttf");
                setTypeface(tf);
            } else {
                Typeface tf =
                        Typeface.createFromAsset(
                                getContext().getAssets(), "fonts/robotobold.ttf");
                setTypeface(tf);
            }
        }
    }

}
