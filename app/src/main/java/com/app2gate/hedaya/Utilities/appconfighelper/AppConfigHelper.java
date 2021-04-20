package com.app2gate.hedaya.Utilities.appconfighelper;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LayoutAnimationController;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.core.view.GravityCompat;



import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class AppConfigHelper {


    //public static final String PHOTO_URL = BuildConfig.BASE_URL_PHOTO;
    public static final String PHOTO_URL = "https://egybusiness.net/myres-t/";
    public static final String ARABIC_LANGUAGE = "ar";
    public static final String ENGLISH_LANGUAGE = "en";

/*    public static void SetProgColor(ProgressBar progressBar,Context context,int Color){
        progressBar = new android.widget.ProgressBar(
                context,
                null,
                android.R.attr.progressBarStyle);

        progressBar.getIndeterminateDrawable().setColorFilter(ContextCompat.getColor(context,Color),
                android.graphics.PorterDuff.Mode.MULTIPLY);
    }*/
    public static void overrideFonts(final Context context, final View v) {
        try {
            if (v instanceof ViewGroup) {
                ViewGroup vg = (ViewGroup) v;
                for (int i = 0; i < vg.getChildCount(); i++) {
                    View child = vg.getChildAt(i);
                    overrideFonts(context, child);
                }
            } else if (v instanceof TextView) {
                ((TextView) v).setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/kufi.ttf"));
            }
        } catch (Exception e) {
        }
    }

    public static boolean isOnline(Context context) {
        ConnectivityManager conMgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = conMgr.getActiveNetworkInfo();

        return !(netInfo == null || !netInfo.isConnected() || !netInfo.isAvailable());
    }

    public static void makeFullScreen(Activity activity) {
        try {
            View decorView = activity.getWindow().getDecorView();
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_IMMERSIVE
                    // Set the content to appear under the system bars so that the
                    // content doesn't resize when the system bars hide and show.
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    // Hide the nav bar and status bar
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_FULLSCREEN);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setLayoutAnim_slidedownfromtop(ViewGroup panel, Context ctx) {
        try {
            AnimationSet set = new AnimationSet(true);

            Animation animation = new AlphaAnimation(0.0f, 1.0f);
            animation.setDuration(100);
            set.addAnimation(animation);

            animation = new TranslateAnimation(
                    Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, 0.0f,
                    Animation.RELATIVE_TO_SELF, -1.0f, Animation.RELATIVE_TO_SELF, 0.0f
            );
            animation.setDuration(500);
            set.addAnimation(animation);

            LayoutAnimationController controller =
                    new LayoutAnimationController(set, 0.25f);
            panel.setLayoutAnimation(controller);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void setLayoutAnim_slideLeftfromRight(ViewGroup panel, Context ctx) {
        try {
            AnimationSet set = new AnimationSet(true);

            Animation animation = new AlphaAnimation(0.0f, 1.0f);
            animation.setDuration(100);
            set.addAnimation(animation);

            animation = new TranslateAnimation(
                    Animation.RELATIVE_TO_SELF, -1.0f, Animation.RELATIVE_TO_SELF, 0.0f,
                    Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, 0.0f
            );
            animation.setDuration(500);
            set.addAnimation(animation);

            LayoutAnimationController controller =
                    new LayoutAnimationController(set, 0.25f);
            panel.setLayoutAnimation(controller);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public static void setLayoutAnim_slideRightfromLeft(ViewGroup panel, Context ctx) {
        try {
            AnimationSet set = new AnimationSet(true);

            Animation animation = new AlphaAnimation(0.0f, 1.0f);
            animation.setDuration(100);
            set.addAnimation(animation);

            animation = new TranslateAnimation(
                    Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, -1.0f,
                    Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, 0.0f
            );
            animation.setDuration(500);
            set.addAnimation(animation);

            LayoutAnimationController controller =
                    new LayoutAnimationController(set, 0.25f);
            panel.setLayoutAnimation(controller);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public static void setLayoutAnim_slideup(ViewGroup panel, Context ctx) {
        try {
            AnimationSet set = new AnimationSet(true);

            /*
             * Animation animation = new AlphaAnimation(1.0f, 0.0f);
             * animation.setDuration(200); set.addAnimation(animation);
             */

            Animation animation = new AlphaAnimation(0.0f, 1.0f);
            animation.setDuration(100);
            set.addAnimation(animation);

            animation = new TranslateAnimation(
                    Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF,
                    0.0f, Animation.RELATIVE_TO_SELF, 0.0f,
                    Animation.RELATIVE_TO_SELF, -1.0f);
            animation.setDuration(500);
            set.addAnimation(animation);
            animation.setAnimationListener(new Animation.AnimationListener() {

                @Override
                public void onAnimationStart(Animation animation) {

                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    // MapContacts.this.mapviewgroup.setVisibility(View.INVISIBLE);

                }
            });
            set.addAnimation(animation);

            LayoutAnimationController controller = new LayoutAnimationController(
                    set, 0.25f);
            panel.setLayoutAnimation(controller);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public static Bitmap getBitmapFromView(View view) {
        Bitmap returnedBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(returnedBitmap);
        Drawable bgDrawable = view.getBackground();
        if (bgDrawable != null) {
            //has background drawable, then draw it on the canvas
            bgDrawable.draw(canvas);
        } else {
            //does not have background drawable, then draw white background on the canvas
            canvas.drawColor(Color.WHITE);
        }
        view.draw(canvas);
        return returnedBitmap;
    }

    public static void makeTransparent(Activity activity) {
        //make status bar transparent
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = activity.getWindow(); // in Activity's onCreate() for instance
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.TYPE_STATUS_BAR_PANEL);
        }
/*
        View decorView = activity.getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);*/
    }

    public static void clearTransparent(Activity activity) {
        //make status bar transparent
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = activity.getWindow(); // in Activity's onCreate() for instance
            w.clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
            w.clearFlags(WindowManager.LayoutParams.TYPE_STATUS_BAR_PANEL);
        }
    }

    public static void changeStatusBar(Activity activity, int color) {
        //make status bar transparent
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window w = activity.getWindow(); // in Activity's onCreate() for instance
            w.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            w.setStatusBarColor(color);
        }
    }

    public static void setLightStatusBar(View view, Activity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            int flags = view.getSystemUiVisibility();
            flags |= View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
            view.setSystemUiVisibility(flags);
            activity.getWindow().setStatusBarColor(Color.argb(0, 0, 0, 0));
        }
    }

    public static String from24hour(Context context, String timeValue) {
        SimpleDateFormat displayFormat = new SimpleDateFormat("hh:mm a");
        SimpleDateFormat parseFormat = new SimpleDateFormat("HH:mm:ss");
        Date date = null;
        try {
            date = parseFormat.parse(timeValue);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return displayFormat.format(date);

    }

    public static String addLeftzer0(String number) {
        if (number.length() == 1)
            return "0" + number;
        else
            return number;
    }

    public static void gotoActivity(Activity activity, Class cls, boolean isFinishCuurentActivity) {
        try {
            Intent objIntent = new Intent(activity, cls);
            objIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
            activity.startActivity(objIntent);
          /*  if (isFinishCuurentActivity) {
                activity.finish();
            }*/
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void gotoActivityFinish(Activity activity, Class cls, boolean isFinishCuurentActivity) {
        try {
            Intent objIntent = new Intent(activity, cls);
            objIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
            activity.startActivity(objIntent);
            if (isFinishCuurentActivity) {
                activity.finish();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void setCustomStatusBar(Activity activity, int color) {
        try {
            Window window = activity.getWindow();
            //window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                // window.setStatusBarColor(ContextCompat.getColor(activity,color));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setLightStatusBar(View view, Activity activity, int color) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

            int flags = view.getSystemUiVisibility();
            flags |= View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
            view.setSystemUiVisibility(flags);
            activity.getWindow().setStatusBarColor(color);
        }
    }

    public static void toggleStatusBar(Activity activity, boolean isShow) {
        if (isShow) {
            if (Build.VERSION.SDK_INT < 16) {
                activity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                        WindowManager.LayoutParams.FLAG_FULLSCREEN);
            } else {
                View decorView = activity.getWindow().getDecorView();
                // Hide Status Bar.
                int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
                decorView.setSystemUiVisibility(uiOptions);
            }
        } else {
            if (Build.VERSION.SDK_INT < 16) {
                activity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
            } else {
                View decorView = activity.getWindow().getDecorView();
                // Show Status Bar.
                int uiOptions = View.SYSTEM_UI_FLAG_VISIBLE;
                decorView.setSystemUiVisibility(uiOptions);
            }
        }
    }
    public static void hideKeyboardFrom(Context context, View view) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
    public static void hideKeyboard(Activity activity) {
        try {
            InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
            //Find the currently focused view, so we can grab the correct window token from it.
            View view = activity.getCurrentFocus();
            //If no view currently has focus, create a new one, just so we can grab a window token from it
            if (view == null) {
                view = new View(activity);
            }
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Point screenDimensions(Activity activity) {
        try {
            Point size = new Point();
            Display display = activity.getWindowManager().getDefaultDisplay();
            display.getSize(size);
            return size;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void setOffetsSpinner(Spinner spinner) {
        try {
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
                // android:overlapAnchor="false" use to make spinner open form bottom of view
                // android:overlapAnchor="false" is working in api >=21 so use this step
                spinner.setDropDownVerticalOffset(30);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

/*
    public static void changeBackArrow(Activity activity, FrameLayout view) {
        try {
            if ((activity.getBaseContext().getResources().getConfiguration().locale.getLanguage()).equals(AppConfigHelper.ARABIC_LANGUAGE)) {
                //change arrow_back Image view in arabic Language
                view.setImageResource(R.drawable.ic_keyboard_right_arrow_button);

            } else {
                //change arrow_back Image view in english Language
                view.setImageResource(R.drawable.ic_left_arrow_key);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
*/

    public static void changepasswordAlignment(Activity activity, EditText view) {


        try {
            if ((activity.getBaseContext().getResources().getConfiguration().locale.getLanguage()).equals(AppConfigHelper.ARABIC_LANGUAGE)) {
                //change arrow_back Image view in arabic Language

                view.setGravity(GravityCompat.END);

            } else {
                //change arrow_back Image view in english Language
                view.setGravity(GravityCompat.START);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /////


    /////
    public static boolean isNowBetweenHours(String leftBoundaryHours, String rightBoundaryHours) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");

        String[] parts = rightBoundaryHours.split(":");
        String hours = parts[0];
        Date rightTimeBoundary;
        if (Integer.valueOf(hours) < 12) {
            rightTimeBoundary = formatter.parse("1970-01-02 " + rightBoundaryHours);
        } else {
            rightTimeBoundary = formatter.parse("1970-01-01 " + rightBoundaryHours);
        }

        //add the hand specified time to 1970-01-01 to create left/right boundaries.
        Date leftTimeBoundary = formatter.parse("1970-01-01 " + leftBoundaryHours);

        //extract only the hours, minutes and seconds from the current Date.
        DateFormat extract_time_formatter = new SimpleDateFormat("HH:mm:ss");

        //Get the current time, put that into a string, add the 1970-01-01,
        Date now = formatter.parse("1970-01-01 " +
                extract_time_formatter.format(new Date()));

        //So it is easy now, with the year, month and day forced as 1970-01-01
        //all you do is make sure now is after left, and now is before right.
        if (now.after(leftTimeBoundary) && now.before(rightTimeBoundary))
            return true;
        else
            return false;
    }


}
