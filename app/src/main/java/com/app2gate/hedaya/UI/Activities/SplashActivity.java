package com.app2gate.hedaya.UI.Activities;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;


import com.app2gate.hedaya.UI.main.MainActivity;
import com.app2gate.hedaya.R;
import com.app2gate.hedaya.Utilities.appconfighelper.AppConfigHelper;
import com.app2gate.hedaya.Utilities.appconfighelper.ValidateData;
import com.app2gate.hedaya.Utilities.sharedprefrencehelper.SharedPrefHelper;

import java.util.Locale;

public class SplashActivity extends AppCompatActivity {

    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        context =this;

        // Dynamic links
/*        FirebaseDynamicLinks.getInstance()
                .getDynamicLink(getIntent())
                .addOnSuccessListener(this, new OnSuccessListener<PendingDynamicLinkData>() {
                    @Override
                    public void onSuccess(PendingDynamicLinkData pendingDynamicLinkData) {
                        // Get deep link from result (may be null if no link is found)
                        Uri deepLink = null;
                        if (pendingDynamicLinkData != null) {
                            deepLink = pendingDynamicLinkData.getLink();
                            String Key =  deepLink.getQueryParameter("id");
                            SharedPrefHelper.setSharedString(context, SharedPrefHelper.SHARED_PREFERENCE_REFERRAL, Key);
                           // Toast.makeText(SplashActivity.this, " " + Key, Toast.LENGTH_SHORT).show();
                          //  edtPRferelCode.setText(" " + deepLink);
                        }
                    }
                })
                .addOnFailureListener(this, new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w("ERROR", "getDynamicLink:onFailure", e);
                    }
                });*/
        final Handler handler = new Handler();
        handler.postDelayed(() -> getLocalLanguage(), 1500);

    }

    private void start_Activity() {


            AppConfigHelper.gotoActivityFinish(this, MainActivity.class, true);

    }

    @SuppressLint("WrongConstant")
    private void getLocalLanguage() {
        try {
            String lang = SharedPrefHelper.getSharedString(SplashActivity.this, SharedPrefHelper.SHARED_PREFERENCE_LANGUAGE_KEY);
            if (ValidateData.isValid(lang)) {
                //Toast.makeText(this, "shared done" + lang, Toast.LENGTH_SHORT).show();

                if (lang.equals(AppConfigHelper.ENGLISH_LANGUAGE)) {
                    // Toast.makeText(this, "english shared", Toast.LENGTH_SHORT).show();
                    SharedPrefHelper.setSharedString(SplashActivity.this, SharedPrefHelper.SHARED_PREFERENCE_LANGUAGE_KEY, AppConfigHelper.ENGLISH_LANGUAGE);
                    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
                        getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
                        getWindow().getDecorView().setLayoutDirection(View.TEXT_DIRECTION_LTR);
                    }
                } else {
                    SharedPrefHelper.setSharedString(SplashActivity.this, SharedPrefHelper.SHARED_PREFERENCE_LANGUAGE_KEY, AppConfigHelper.ARABIC_LANGUAGE);
                    // Toast.makeText(this, "arabic shred", Toast.LENGTH_SHORT).show();
                    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
                        getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
                        getWindow().getDecorView().setLayoutDirection(View.TEXT_DIRECTION_RTL);
                    }
                }
            } else {
                // Toast.makeText(this, "Noo shared", Toast.LENGTH_SHORT).show();
                //start with the default lang of the  device
                if (String.valueOf(Locale.getDefault()).contains(AppConfigHelper.ENGLISH_LANGUAGE)) {
                    // Toast.makeText(this, "english noosh  " + Locale.getDefault(), Toast.LENGTH_SHORT).show();

                    SharedPrefHelper.setSharedString(SplashActivity.this, SharedPrefHelper.SHARED_PREFERENCE_LANGUAGE_KEY, AppConfigHelper.ENGLISH_LANGUAGE);
                    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
                        getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
                        getWindow().getDecorView().setLayoutDirection(View.TEXT_DIRECTION_LTR);
                    }
                } else {
                    //Toast.makeText(this, "arabic noosh", Toast.LENGTH_SHORT).show();

                    SharedPrefHelper.setSharedString(SplashActivity.this, SharedPrefHelper.SHARED_PREFERENCE_LANGUAGE_KEY, AppConfigHelper.ARABIC_LANGUAGE);
                    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
                        getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
                        getWindow().getDecorView().setLayoutDirection(View.TEXT_DIRECTION_RTL);
                    }
                }
            }

/*            SharedPrefHelper.setSharedString(SplashActivity.this, SharedPrefHelper.SHARED_PREFERENCE_LANGUAGE_KEY, AppConfigHelper.ENGLISH_LANGUAGE);
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
                getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
                getWindow().getDecorView().setLayoutDirection(View.TEXT_DIRECTION_LTR);
            }*/
            start_Activity();
        } catch (Exception objException) {
            objException.printStackTrace();
        }
    }
}

