package com.app2gate.hedaya.Utilities;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

import com.app2gate.hedaya.Utilities.sharedprefrencehelper.SharedPrefHelper;


public class MyTextView extends androidx.appcompat.widget.AppCompatTextView {
    String Lang;

    public MyTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        Lang = new SharedPrefHelper().getSharedString(context, SharedPrefHelper.SHARED_PREFERENCE_LANGUAGE_KEY);
        init();


    }

    public MyTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Lang = new SharedPrefHelper().getSharedString(context, SharedPrefHelper.SHARED_PREFERENCE_LANGUAGE_KEY);
        init();
    }

    public MyTextView(Context context) {
        super(context);
        Lang = new SharedPrefHelper().getSharedString(context, SharedPrefHelper.SHARED_PREFERENCE_LANGUAGE_KEY);
        init();
    }

    private void init() {


        if (!isInEditMode()) {
            if (Lang.equals("ar")) {
                Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/kufireg.ttf");
                setTypeface(tf);
            } else {
                Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/robotoregular.ttf");
                setTypeface(tf);
            }

        }
    }

}
