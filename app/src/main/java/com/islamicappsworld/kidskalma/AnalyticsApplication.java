package com.islamicappsworld.kidskalma;

/**
 * Created by Maria on 6/7/2017.
 */

import android.app.Application;

//import com.google.android.gms.analytics.GoogleAnalytics;
//import com.google.android.gms.analytics.Tracker;

public class AnalyticsApplication extends Application {


    /*private static GoogleAnalytics sAnalytics;
    public static Tracker sTracker;
*/
    @Override
    public void onCreate() {
        super.onCreate();

//        sAnalytics = GoogleAnalytics.getInstance(this);
    }

    /**
     * Gets the default {@link Tracker} for this {@link Application}.
     *
     * @return tracker
     */
    /*synchronized public Tracker getDefaultTracker() {
        // To enable debug logging use: adb shell setprop log.tag.GAv4 DEBUG
        if (sTracker == null) {
            sTracker = sAnalytics.newTracker(R.xml.global_tracker);
        }

        return sTracker;
    }*/
}

