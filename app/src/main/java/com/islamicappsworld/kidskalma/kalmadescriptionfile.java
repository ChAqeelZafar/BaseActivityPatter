package com.islamicappsworld.kidskalma;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class kalmadescriptionfile extends BaseActivity {
    ViewPager viewPager;
    // TextView kalmaheder;
    Button share, next, previous, play, Btnback;
    int kalmaNo = 0;
    private AdView adView;
    int totalPages;
    static Context context;
    boolean sound;
    static MediaPlayer mediaPlay = new MediaPlayer();
    RelativeLayout Golbal, globalViewNaveed;
    TextView textpronce, TextTansc, textlink;
    ImageView kalmaimage;
    int imageIndex = 0;
    TextView viewPronc, viewtranslation, kalmatitle, tvScroll;
    int gPosition;
    ScrollView scrollView1;
    private LinearLayout llAdView;

    String english[]=
            {"There is none worthy of worship but Allah, Muhammad [peace be upon him] is the messenger of Allah","I bear witness that (there is) no god except Allah; One is He, no partner hath He, and I bear witness that Muhammad (Sall-Allahu Alayhi wa Sallam) is His Servant and Messenger",
                    "Flawless is Allah and the Praise is of Allah, and (there is) no god except Allah, and Allah is the Greatest. And (there is) neither might nor power except with Allah, the Sublime, the Tremendous",
                    "(There is) no god except Allah - One is He, no partners hath He. His is the Dominion, and His is the Praise. He gives life and causes death, and He is Living, who will not die, never. He of Majesty and Munificence. Within His Hand is (all) good. And He is, upon everything, Able (to exert His Will)",
                    "I seek forgiveness from Allah, my Lord, from every sin I committed knowingly or unknowingly, secretly or openly, and I turn towards Him from the sin that I know and from the sin that I do not know. Certainly You, You (are) the knower of the hidden things and the Concealer (of) the mistakes and the Forgiver (of) the sins. And (there is) no power and no strength except from Allah, the Most High, the Most Great",
                    "O Allah! I seek protection in You from that I should not join any partner with You and I have knowledge of it. I seek Your forgiveness from that which I do not know. I repent from it (ignorance) and I reject disbelief (kufr) and joining partners with You (shirk) and of falsehood and slandering (gheebat) and innovation in religion (bid\'at) and tell-tales (nameemat) and bad, evil deeds (fawahish) and the blame and the disobedience, all of them. I submit to Your will and I believe and I declare: There is none worthy of worship except Allah and Muhammad( Peace Be Upon On Him) is His Messenger."
            };
    String urdu[]=
            {"اللہ کے سوا کوئی معبود نہیں، محمد صلی اللہ علیہ وسلم اللہ کے رسول ہیں","میں گواہی دیتا ہوں کہ اللہ کے سوا کوئی معبود نہیں وہ اکیلا ہے اُس کا کوئی شریک نہیں، اور میں گواہی دیتا ہوں کہ حضرت محمد صلی اللہ علیہ وسلم اُس کے بندے اور رسول ہیں",
                    "پاک ہے اللہ اور تمام تعر یفیں اللہ ہی کے لئے ہیں اور اللہ کے سوا کوئی معبود نہیں اور اللہ بہت بڑا ہے اور گناہوں سے بچنے کی طاقت اور نیک کام کرنے کی قوت اللہ ہی کی طرف سے ہے جو عالیشان اور عظمت والا ہے",
                    "اللہ کے سوا کوئی معبود نہیں وہ اکیلا ہے اُس کا کوئی شریک نہیں، اُسی کی بادشاہی ہے اور اُسی کے لئے تمام تعریف ہے وہ زندہ کرتا ہے اور وہی مارتا ہے اور وہ ہمیشہ کے لئے زندہ ہے جو مرے گا نہیں عظمت اور بزرگی والا ہے، بہتری اُسی کے ہاتھ میں ہے اور وہ ہر چیز پر قادر ہے",
                    "میں اللہ سے معافی منگتا ہوں جو میرا پرورد گار ہے ہر گناہ سے جو میں نے کیا، جان بوجھ کر یا بھول کر، در پردہ یا کھلم کھلا اور میں تو بہ کرتا ہوں اُس کے حضور میں اُس کے گناہ سے جو مجھےمعلوم ہے اور اُس کے گناہ سے جو مجھے معلوم نہیں ۔ بے شک تو عیبوں کو جاننے والا اور عیبوں کو چھپا نے والا ہے اور گناہوں کا بخشنے والا ہے اور گناہوں سے بچنے کی طاقت اور نیک کام کرنے کی قوت اللہ ہی کی طرف سے ہے جو عالیشان اور عظمت والا ہے",
                    "الہٰی میں تیری پناہ مانگتا ہوں اس بات سےکہ میں کسی چیز کو تیرا شریک بناوں اور مجھے اس کا علم ہواور میں معافی مانگتا ہوں تجھ سے اس گناہ سےجس کا علم مجھے نہیں، میں نے اس سے توبہ کی اور بیزار ہوا کفر سے اور شرک سے اور جھوٹ سے اور غیبت سے اور بد عت سے اور چغلی سے اور بے حیا ئی کے کاموں سے اور تہمت لگانے سے اور ہر قسم کی نافرمانیوں سے اور میں کہتا ہوں کہ اللہ کے سوا کو ئی معبود نہیں حضرت محمد اللہ کے رسول ہیں"};

    String Indo[]={
            "(Ada) tidak layak ibadah kecuali Allah. Muhammad adalah rasul ALLAH",
            "Aku bersaksi ( itu ) tidak ada tuhan selain Allah, ia adalah satu. Tidak, dia telah berpasangan aku bersaksi bahwa sall-Allahu alayhi sallam muhammad ( tu ), dan seorang pembawa",
            "Sempurna, dia, Allahdan memuliakan Allah. ( dan ada tidak ada Allahselain roh Allah. Dan yang sangat besar.Tidak ada ) ( dan mungkin dengan kekuatan, dan hanya Allahini indahnya.Itu luar biasa",
            "Tidak ada tuhan selain Allah, dan dia adalah salah satu - dia telah menjadi tidak.Itu adalah kekuasaan. Dan dia memuji.Dia, yang memberi hidup, sehingga menyebabkan kematian dan dia masih hidup. Yang tidak akan mati, tidak.Yang mulia dan munificence. Semua ada di tangan yang baik.Dan dia. Di atas segalanya, itu akan mampu memberikan pengaruh",
            "Aku meminta maaf pada Allah, ya tuhan, dari segala dosa yang dilakukan knowingly, atau tidak sadar dan secara diam-diam, aku berpaling dari dosa terhadap dia, dan bahwa aku tidak berbuat dosa, dan aku tidak tahu.Tentu saja anda, ( anda ) yang tersembunyi dari knower concealer ( dari sesuatu ) dan kesalahan dan dosa forgiver ( dari ).( tidak ada ), dan kekuasaan dan kekuatan yang tidak berasal dari Allah, yang paling tinggi,  hal yang paling besar",
            "Ya Allah! Aku mencari perlindungan dari padamu, supaya aku jangan bergabung dengan rekan kerja anda dan saya tidak memiliki pengetahuan tentang ini.Aku meminta maaf padamu, dari dimana aku tidak tahu.Tidak bertobat dari pada itu aku melihat orang bodoh  dan ( dalam pengertian kufr ) dan mitra bersama ( dan ) engkau syirik dusta dan slandering gheebat ) ( dan penemuan dalam upaya \\'at ( agama ) dan tell-tales ( nameemat ) dan buruk, ( fawahish ) perbuatan jahat dan berdosa dan ketidaktaatan. Semuanya.Kamu akan menyerahkan aku, dan aku percaya dan aku berkata: tidak ada yang beribadah kepada Allahdan muhammad ( kecuali damai sejahtera di dalam dia, ia adalah utusan )"
    };
    String Turkey []={
            "Allah'a iman etmeyen bir kimse yoktur, ama Allah, Hz. Allah'ın elçisidir.",
            "Allah'tan başka bir tanrı yoktur. Birisi O, hiçbir partneri yoktur ve ben Muhammed (Sall-Allahu Alayhi ve Sallam) 'nın onun hizmetkarı ve elçisidir.","Kusursuz Allah'tır ve Hamd Allah'tır, ve Allah'tan başka bir tanrı yoktur ve Allah en büyüktür. Ve Allah’ın, Yüce Olanın, Muazzamın",
            "Allah dışında bir tanrı yoktur - O bir, O'nun hiçbir ortağı yoktur. Onun Dominion ve O'nun Övgü. O hayat verir ve ölüme neden olur, ve O Ölmez, asla ölmez. Majesteleri ve Munificence. Onun Elinde (hepsi) iyidir. Ve O, her şeyde, Able (Onun İradesini uygulamak için)",
            "Allah'tan, Rabbimden, bilerek ya da bilmeyerek, gizlice ya da açık bir şekilde işlediğim her günahtan af diliyorum ve bildiğim günahtan ve bilmediğim günahtan O'na dönüyorum. Tabii ki Sen, sen (gizli) şeylerin bilenini, ve (günahtan) hatalarını ve günahları (günahkâr) günahlarını. Ve Allah’ın (En Yüce, En Yüce)",
            "Allah! Senden korunmaya çalışıyorum çünkü seninle herhangi bir partnere katılmamalıyım ve bunun hakkında bilgim var. Bilmediğim şeyden af \u200B\u200Bdiliyorum. Ben ondan tövbe ediyorum (cehalet) ve imansızlığı (kufr) reddediyorum ve sizlerle (şirk) ve yalancı ve iftira (gheebat) ile inovasyondaki yenilikler (bid \\ 'at) ve anlattıkları (isimemat) ve kötülerle ortaklarım. kötü işler (fawahish) ve suçlama ve itaatsizlik, hepsi. Senin iradesine boyun eğiyorum ve inanıyorum ki şunu beyan ederim: Allah ve Muhammed (Allah Üzerine Olmak Üzeri Olmak Üzere) dışında bir ibadete layık değildir."
    };
    String Spanish[]={
            "No hay nadie que no crea en Alá, pero Alá es el Mensajero de Allah" ,
            "No hay otro dios más que Alá, alguien no tiene pareja, y yo soy su sirviente y mensajero de Muhammad (Sal. Al-lah Alayhi y Sallam).Perfecto es Alá y Alabado sea Alá, no hay otro dios, y Alá es el más grande, y Alá, el Todopoderoso, el Grande ",
            "No hay más dios que Alá - Él no tiene pareja, Él es Su alabanza al Dominio, y Él da vida y causa la muerte, y Él nunca morirá, nunca morirá Su Majestad y Munificencia. Y él, en todo, Able (para implementar a Su Excelencia) ",
            "Abogo con Alá, mi Señor, consciente o inconscientemente, todos los pecados que he perdonado en secreto o abiertamente, y vuelvo a Él como un pecador que conozco y un pecado que no conozco: por supuesto que conocerás los secretos de las cosas y los (pecaminosos) y los pecados de pecados (pecaminosos) y de Alá (el Altísimo, el Altísimo)",
            "Abogo con Alá, mi Señor, consciente o inconscientemente, todos los pecados que he perdonado en secreto o abiertamente, y vuelvo a Él como un pecador que conozco y un pecado que no conozco: por supuesto que conocerás los secretos de las cosas y los (pecaminosos) y los pecados de pecados (pecaminosos) y de Alá (el Altísimo, el Altísimo)",
            "Tengo miedo de lo que no sé porque me arrepiento y me niego a creer en él, y me niego a creer en ti, y para ti soy un chivato y un mentiroso y una calumnia (gheebat). ) y las innovaciones en innovación (bid \\\\ 'at) y asociaciones con el mal, el fawahish, la culpa y la desobediencia, todo lo cual someto a tu voluntad y declaro que creo en Alá y Muhammad Para estar arriba) no es digno de una adoración "
    };
    String German []= {
            "Es gibt keinen Gott außer Allah (und) Muhammad (SAW) ist der Gesandte Allahs",
            "Ich bezeuge, dass es keinen anderen Gott als Allah gibt, Er ist der Eine, und Er hat keinen Partner, und ich bezeuge, dass Mohammed sein Diener und Gesandter ist",
            "Es gibt keinen anderen Gott außer Allah. Er ist der Eine, der Allwissende, denn Er ist das Königreich, und für Ihn ist Lobpreis, Er lebt und verursacht den Tod und Er wird niemals sterben." +
                    " Er ist der Allerhöchste, der Große. Er ist gut und Er ist über alle Dinge",
"Es gibt keinen Gott außer Allah. Er ist der Eine, der Einzige, für den Er ist. Für Ihn ist das Königreich, und für Ihn ist der Lobpreis, Er lebt und verursacht den Tod und Er lebt immer und Er wird niemals sterben. " +
        "Er ist der Höchste, der Große und der Große. Er ist gut in seiner Hand und er ist über alle Dinge hinweg.",
    "Ich entschuldige mich bei Gott, der mein Herr ist, bei jeder Sünde, die ich wissentlich oder vergessen habe, oder indem ich absondere und bereue, dass ich von der Sünde, die ich kenne, und dieser Sünde bereue Wahrlich, du kennst das Unsichtbare nicht, den Kenner des Verborgenen, die Geheimnisse der Übeltäter, den Sündenvergeber und die Macht, " +
            "Sünden zu vermeiden, ist nicht die Kraft, Gutes zu tun, sondern mit der Hilfe von Allah, dem Größten.\n",
            "O mein Gott, ich bitte um Zuflucht für dich, damit ich dich mit etwas verbinden kann, und bitte um Vergebung für dich, was ich nicht weiß, und ich bereute und erstaunt, undankbar. Und ich brachte den Islam zum Islam und vom Polytheismus und von den Lügen und mit dem Bösen und von der Unwissenheit und mit vielen Sünden und allen Sünden, und ich sage, es gibt keinen Verehrer außer Allah, dem Gesandten Allahs"
    };
    String Chinese []={
"除了安拉（和）穆罕默德（SAW）之外，没有任何神是真主的使者",
            "我证明除了真主之外没有上帝。他是唯一的，他没有伴侣，我证明穆罕默德是他的仆人和使者。",
            "除了安拉之外，没有上帝。他是唯一的，是他的全能者，因为他是国度，因为他是赞美，他生活并导致死亡，他永远不会死。他是至高者，伟大者。 他很善良，而且他胜过一切",
            "除了安拉之外，没有上帝。他是唯一的，他是他的唯一者。因为他是国度，因为他是赞美，生者和死者，他是活着的，永远不会死。他是至高者，大人和大人。 他手上很好，他掌握着所有的东西。",
            "我向作为我的主的上帝，为我所知道或忘记的每一个罪，或通过分泌和悔改道歉，我从我所知道的罪和这罪中悔改 我不知道的是，你肯定是看不见的知识者，缺陷的构想者，罪恶的赦免者，以及避免罪恶的能力，并不是行善的力量。",
            "我的上帝啊！我为你寻求庇护，以便我可以将你与一件事情联系起来，刻意地请求原谅我，我不知道，我向你忏悔，并且忘恩负义。 我从多神论和看不见的，看不见的，没有经验的，不信的人，以及许多人和所有的罪中带来了伊斯兰教，我说，除了上帝之外，没有上帝。"

    };

    ArrayList<KalmaArray> list_kalmaArray = new ArrayList<KalmaArray>();
    //    public MediaPlayer mediaPlayer;
    boolean flag = false;
    private ScrollView scrollView;

    boolean isPlay = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kalmadescriptiondetail);
        kalmatitle = (TextView) findViewById(R.id.kaltitle);
        context = this;

        viewPager = (ViewPager) findViewById(R.id.view_pager);
        Btnback = (Button) findViewById(R.id.btnBack);
        share = (Button) findViewById(R.id.share);
        next = (Button) findViewById(R.id.next);
        previous = (Button) findViewById(R.id.previous);
        play = (Button) findViewById(R.id.play);
        sound = false;
        loadData();
        ImageAdapter adapter = new ImageAdapter(this);
        viewPager.setAdapter(adapter);
        kalmaNo = getIntent().getIntExtra("kalma", 0);
        kalmatitle.setText(list_kalmaArray.get(kalmaNo).title);
        tvScroll = (TextView) findViewById(R.id.tvScroll);

        viewPager.setCurrentItem(kalmaNo);
        totalPages = viewPager.getAdapter().getCount();
        int newindex = kalmaNo + 1;
        if (newindex == totalPages) {
            next.setVisibility(View.INVISIBLE);
        } else {
            next.setVisibility(View.VISIBLE);
        }
        viewPager.setOffscreenPageLimit(1);
        viewPager.addOnPageChangeListener(new OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                // TODO Auto-generated method stub
                sound = true;
                gPosition = position;
                totalPages = viewPager.getAdapter().getCount();

                int currentpage = position;
                kalmatitle.setText(list_kalmaArray.get(currentpage).title);
                imageIndex = position;
                currentpage = currentpage + 1;
                tvScrollVisibility(position);

                if (currentpage == totalPages) {
                    next.setVisibility(View.INVISIBLE);
                } else {
                    next.setVisibility(View.VISIBLE);
                }
                isPlay = true;
                playSound(position);
                play.setBackgroundResource(R.drawable.puase_2);
                mediaPlayer.setOnCompletionListener(completionListener);
//                showSeeMore(position);

            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
                flag = true;
            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
                flag = true;

            }
        });
        tvScrollVisibility(kalmaNo);
        isPlay = true;
        playSound(kalmaNo);
        flag = false;
        mediaPlayer.setOnCompletionListener(completionListener);

        Btnback.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        share.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {

                if (mediaPlay.isPlaying()) {
                    Log.e("media player is playing", "Playing");
                    mediaPlay.stop();
                    play.setBackgroundResource(R.drawable.paly);
                }


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

        next.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                nextPage();
                Log.e("Sound here", "Exception = " + kalmaNo);
                // Sound(kalmaNo);

            }
        });
        previous.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                previousPage();
                // Sound(kalmaNo);
            }
        });

        play.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                int Cpagenumber = viewPager.getCurrentItem();
                if (isPlay) {
//                if (mediaPlayer != null && !flag || mediaPlayer.isPlaying()) {
//                    Log.i("play.setOnClickListener", "btnPlay flag = " + flag);
                    flag = true;
                    isPlay = false;
                    pauseCick();
//                    mediaPlayer.stop();
                    play.setBackgroundResource(R.drawable.paly);

                } else {
                    Log.i("play.setOnClickListener", "btnPlay flag = " + flag);
                    flag = false;
//                    playSound(Cpagenumber);
                    resumeClick();
                    mediaPlayer.setOnCompletionListener(completionListener);
                    play.setBackgroundResource(R.drawable.puase_2);
                }
            }
        });


        createFullAdd();
    }



    void resumeClick() {
        isPlay = true;
        if (mediaPlayer != null) {

            mediaPlayer.start();
        } else {
            playSound(viewPager.getCurrentItem());

        }

    }

    void pauseCick() {
        isPlay = false;
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
        }

    }

    void tvScrollVisibility(int pos) {
        if (pos == 0) {
            previous.setVisibility(View.INVISIBLE);
            tvScroll.setVisibility(View.INVISIBLE);
        } else {
            previous.setVisibility(View.VISIBLE);
            tvScroll.setVisibility(View.VISIBLE);
        }
    }

    String[] tempArray;

    public void loadData() {
//        arrTrans = getResources().getStringArray(R.array.str_trans);
        int mLanguage = User.getInt(User.LANGUAGE, 0, getApplication());
        tempArray = setLang(mLanguage, tempArray);
        for (int i = 0; i < tempArray.length; i++) {
            list_kalmaArray.add(new KalmaArray(i, arrKalmaNameEng[i],
                    arrTranslitration[i], tempArray[i], arrDrawables[i]));
        }
    }

    private String[] setLang(int selectedLang, String[] strArray){
        switch (selectedLang) {
            case 0:
                strArray = new String[english.length];
                for (int i = 0; i < english.length; i++) {
                    strArray[i] = english[i];
                }
                break;

            case 1:
                strArray = new String[urdu.length];
                for (int i = 0; i < urdu.length; i++) {
                    strArray[i] = urdu[i];
                }
                break;

            case 2:
                strArray = new String[Indo.length];
                for (int i = 0; i < Indo.length; i++) {
                    strArray[i] = Indo[i];
                }
                break;
            case 3:
                strArray = new String[Turkey.length];
                for (int i = 0; i < Turkey.length; i++) {
                    strArray[i] = Turkey[i];
                }
                break;

            case 4:
                strArray = new String[Spanish.length];
                for (int i = 0; i < Spanish.length; i++) {
                    strArray[i] = Spanish[i];

                }
                break;
            case 5:
                strArray = new String[German.length];
                for (int i = 0; i < German.length; i++) {
                    strArray[i] = German[i];

                }
                break;
            case 6:
                strArray = new String[Chinese.length];
                for (int i = 0; i < Chinese.length; i++) {
                    strArray[i] = Chinese[i];

                }
                break;
        }
        return strArray;
    }



    OnCompletionListener completionListener = new OnCompletionListener() {

        @Override
        public void onCompletion(MediaPlayer mp) {

            play.setBackgroundResource(R.drawable.paly);
            isPlay = false;
            // flag = true;
            // Log.i("", "completionListener flag = " + flag);
        }
    };

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();

//        if (mediaPlayer != null) {
//            mediaPlayer.stop();
        pauseCick();
        play.setBackgroundResource(R.drawable.paly);
//        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        resumeClick();
        mediaPlayer.setOnCompletionListener(completionListener);
        play.setBackgroundResource(R.drawable.puase_2);

    }

    @Override
    public void onStop() {
        // TODO Auto-generated method stub
        super.onStop();
        if (mediaPlay.isPlaying()) {

            mediaPlay.stop();
            play.setBackgroundResource(R.drawable.paly);
        }
    }

    public static void shareImage(View view) {
        Intent share = new Intent(Intent.ACTION_SEND);
        share.setType("image/jpeg");
        Bitmap icon = screenShot(view);
        if (icon != null) {
            ByteArrayOutputStream bytes = new ByteArrayOutputStream();
            icon.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
            File f = new File(Environment.getExternalStorageDirectory()
                    + File.separator + "Kalmaimage.jpg");
            try {
                f.createNewFile();
                FileOutputStream fo = new FileOutputStream(f);
                fo.write(bytes.toByteArray());
            } catch (IOException e) {
                e.printStackTrace();
            }
            share.putExtra(Intent.EXTRA_STREAM,
                    Uri.parse("file:///sdcard/Kalmaimage.jpg"));
        } else {
            Log.e("shareImage", "icon is null");
        }

        String link = "http://tinyurl.com/KidsKalmaApp";
        String sharSubject = "Kids Kalma";
        String body = "I have share a kalma with you via \"Kids Kalma\"Kids Kalma is a learning App for kids and it is free to download!"
                + System.getProperty("line.separator")
                + "Check this out!"
                + System.getProperty("line.separator") + link;
        // share.putExtra(Intent.EXTRA_TEXT, shar);
        share.putExtra(Intent.EXTRA_SUBJECT, sharSubject);
        share.putExtra(Intent.EXTRA_TEXT, body);
        context.startActivity(Intent.createChooser(share, "Share Via"));
    }

    public static Bitmap loadBitmapFromView(View v) {
        Bitmap b = Bitmap.createBitmap(v.getWidth(), v.getHeight(),
                Bitmap.Config.ARGB_8888);

        Canvas c = new Canvas(b);
        c.drawColor(Color.parseColor("#599f93"));
        v.layout(0, 0, v.getLayoutParams().width, v.getLayoutParams().height);
        v.draw(c);
        return b;
    }

    private static Bitmap screenShot(View view) {
        try {
            Bitmap bm = loadBitmapFromView(view);
            return bm;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // Save image in Local storage

    private void nextPage() {
        sound = true;
        int currentPage = viewPager.getCurrentItem();
        totalPages = viewPager.getAdapter().getCount();

        int nextPage = currentPage + 1;
        if (nextPage == 0) {

            previous.setVisibility(View.VISIBLE);
        }

        if (nextPage >= totalPages) {
            // We can't go forward anymore.
            // Loop to the first page. If you don't want looping just
            // return here.
            // nextPage = 0;
            // button_next.setVisibility(0);
            next.setVisibility(View.INVISIBLE);
        }

        viewPager.setCurrentItem(nextPage, true);
        // Sound(nextPage);
    }

    private void previousPage() {
        sound = true;
        int currentPage = viewPager.getCurrentItem();
        totalPages = viewPager.getAdapter().getCount();

        int previousPage = currentPage - 1;
        if (previousPage == 1) {
            previous.setVisibility(View.INVISIBLE);
        }
        if (previousPage > 0) {
            // We can't go back anymore.
            // Loop to the last page. If you don't want looping just
            // return here.
            // previousPage = totalPages - 1;
            next.setVisibility(View.VISIBLE);
        }

        viewPager.setCurrentItem(previousPage, true);
        // Sound(previousPage);
    }


    public class ImageAdapter extends PagerAdapter {

        Context context;

        ImageAdapter(Context context) {

            this.context = context;
        }

        @Override
        public int getCount() {
            return list_kalmaArray.size();
        }

        // @Override
        // public boolean isViewFromObject(View view, Object object) {
        // return view == ((ImageView) object);
        // }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            Log.e(" position ", "" + position);

            View rowView = inflater.inflate(R.layout.customviewpager,
                    container, false);
            RelativeLayout rlKalmsharing = (RelativeLayout) rowView
                    .findViewById(R.id.rlKalmsharing);
            scrollView1 = (ScrollView) rowView.findViewById(R.id.scrollView1);
            TextView tvKalmaName = (TextView) rowView.findViewById(R.id.tvKalmaName);
            kalmaimage = (ImageView) rowView.findViewById(R.id.kalmaimage);
            viewPronc = (TextView) (rowView.findViewById(R.id.viewPronc));
            setNormalFont(viewPronc);

            textpronce = (TextView) (rowView.findViewById(R.id.textpronce));
            TextTansc = (TextView) (rowView.findViewById(R.id.TextTansc));
            setNbFont(textpronce);
            setNbFont(TextTansc);
            viewtranslation = (TextView) (rowView
                    .findViewById(R.id.viewtranslation));
            setNormalFont(viewtranslation);
            setNormalFont(tvKalmaName);
            tvKalmaName.setText(list_kalmaArray.get(position).title);

            kalmaimage
                    .setBackgroundResource(list_kalmaArray.get(position).kalmaimage);
            Log.d("kalmapronc", "" + list_kalmaArray.get(position).pro);
            viewPronc.setText(list_kalmaArray.get(position).pro);
            viewtranslation.setText(list_kalmaArray.get(position).translation);
            kalmaNo = list_kalmaArray.get(position).Id;
            imageIndex = list_kalmaArray.get(position).Id;
            setNbFont(kalmatitle);
            ((ViewPager) container).addView(rowView, 0);
            rlKalmsharing.setTag("view" + position);
            scrollView1.setTag(position);


            return rowView;
        }

        @Override
        public void destroyItem(View arg0, int arg1, Object arg2) {
            ((ViewPager) arg0).removeView((View) arg2);
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0 == ((View) arg1);
        }
    }

    public void onBackPressed() {
        // your code.


        if (interstitial.isLoaded()) {
            interstitial.show();
            interstitial.setAdListener(new AdListener() {


                @Override
                public void onAdClosed() {
                    super.onAdClosed();
                    Intent intnt = new Intent(kalmadescriptionfile.this, Kalmadetail.class);
                    startActivity(intnt);
                    overridePendingTransition(0, 0);
                    finish();
                }
            });
        } else {
            Intent intnt = new Intent(kalmadescriptionfile.this, Kalmadetail.class);
            startActivity(intnt);
            overridePendingTransition(0, 0);
            finish();
        }

    }

    public boolean isStoragePermissionGranted() {
        if (Build.VERSION.SDK_INT >= 23) {
            if (checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_GRANTED) {
                Log.v(TAG, "Permission is granted");
                return true;
            } else {

                Log.v(TAG, "Permission is revoked");
                ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
                return false;
            }
        } else { //permission is automatically granted on sdk<23 upon installation
            Log.v(TAG, "Permission is granted");
            return true;
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            Log.v("", "Permission: " + permissions[0] + "was " + grantResults[0]);
            //resume tasks needing this permission
        }
    }
}
