package com.islamicappsworld.kidskalma;

import java.util.Locale;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


import com.crashlytics.android.Crashlytics;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.NativeExpressAdView;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.firebase.analytics.FirebaseAnalytics;

import io.fabric.sdk.android.Fabric;
//import com.google.android.gms.analytics.HitBuilders;
//import com.google.android.gms.analytics.Tracker;

public class BaseActivity extends Activity {
	public InterstitialAd interstitial;
	private FirebaseAnalytics mFirebaseAnalytics;
	int arrDrawables[] = {R.drawable.a, R.drawable.b, R.drawable.c,
			R.drawable.d, R.drawable.e, R.drawable.f};
	String arrTrans[] = {};
	String arrTranslitration[] = {
			"Laa ilaaha illal Lahoo Mohammadur Rasool Ullah",
			"Ash hado An Laa ilaaha illal Laho Wahtha Ho La Shareekala Hoo Wa Ash Hado Anna Mohammadan Abdo Hoo Wa Rasoolohoo.",
			"Subhanallahe Wal Hamdulillahe Wa Laa ilaha illal Laho Wallahooakbar. Wala Haola Wala Quwwata illa billahil AliYil Azeem.",
			"Laa ilaha illal Lahoo Wahdahoo Laa Shareekalahoo Lahul Mulko Walahul Hamdo Yuhee Wa Yumeeto Wa Hoa Haiy Yul La Yamooto Abadan Abada Zul Jalal Lay Wal Ikraam Beyadihil Khair. Wa hoa Ala Kulli Shai In Qadeer.",
			"Astaghfirullah Rabbi Min Kullay Zambin Aznabtuho Amadan Ao Khat An Sirran Ao Alaniatan Wa Atoobo ilaihe Minaz Zambil Lazee Aalamo Wa Minaz Zambil Lazee La Aalamo innaka Anta Allamul Ghuyoobi Wa Sattaarul Oyobi Wa Ghaffaruz Zunoobi Wala Haola Wala Quwwata illa billahil AliYil Azeem.",
			"Allah Humma inni Aaoozubika Min An Oshrika Beka Shai Aown Wa Anaa Aalamo Behi Wasthaghfiruka Lima La A'lamu Behi Tubtu Anho Wa Tabarrato Minal Kufri Washshirki Wal Kizbi Wal Jheebati Wal Bidaati Wan Nameemati Wal Fawahishi Wal Bohtani Wal Maasi Kulliha Wa Aslamtoo Wa Aamantoo Wa Aqoolo Laa ilaaha illal Lahoo Mohammadur Rasool Ullah."};
	String arrKalmaName[] = {"Kalma Tayyabah", "Kalma Shahaadat",
			"Kalma Tamjeed", "Kalma Tauhid", "Kalma Astaghfar",
			"Kalma Rud-e-Kuffr"};
	String arrKalmaNameEng[] = {"Kalma Tayyabah", "Kalma Shahaadat",
			"Kalma Tamjeed", "Kalma Tauhid", "Kalma Astaghfar",
			"Kalma Rud-e-Kuffr"};
	public static final int ENG = 0;
	public static final int URDU = 1;
	public static final int INDONESIA = 2;
	public static final int TURKEY = 3;
	public static final int SPANISH = 4;

	public String TAG="baseActivity=";

//	private NativeExpressAdView mAdView;
//	private VideoController mVideoController;
//	private Tracker sTracker;
	public MediaPlayer mediaPlayer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		changeConfig();
		MobileAds.initialize(this, getResources().getString(R.string.admob_app_id));


		mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
		Fabric.with(this, new Crashlytics());

	}


	private AdView adView;

	public void showads(){
		adView = findViewById(R.id.adView);
		AdRequest adRequest = new AdRequest.Builder().addTestDevice(getResources().getString(R.string.huawei_test_deivce_id))
				.addTestDevice(AdRequest.DEVICE_ID_EMULATOR).build();
		adView.loadAd(adRequest);
		adView.setAdListener(new AdListener() {
			@Override
			public void onAdLoaded() {
				adView.setVisibility(View.VISIBLE);
			}

			@Override
			public void onAdFailedToLoad(int errorCode) {
				adView.setVisibility(View.GONE);
			}
		});


	}

	protected void setLayout(int layOut) {
		setContentView(layOut);

	}

//	public void nativeExpressAds(){
//
//		// Locate the NativeExpressAdView.
//		mAdView = (NativeExpressAdView) findViewById(R.id.adView2);
//
//		// Set its video options.
//		mAdView.setVideoOptions(new VideoOptions.Builder()
//				.setStartMuted(true)
//				.build());
//
//		// The VideoController can be used to get lifecycle events and info about an ad's video
//		// asset. One will always be returned by getVideoController, even if the ad has no video
//		// asset.
//		mVideoController = mAdView.getVideoController();
//		mVideoController.setVideoLifecycleCallbacks(new VideoController.VideoLifecycleCallbacks() {
//			@Override
//			public void onVideoEnd() {
//				Log.d("", "Video playback is finished.");
//				super.onVideoEnd();
//			}
//		});
//
//		// Set an AdListener for the AdView, so the Activity can take action when an ad has finished
//		// loading.
//		mAdView.setAdListener(new AdListener() {
//
//			@Override
//			public void onAdLoaded() {
//				mAdView.setVisibility(View.VISIBLE);
//
//				if (mVideoController.hasVideoContent()) {
//					Log.d("", "Received an ad that contains a video asset.");
//
//				} else {
//					Log.d("", "Received an ad that does not contain a video asset.");
//
//				}
//			}
//
//			@Override
//			public void onAdFailedToLoad(int i) {
//				super.onAdFailedToLoad(i);
//
//				mAdView.setVisibility(View.GONE);
//			}
//		});
//
//
//		mAdView.loadAd(new AdRequest.Builder().addTestDevice(getResources().getString(R.string.huawei_test_deivce_id))
//				.addTestDevice(AdRequest.DEVICE_ID_EMULATOR).build());
//
//	}

	public void playSound(int num) {

		try {
			if (mediaPlayer != null) {
				if (mediaPlayer.isPlaying()) {
					mediaPlayer.stop();
				}
				mediaPlayer.reset();
				mediaPlayer.release();
			}
			mediaPlayer = new MediaPlayer();
			AssetFileDescriptor descriptor = getAssets().openFd(
					String.valueOf(num) + ".mp3");
			mediaPlayer.setDataSource(descriptor.getFileDescriptor(),
					descriptor.getStartOffset(), descriptor.getLength());
			descriptor.close();

			mediaPlayer.prepare();
			mediaPlayer.setVolume(1f, 1f);
			mediaPlayer.start();
		} catch (Exception e) {
			Log.e("IOException playBeep ", "" + e);
		}
	}

	public boolean isOnline() {
		ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo netInfo = cm.getActiveNetworkInfo();
		if (netInfo != null && netInfo.isConnectedOrConnecting()) {
			return true;
		}
		return false;
	}

	public void setNbFont(TextView view) {

		Typeface font = Typeface.createFromAsset(getAssets(), "nb_obese.ttf");
		view.setTypeface(font);
	}

	public void setNormalFont(TextView view) {

		Typeface font = Typeface.createFromAsset(getAssets(), "ARLRDBD.TTF");
		view.setTypeface(font);
	}



	protected void createFullAdd() {



		// Create the interstitial.
		interstitial = new InterstitialAd(this);
		interstitial.setAdUnitId(getString(R.string.fullAddId));
		// Create ad request.
		AdRequest fadRequest = new AdRequest.Builder().addTestDevice(getResources().getString(R.string.huawei_test_deivce_id))
				.addTestDevice(AdRequest.DEVICE_ID_EMULATOR).build();
		// Begin loading your interstitial.
		interstitial.loadAd(fadRequest);

		interstitial.setAdListener(new AdListener(){
			@Override
			public void onAdFailedToLoad(int i) {
				super.onAdFailedToLoad(i);

			}

			@Override
			public void onAdLoaded() {
				super.onAdLoaded();


			}
		});

		if (interstitial.isLoaded()) {
			interstitial.show();
		}



//		interstitial.setAdListener(new AdListener() {
//			@Override
//			public void onAdFailedToLoad(int errorCode) {
//				// TODO Auto-generated method stub
//				super.onAdFailedToLoad(errorCode);
//				Log.i("", "errorCode:" + errorCode);
//			}
//			@Override
//			public void onAdOpened() {
//				// TODO Auto-generated method stub
//				super.onAdOpened();
//				Log.i("", "onAdOpened");
//			}
//			@Override
//			public void onAdLoaded() {
//				// TODO Auto-generated method stub
//				super.onAdLoaded();
//				interstitial.show();
//				Log.i("", "onAdLoaded");
//			}
//		});

	}

	private void changeConfig() {
		Resources res = getApplication().getResources();
		// Change locale settings in the app.
		DisplayMetrics dm = res.getDisplayMetrics();
		android.content.res.Configuration conf = res.getConfiguration();
		int language = User.getInt(User.LANGUAGE, 0, getApplication());
		String lang = "en";
		switch (language) {
			case 0 :
				lang = "en";
				break;
			case 1 :
				lang = "ru";
				break;
			case 2 :
				lang = "in";
				break;
			case 3:
				lang= "Tr";
				break;
			case 4:
				lang="Sp";
				break;
			default :
				lang = "en";
				break;
		}

		conf.locale = new Locale(lang);
		res.updateConfiguration(conf, dm);
	}


}
