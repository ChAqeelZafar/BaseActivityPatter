package com.islamicappsworld.kidskalma;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends BaseActivity {

	// Spinner spinner1;
	Button btnEnglish, btnUrdu, btnIndonesia,btnTurkis,btnSpanis,btnGerma,btnChines,
			btnStarEng, btnStarUrdu, btnStarIndo,btnStarTurkish,btnStarSpanish,btnStarGerman,btnStarChinese;

	Context context;
	TextView textviewSelect;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setLayout(R.layout.fragment_main);

		context = this;
		btnEnglish = (Button) findViewById(R.id.btnEnglish);
		btnUrdu = (Button) findViewById(R.id.btnUrdu);
		btnIndonesia = (Button) findViewById(R.id.btnIndonesia);
		btnTurkis  =(Button)findViewById(R.id.btnTurkish);
		btnSpanis  =(Button)findViewById(R.id.btnspanish);
		btnGerma  =(Button)findViewById(R.id.btnGerman);
		btnChines  =(Button)findViewById(R.id.btnChinese);



		btnStarEng = (Button) findViewById(R.id.btnStarEng);
		btnStarUrdu = (Button) findViewById(R.id.btnStarUrdu);
		btnStarIndo = (Button) findViewById(R.id.btnStarIndo);
		btnStarTurkish = (Button) findViewById(R.id.btnStarTurkish);
		btnStarSpanish = (Button) findViewById(R.id.btnStarspanish);
		btnStarGerman = (Button) findViewById(R.id.btnStarGerman);
		btnStarChinese = (Button) findViewById(R.id.btnStarChinese);

		textviewSelect = (TextView) findViewById(R.id.tvSelect);
		setNbFont(btnEnglish);
		setNbFont(btnUrdu);
		setNbFont(btnIndonesia);
        setNbFont(btnTurkis);
        setNbFont(btnSpanis);
        setNbFont(btnGerma);
        setNbFont(btnChines);

        setNbFont(textviewSelect);
		btnEnglish.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				User.saveInt(User.LANGUAGE, 0, context);
				checklanguage(View.VISIBLE, View.INVISIBLE, View.INVISIBLE, View.INVISIBLE, View.INVISIBLE, View.INVISIBLE, View.INVISIBLE);
				Intent intenglish = new Intent(context, Kalmadetail.class);
				startActivity(intenglish);
				finish();
			}
		});
		btnUrdu.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				User.saveInt(User.LANGUAGE, 1, context);
				checklanguage(View.INVISIBLE, View.VISIBLE, View.INVISIBLE, View.INVISIBLE, View.INVISIBLE, View.INVISIBLE, View.INVISIBLE);
				Intent intenglish = new Intent(context, Kalmadetail.class);
				startActivity(intenglish);
				finish();

			}
		});
		btnIndonesia.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				User.saveInt(User.LANGUAGE, 2, context);
				checklanguage(View.INVISIBLE, View.INVISIBLE, View.VISIBLE, View.INVISIBLE, View.INVISIBLE, View.INVISIBLE, View.INVISIBLE);
				Intent intenglish = new Intent(context, Kalmadetail.class);
				startActivity(intenglish);
				finish();
			}
		});
		btnTurkis.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				User.saveInt(User.LANGUAGE, 3, context);
				checklanguage(View.INVISIBLE, View.INVISIBLE, View.INVISIBLE, View.VISIBLE, View.INVISIBLE, View.INVISIBLE, View.INVISIBLE);
				Intent intenglish = new Intent(context, Kalmadetail.class);
				startActivity(intenglish);
				finish();
			}
		});
		btnSpanis.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				User.saveInt(User.LANGUAGE, 4, context);
				checklanguage(View.INVISIBLE, View.INVISIBLE, View.INVISIBLE, View.INVISIBLE, View.VISIBLE, View.INVISIBLE, View.INVISIBLE);
				Intent intenglish = new Intent(context, Kalmadetail.class);
				startActivity(intenglish);
				finish();
			}
		});
		btnGerma.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				User.saveInt(User.LANGUAGE, 5, context);
				checklanguage(View.INVISIBLE, View.INVISIBLE, View.INVISIBLE, View.INVISIBLE, View.INVISIBLE, View.VISIBLE, View.INVISIBLE);
				Intent intenglish = new Intent(context, Kalmadetail.class);
				startActivity(intenglish);
				finish();
			}
		});
		btnChines.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				User.saveInt(User.LANGUAGE, 6, context);
				checklanguage(View.INVISIBLE, View.INVISIBLE, View.INVISIBLE, View.INVISIBLE, View.INVISIBLE, View.INVISIBLE, View.VISIBLE);
				Intent intenglish = new Intent(context, Kalmadetail.class);
				startActivity(intenglish);
				finish();
			}
		});

	}

	public void onBackPressed() {
		finish();
	}

	private void checklanguage(final int eng, final int urdu, final int indo, final int Turk,final int Spanish,final int German,final int Chinese) {

		btnStarEng.setVisibility(eng);
		btnStarUrdu.setVisibility(urdu);
		btnStarIndo.setVisibility(indo);
		btnStarTurkish.setVisibility(Turk);
		btnStarSpanish.setVisibility(Spanish);
		btnStarGerman.setVisibility(German);
		btnStarChinese.setVisibility(Chinese);

	}
}