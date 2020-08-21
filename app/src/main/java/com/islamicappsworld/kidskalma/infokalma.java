package com.islamicappsworld.kidskalma;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class infokalma extends BaseActivity {
    Button button_suave, btnfacebook, btntwt, btnFeedback, btnshare, btnmore,
            button_back, btngplus, btnrate;
    TextView tvHeader, textInfoheading, textInfo;
    private AdView adView;
    LinearLayout layout;
    String English="Kids Kalma include audio, arabic, translation and transliteration with beautiful " +
            "interactive user interface for kids. Kids Kalma app is for Kids to" +
            " memorize, understand and pronounce six islamic kalmas";
    String Urdu="بچوں کی اسلامک کلمہ ایپلیکیشن میں بچوں کے لئے خوبصورت انٹرایکٹو صارف انٹرفیس کے ساتھ آڈیو، عربی،\n" +
            "ترجمہ اور ٹرانسپیریٹریشن شامل ہے. بچوں کے لئے چھ اسلامی اسلامی کالم کو یاد، سمجھنے اور بولنے کے لئے\n" +
            "ہے\u200E.";
    String Indo="Kalma anak-anak termasuk audio, bahasa Arab, terjemahan dan transliterasi dengan antarmuka " +
            "pengguna interaktif yang indah untuk anak-anak. Aplikasi Kalma Anak adalah untuk Anak-anak untuk menghafal, " +
            "memahami dan mengucapkan enam kalmas islam";
    String Turkey="Çocuklar Kalma çocuklar için güzel interaktif kullanıcı arayüzü ile ses, arapça, çeviri ve " +
            "transliterasyon içerir. Çocuklar Kalma uygulaması Çocuklar için altı islamic kalmas ezberlemek, " +
            "anlamak ve telaffuz için";
    String Spanish="Kids Kalma incluye audio, árabe, traducción y transliteración con una hermosa interfaz de" +
            " usuario interactiva para niños." +
            " La aplicación Kids Kalma es para que los niños memoricen, entiendan y pronuncien seis kalmas islámicos";
    String German = "Kinder Islamic Calling Application umfasst Audio, Arabisch, Übersetzung und Transparenz mit\n" +
            "schönen interaktiven Benutzeroberfläche für Kinder. Sechs islamische islamische Säulen für\n" +
            "Kinder sollen sich erinnern, verstehen und sprechen.";
    String Chinese ="儿童伊斯兰呼叫应用程序包括音频，阿拉伯语，翻译和传输，以及儿童的美妙交互式用户\n" +
            "界面。 六个伊斯兰伊斯兰教的儿童专栏要记住，理解和说话。";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.infoscreen);
        tvHeader = (TextView) findViewById(R.id.tvHeader);
        setNbFont(tvHeader);
        button_back = (Button) findViewById(R.id.button_back);
        button_suave = (Button) findViewById(R.id.button_suave);
        btnFeedback = (Button) findViewById(R.id.btnFeedback);
        btnshare = (Button) findViewById(R.id.btnshare);
        btnrate = (Button) findViewById(R.id.btnrate);
        btnfacebook = (Button) findViewById(R.id.btnfacebook);
        btntwt = (Button) findViewById(R.id.btntwt);
        btnmore = (Button) findViewById(R.id.btnmore);
        btngplus = (Button) findViewById(R.id.btngplus);

        textInfo = (TextView) findViewById(R.id.textInfo);

        btnrate.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intentR = new Intent(Intent.ACTION_VIEW);
                intentR.setData(Uri.parse("market://details?id="
                        + getPackageName()));
                startActivity(intentR);
            }
        });

        button_suave.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Uri uri = Uri
                        .parse("https://islamicappsworld.com/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        btnfacebook.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Uri uri = Uri
                        .parse("https://www.facebook.com/pages/Islamic-Apps-World/1498368430452367");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        btngplus.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Uri uri = Uri
                        .parse("https://plus.google.com/u/0/b/104720112095185663303/104720112095185663303/about");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        btntwt.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Uri uri = Uri.parse("https://twitter.com/IslamicAppWorld");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        btnshare.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
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
        btnmore.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                moreApps();

            }
        });
        btnFeedback.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(
                        Intent.EXTRA_EMAIL,
                        new String[]{"suave.android@gmail.com"});
                email.putExtra(
                        Intent.EXTRA_SUBJECT,
                        "Comments & Suggestions - " + getPackageName());
                email.putExtra(Intent.EXTRA_TEXT, "Here is my feedback on this App");
                email.setType("message/rfc822");
                startActivity(Intent.createChooser(email, "Choose an Email client :"));

            }
        });

        createFullAdd();
        button_back.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                onBackPressed();
            }
        });


        showads();



        int language = User.getInt(User.LANGUAGE, 0, getApplication());
        switch (language) {
            case 0:
                textInfo.setText(English);
                break;
            case 1:
                textInfo.setText(Urdu);
                break;
            case 2:
                textInfo.setText(Indo);
                break;
            case 3:
                textInfo.setText(Turkey);
                break;
            case 4:
                textInfo.setText(Spanish);
                break;
            case 5:
                textInfo.setText(German);
                break;
            case 6:
                textInfo.setText(Chinese);
                break;
        }

    }

    @Override
    public void onBackPressed() {
        // your code.

        if (interstitial.isLoaded()) {
            interstitial.show();
            interstitial.setAdListener(new AdListener() {


                @Override
                public void onAdClosed() {
                    super.onAdClosed();
                    Intent intnt = new Intent(infokalma.this, Kalmadetail.class);
                    startActivity(intnt);
                    finish();
                }
            });
        } else {
            Intent intnt = new Intent(infokalma.this, Kalmadetail.class);
            startActivity(intnt);
            finish();
        }


        /*if (interstitial.isLoaded()) {
           interstitial.show();
            interstitial.setAdListener(new AdListener() {


                @Override
                public void onAdClosed() {
                    super.onAdClosed();
                    Intent intnt = new Intent(infokalma.this, Kalmadetail.class);
                    startActivity(intnt);
                    finish();
                }
            });
        } else {
            Intent intnt = new Intent(infokalma.this, Kalmadetail.class);
            startActivity(intnt);
            finish();
        }

*/
    }

    public void moreApps() {
        Uri uri = Uri
                .parse("https://play.google.com/store/apps/developer?id=Islamic+Apps+World");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void shareApp() {
        Intent share = new Intent(Intent.ACTION_SEND);
        share.setType("text/plain");
        String shareText = "Check out this app, "
                + getResources().getString(R.string.app_name) + " : "
                + "https://play.google.com/store/apps/details?id="
                + getPackageName();
        share.putExtra(Intent.EXTRA_TEXT, shareText);
        startActivity(Intent.createChooser(share, "Share Via"));
    }

    public void rateApp() {
        Intent intentR = new Intent(Intent.ACTION_VIEW);
        intentR.setData(Uri.parse("market://details?id=" + getPackageName()));
        startActivity(intentR);
    }

    public void giveFeedback() {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        Uri data = Uri.parse("mailto:?subject=" + "Comments and Suggestions"
                + "&to=" + "islamicappsworld@gmail.com");
        intent.setData(data);
        intent.putExtra(Intent.EXTRA_TEXT,
                "Write your Comments/Suggestions here");
        startActivity(intent);
    }
}
