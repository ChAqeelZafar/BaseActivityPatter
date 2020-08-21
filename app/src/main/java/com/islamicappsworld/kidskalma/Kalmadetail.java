package com.islamicappsworld.kidskalma;

import java.util.Timer;
import java.util.TimerTask;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class Kalmadetail extends BaseActivity {

	RelativeLayout relativelayoput;
	Context context;
	TextView fisrtKalmaa, secondKalmaa, ThirdKalmaa, FourthKalmaa, fifthKalmaa,
			sixKalmaa;
	Button btnshare, info, btnrate, btnFeedback, btnsettings;
	LinearLayout fisrtKalmah, secondKalmah, ThirdKalmah, FourthKalmah, fifthKalmah,
			sixKalmah;
	Animation animZoomin, animZoomOut, rotate;
	TextView tvHeader;
	private LinearLayout[] kalmaArray;
	QuickAction mQuickAction;

	String languge []= {"Kalmah","کالمہ","Kalmah","Kalimah","Kalmaah","Wort","密码"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.kalmadetail);
		context = this;

		tvHeader = (TextView) findViewById(R.id.tvHeader);
		showads();
		setNbFont(tvHeader);
		relativelayoput = (RelativeLayout) findViewById(R.id.relativelayoput);
		fisrtKalmah = (LinearLayout)findViewById(R.id.fisrtKalma);
		secondKalmah = (LinearLayout)findViewById(R.id.secondKalma);
		ThirdKalmah = (LinearLayout)findViewById(R.id.ThirdKalma);
		FourthKalmah = (LinearLayout)findViewById(R.id.FourthKalma);
		fifthKalmah = (LinearLayout)findViewById(R.id.fifthKalma);
		sixKalmah = (LinearLayout)findViewById(R.id.sixKalma);


		fisrtKalmaa = (TextView) findViewById(R.id.txtfisrtKalma);
		secondKalmaa = (TextView) findViewById(R.id.txtsecondKalma);
		ThirdKalmaa = (TextView) findViewById(R.id.txtThirdKalma);
		FourthKalmaa = (TextView) findViewById(R.id.txtFourthKalma);
		fifthKalmaa = (TextView) findViewById(R.id.txtfifthKalma);
		sixKalmaa = (TextView) findViewById(R.id.txtsixKalma);
		btnrate = (Button) findViewById(R.id.btnrate);
		btnsettings = (Button) findViewById(R.id.btnsettings);
		btnshare = (Button) findViewById(R.id.btnshare);
		btnFeedback = (Button) findViewById(R.id.btnFeedback);
		selectLang();

		btnsettings.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				mQuickAction = new QuickAction(context);
				mQuickAction.show(v);
				mQuickAction.setOnDismissListener(new QuickAction.OnDismissListener() {
					@Override
					public void onDismiss() {
						selectLang();
					}
				});
			}
		});




		btnFeedback.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				Intent email = new Intent(Intent.ACTION_SEND);
				email.putExtra(Intent.EXTRA_EMAIL,
						new String[]{"suave.android@gmail.com"});
				email.putExtra(Intent.EXTRA_SUBJECT,
						"Comments and Suggestions" + " - " + "Kids Kalma"
								+ "&to=" + "islamicappsworld@gmail.com" + getPackageName());
				email.putExtra(Intent.EXTRA_TEXT, "");
				email.setType("message/rfc822");
				startActivity(Intent.createChooser(email, "Choose an Email client :"));
			}
		});
		btnrate.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intentR = new Intent(Intent.ACTION_VIEW);
				intentR.setData(Uri.parse("market://details?id="
						+ getPackageName()));
				startActivity(intentR);
			}
		});
		// btnBack = (Button) findViewById(R.id.btnBack);
		fisrtKalmaa.setVisibility(View.VISIBLE);
		// fisrtKalma.startAnimation(animZoomin);
		kalmaArray = new LinearLayout[] { fisrtKalmah, secondKalmah, ThirdKalmah,
				FourthKalmah, fifthKalmah, sixKalmah };
		showDelayedImages();

		// load the animation
		animZoomin = AnimationUtils.loadAnimation(getApplicationContext(),
				R.anim.zoom_in);
		animZoomOut = AnimationUtils.loadAnimation(getApplicationContext(),
				R.anim.zoom_out);
		rotate = AnimationUtils.loadAnimation(getApplicationContext(),
				R.anim.rotate);

		info = (Button) findViewById(R.id.info);
		info.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intnt = new Intent(Kalmadetail.this, infokalma.class);
				startActivity(intnt);
				finish();

			}
		});

		btnshare.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent share = new Intent(Intent.ACTION_SEND);
				share.setType("text/plain");
				String link = "http://tinyurl.com/KidsKalmaApp";
				String shareText = "Kids kalma is free to download App for kids. "
						+ System.getProperty("line.separator")
						+ "Check this out!"
						+ System.getProperty("line.separator") + link;
				String sharSubject = "Kids Kalma";
				share.putExtra(Intent.EXTRA_SUBJECT, sharSubject);
				share.putExtra(Intent.EXTRA_TEXT, shareText);
				startActivity(Intent.createChooser(share, "Share Via"));
			}
		});

		final Intent intFirst = new Intent(Kalmadetail.this,
				kalmadescriptionfile.class);

		fisrtKalmah.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
//				createFullAdd();

				intFirst.putExtra("kalma", 0);
				startActivity(intFirst);
				finish();

			}
		});
		secondKalmah.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				// TODO Auto-generated method stub
//				createFullAdd();

				intFirst.putExtra("kalma", 1);
				startActivity(intFirst);
				finish();
			}
		});
		ThirdKalmah.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				intFirst.putExtra("kalma", 2);
				startActivity(intFirst);
				finish();
			}
		});
		FourthKalmah.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {


				intFirst.putExtra("kalma", 3);
				startActivity(intFirst);
				finish();
			}
		});

		fifthKalmah.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				intFirst.putExtra("kalma", 4);
				startActivity(intFirst);
				finish();
			}
		});
		sixKalmah.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				intFirst.putExtra("kalma", 5);
				startActivity(intFirst);
				finish();
			}
		});

		rotate.setAnimationListener(new AnimationListener() {

			@Override
			public void onAnimationStart(Animation arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onAnimationRepeat(Animation arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onAnimationEnd(Animation arg0) {
				// TODO Auto-generated method stub

			}
		});

		animZoomin.setAnimationListener(new AnimationListener() {

			@Override
			public void onAnimationStart(Animation arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onAnimationRepeat(Animation arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onAnimationEnd(Animation arg0) {
				fisrtKalmah.startAnimation(animZoomOut);
				secondKalmah.startAnimation(animZoomOut);
				ThirdKalmah.startAnimation(animZoomOut);
				FourthKalmah.startAnimation(animZoomOut);
				fifthKalmah.startAnimation(animZoomOut);
				sixKalmah.startAnimation(animZoomOut);

			}
		});
		animZoomOut.setAnimationListener(new AnimationListener() {

			@Override
			public void onAnimationStart(Animation arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onAnimationRepeat(Animation arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onAnimationEnd(Animation arg0) {
				fisrtKalmah.startAnimation(animZoomin);
				secondKalmah.startAnimation(animZoomin);
				ThirdKalmah.startAnimation(animZoomin);
				FourthKalmah.startAnimation(animZoomin);
				fifthKalmah.startAnimation(animZoomin);
				sixKalmah.startAnimation(animZoomin);

			}
		});


		playSound(10);
	}


	private void selectLang(){
		int language = User.getInt(User.LANGUAGE, 0, getApplication());

		switch (language) {

			case 0:
				fisrtKalmaa.setText(languge[0]);
				secondKalmaa.setText(languge[0]);
				ThirdKalmaa.setText(languge[0]);
				FourthKalmaa.setText(languge[0]);
				fifthKalmaa.setText(languge[0]);
				sixKalmaa.setText(languge[0]);
				break;
			case 1:
				fisrtKalmaa.setText(languge[1]);
				secondKalmaa.setText(languge[1]);
				ThirdKalmaa.setText(languge[1]);
				FourthKalmaa.setText(languge[1]);
				fifthKalmaa.setText(languge[1]);
				sixKalmaa.setText(languge[1]);
				break;
			case 2:
				fisrtKalmaa.setText(languge[2]);
				secondKalmaa.setText(languge[2]);
				ThirdKalmaa.setText(languge[2]);
				FourthKalmaa.setText(languge[2]);
				fifthKalmaa.setText(languge[2]);
				sixKalmaa.setText(languge[2]);
				break;
			case 3:
				fisrtKalmaa.setText(languge[3]);
				secondKalmaa.setText(languge[3]);
				ThirdKalmaa.setText(languge[3]);
				FourthKalmaa.setText(languge[3]);
				fifthKalmaa.setText(languge[3]);
				sixKalmaa.setText(languge[3]);
				break;
			case 4:
				fisrtKalmaa.setText(languge[4]);
				secondKalmaa.setText(languge[4]);
				ThirdKalmaa.setText(languge[4]);
				FourthKalmaa.setText(languge[4]);
				fifthKalmaa.setText(languge[4]);
				sixKalmaa.setText(languge[4]);
				break;
			case 5:
				fisrtKalmaa.setText(languge[5]);
				secondKalmaa.setText(languge[5]);
				ThirdKalmaa.setText(languge[5]);
				FourthKalmaa.setText(languge[5]);
				fifthKalmaa.setText(languge[5]);
				sixKalmaa.setText(languge[5]);
				break;
			case 6:
				fisrtKalmaa.setText(languge[6]);
				secondKalmaa.setText(languge[6]);
				ThirdKalmaa.setText(languge[6]);
				FourthKalmaa.setText(languge[6]);
				fifthKalmaa.setText(languge[6]);
				sixKalmaa.setText(languge[6]);
				break;
		}
	}

	public void onBackPressed() {
		// your code.
		finish();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();

		if (mediaPlayer != null) {
			mediaPlayer.stop();
		}
	}



	protected void showDelayedImages() {

		Timer timer = new Timer();
		timer.schedule(new MyTimerTask(), 0);
	}

	int number;

	private class MyTimerTask extends TimerTask {
		@Override
		public void run() {
			for (number = 0; number < 5; number++) {

				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				runOnUiThread(new Runnable() {

					@Override
					public void run() {
						// secondKalma.setVisibility(View.VISIBLE);

						Log.e("Imgesbuttons here", "images = "
								+ kalmaArray[number]);
						playSound(10);
						kalmaArray[number].setVisibility(View.VISIBLE);
						if (number == 5) {
							kalmaArray[number].startAnimation(animZoomin);
						}

					}
				});
			}

		}
	}
}