package com.example.twittertest;

import android.app.Application;

import com.twitter.sdk.android.core.Twitter;

/**
 * Created by ishitasinha on 09/06/17.
 */

public class TwitterTestApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Twitter.initialize(this);
    }
}
