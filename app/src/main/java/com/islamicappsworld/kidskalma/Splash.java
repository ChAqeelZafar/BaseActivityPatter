package com.islamicappsworld.kidskalma;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.widget.ImageView;

public class Splash extends BaseActivity {
    Context context;
    ImageView imageviewsplash;
    private int[] images = {R.drawable.splash_1, R.drawable.splash};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setLayout(R.layout.splashscreen);
        context = this;
        imageviewsplash = (ImageView) findViewById(R.id.imageviewsplash);

//		imageviewsplash.setBackgroundResource(R.drawable.splash_anim);
//        final AnimationDrawable	rocketAnimation = (AnimationDrawable) imageviewsplash.getBackground();
//        rocketAnimation.start();

        Resources res = this.getResources();
        AnimationDrawable anim = new AnimationDrawable();

        Drawable d1 = res.getDrawable(R.drawable.splash_1);
        Drawable d2 = res.getDrawable(R.drawable.splash);

        anim.addFrame(d1, 500);
        anim.addFrame(d2, 500);

        anim.setOneShot(false);
        imageviewsplash.setBackgroundDrawable(anim);
        anim.start();


//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                rocketAnimation.start();
//            }
//        },400);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                int value = User.getInt(User.LANGUAGE, -1, context);
                if (value == -1) {
                    Intent intent = new Intent(Splash.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Intent intent = new Intent(Splash.this, Kalmadetail.class);
                    startActivity(intent);
                    finish();
                }
            }
        }, 5000);


//        new MyAsyncTask().execute();
    }

    private class MyAsyncTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... params) {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {

            int value = User.getInt(User.LANGUAGE, -1, context);
            if (value == -1) {
                Intent intent = new Intent(Splash.this, MainActivity.class);
                startActivity(intent);
                finish();
            } else {
                Intent intent = new Intent(Splash.this, Kalmadetail.class);
                startActivity(intent);
                finish();
            }

        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            return false;
        }
        return false;
    }

}
