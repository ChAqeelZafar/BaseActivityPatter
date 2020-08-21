package com.islamicappsworld.kidskalma;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * QuickAction dialog.
 *
 * @author Lorensius W. L. T <lorenz@londatiga.net>
 *         <p/>
 *         Contributors: - Kevin Peck <kevinwpeck@gmail.com>
 */
public class QuickAction extends PopupWindows implements OnDismissListener {
    // private ImageView mArrowUp;
    // private ImageView mArrowDown;

    private Animation mTrackAnim;
    private LayoutInflater inflater;
    private ViewGroup mTrack;
    private OnActionItemClickListener mItemClickListener;
    private OnDismissListener mDismissListener;

    TextView tvEnglish, tvUrdu, tvIndonesia,tvTurkey,tvSpanish,tvGerman,tvChinese;
    private TextView tvChangeLocation;

    private List<ActionItem> mActionItemList = new ArrayList<ActionItem>();

    private boolean mDidAction;
    private boolean mAnimateTrack;

    private int mChildPos;
    private int mAnimStyle;

    public static final int ANIM_GROW_FROM_LEFT = 1;
    public static final int ANIM_GROW_FROM_RIGHT = 2;
    public static final int ANIM_GROW_FROM_CENTER = 3;
    public static final int ANIM_AUTO = 4;

    /**
     * Constructor.
     *
     * @param context
     * Context
     */
    Context mContext;

    public QuickAction(Context context) {
        super(context);

        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mContext = context;
        mTrackAnim = AnimationUtils.loadAnimation(context, R.anim.rail);

        mTrackAnim.setInterpolator(new Interpolator() {
            public float getInterpolation(float t) {
                // Pushes past the target area, then snaps back into place.
                // Equation for graphing: 1.2-((x*1.6)-1.1)^2
                final float inner = (t * 1.55f) - 1.1f;

                return 1.2f - inner * inner;
            }
        });

        // setRootViewId(R.layout.quickaction);
        // setRootViewId(R.layout.dialog_menu, context);
        setRootViewId(R.layout.languagepopup, context);

        mAnimStyle = ANIM_AUTO;
        mAnimateTrack = true;
        mChildPos = 0;
    }

    /**
     * Get action item at an index
     *
     * @param index Index of item (position from callback)
     * @return Action Item at the position
     */
    public ActionItem getActionItem(int index) {
        return mActionItemList.get(index);
    }

    /**
     * Set root view.
     *
     * @param id Layout resource id
     */

    public void setNbFont(TextView view, Context context) {

        Typeface font = Typeface.createFromAsset(context.getAssets(),
                "nb_obese.ttf");
        view.setTypeface(font);
    }

    public void setRootViewId(int id, final Context context) {

        mRootView = (ViewGroup) inflater.inflate(id, null);
        mTrack = (ViewGroup) mRootView.findViewById(R.id.linearTop);

        tvEnglish = (TextView) mRootView.findViewById(R.id.tvEnglish);
        tvUrdu = (TextView) mRootView.findViewById(R.id.tvUrdu);
        tvIndonesia = (TextView) mRootView.findViewById(R.id.tvIndonesia);
        tvTurkey = (TextView)mRootView.findViewById(R.id.tvTurkey);
        tvSpanish = (TextView)mRootView.findViewById(R.id.tvSpanish);
        tvGerman = (TextView)mRootView.findViewById(R.id.tvgerman);
        tvChinese = (TextView)mRootView.findViewById(R.id.tvChinese);



        LinearLayout ltvEnglish = (LinearLayout) mRootView.findViewById(R.id.ltvEnglish);
        LinearLayout ltvUrdu = (LinearLayout) mRootView.findViewById(R.id.ltvUrdu);
        LinearLayout ltvIndonesia = (LinearLayout) mRootView.findViewById(R.id.ltvIndonesia);
        LinearLayout ltvTurkey = (LinearLayout)mRootView.findViewById(R.id.ltvTurkey);
        LinearLayout ltvSpanish = (LinearLayout)mRootView.findViewById(R.id.ltvSpanish);
        LinearLayout ltvGerman = (LinearLayout)mRootView.findViewById(R.id.ltvGerman);
        LinearLayout ltvChinese = (LinearLayout)mRootView.findViewById(R.id.ltvChinese);



        ImageView ivStarEng, ivStarUrdu, ivStarIndo,ivStarTurkey,ivStarSpanish,ivStarGerman,ivStarChinese;

        ivStarEng = (ImageView) mRootView.findViewById(R.id.btnStarEng);
        ivStarUrdu = (ImageView) mRootView.findViewById(R.id.btnStarUrdu);
        ivStarIndo = (ImageView) mRootView.findViewById(R.id.btnStarIndo);
        ivStarTurkey = (ImageView) mRootView.findViewById(R.id.btnStarTurkey);
        ivStarSpanish  = (ImageView) mRootView.findViewById(R.id.btnStarSpanish);
        ivStarGerman  = (ImageView) mRootView.findViewById(R.id.btnStarGerman);
        ivStarChinese  = (ImageView) mRootView.findViewById(R.id.btnStarChinese);


        ivStarEng.setVisibility(View.INVISIBLE);
        ivStarUrdu.setVisibility(View.INVISIBLE);
        ivStarIndo.setVisibility(View.INVISIBLE);
        ivStarTurkey.setVisibility(View.INVISIBLE);
        ivStarSpanish.setVisibility(View.INVISIBLE);
        ivStarGerman.setVisibility(View.INVISIBLE);
        ivStarChinese.setVisibility(View.INVISIBLE);


        setNbFont(tvEnglish, context);
        setNbFont(tvUrdu, context);
        setNbFont(tvIndonesia, context);
        setNbFont(tvTurkey , context);
        setNbFont(tvSpanish , context);
        setNbFont(tvGerman , context);
        setNbFont(tvChinese , context);


        // setNbFont(tvUrdu);
        // setNbFont(tvIndonesia);
        int selected = User.getInt(User.LANGUAGE, 0, context);
        switch (selected) {
            case 0:
                ivStarEng.setVisibility(View.VISIBLE);
                break;
            case 1:
                ivStarUrdu.setVisibility(View.VISIBLE);
                break;
            case 2:
                ivStarIndo.setVisibility(View.VISIBLE);
                break;
            case 3:
                ivStarTurkey.setVisibility(View.VISIBLE);
                break;
            case 4:
                ivStarSpanish.setVisibility(View.VISIBLE);
                break;
            case 5:
                ivStarGerman.setVisibility(View.VISIBLE);
                break;
            case 6:
                ivStarChinese.setVisibility(View.VISIBLE);
                break;


        }



        ltvEnglish.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                User.saveInt(User.LANGUAGE, 0, context);
                dismiss();

            }
        });
        ltvUrdu.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                User.saveInt(User.LANGUAGE, 1, context);
                dismiss();

            }
        });
        ltvIndonesia.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                User.saveInt(User.LANGUAGE, 2, context);
                dismiss();
            }
        });
        ltvTurkey.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                User.saveInt(User.LANGUAGE, 3, context);
                dismiss();

            }
        });
        ltvSpanish.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                User.saveInt(User.LANGUAGE, 4, context);
                dismiss();

            }
        });
        ltvGerman.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                User.saveInt(User.LANGUAGE, 5, context);
                dismiss();

            }
        });
        ltvChinese.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                User.saveInt(User.LANGUAGE, 6, context);
                dismiss();

            }
        });

        mRootView.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT));

        setContentView(mRootView);
    }

    /**
     * Animate track.
     *
     * @param mAnimateTrack flag to animate track
     */
    public void mAnimateTrack(boolean mAnimateTrack) {
        this.mAnimateTrack = mAnimateTrack;
    }

    /**
     * Set animation style.
     *
     * @param mAnimStyle animation style, default is set to ANIM_AUTO
     */
    public void setAnimStyle(int mAnimStyle) {
        this.mAnimStyle = mAnimStyle;
    }

    /**
     * Add action item
     *
     * @param action {@link ActionItem}
     */

    public void setOnActionItemClickListener(OnActionItemClickListener listener) {
        mItemClickListener = listener;
    }

    /**
     * Show popup mWindow
     */
    public void show(View anchor) {
        preShow();

        int[] location = new int[2];

        mDidAction = false;

        anchor.getLocationOnScreen(location);

        Rect anchorRect = new Rect(location[0], location[1], location[0]
                + anchor.getWidth(), location[1] + anchor.getHeight());

        // mRootView.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,
        // LayoutParams.WRAP_CONTENT));
        mRootView.measure(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

        int rootWidth = mRootView.getMeasuredWidth();
        int rootHeight = mRootView.getMeasuredHeight();

        int screenWidth = mWindowManager.getDefaultDisplay().getWidth();
        // int screenHeight = mWindowManager.getDefaultDisplay().getHeight();

        int xPos = (screenWidth - rootWidth) / 2;
        int yPos = anchorRect.top - rootHeight;

        boolean onTop = true;

        // display on bottom
        if (rootHeight > anchor.getTop()) {
            yPos = anchorRect.bottom;
            onTop = false;
        }

        // showArrow(((onTop) ? R.id.arrow_down : R.id.arrow_up),
        // anchorRect.centerX());

        setAnimationStyle(screenWidth, anchorRect.centerX(), onTop);

        mWindow.showAtLocation(anchor, Gravity.RIGHT | Gravity.TOP, xPos, yPos);

        if (mAnimateTrack)
            mTrack.startAnimation(mTrackAnim);
    }

    /**
     * Set animation style
     *
     * @param screenWidth Screen width
     * @param requestedX  distance from left screen
     * @param onTop       flag to indicate where the popup should be displayed. Set TRUE
     *                    if displayed on top of anchor and vice versa
     */
    // sdfas
    private void setAnimationStyle(int screenWidth, int requestedX,
                                   boolean onTop) {
        // int arrowPos = requestedX - mArrowUp.getMeasuredWidth() / 2;

        mWindow.setAnimationStyle(R.style.Animations_PopDownMenu_Right);

    }

    /**
     * Show arrow
     *
     * @param whichArrow arrow type resource id
     * @param requestedX distance from left screen
     */
    private void showArrow(int whichArrow, int requestedX) {
        // final View showArrow = (whichArrow == R.id.arrow_up) ? mArrowUp
        // : mArrowDown;
        // final View hideArrow = (whichArrow == R.id.arrow_up) ? mArrowDown
        // : mArrowUp;

        // final int arrowWidth = mArrowUp.getMeasuredWidth();

        // showArrow.setVisibility(View.VISIBLE);

        // ViewGroup.MarginLayoutParams param = (ViewGroup.MarginLayoutParams)
        // showArrow
        // .getLayoutParams();
        //
        // param.leftMargin = requestedX - arrowWidth / 2;

        // hideArrow.setVisibility(View.INVISIBLE);
    }

    /**
     * Set listener for window dismissed. This listener will only be fired if
     * the quicakction dialog is dismissed by clicking outside the dialog or
     * clicking on sticky item.
     */
    public void setOnDismissListener(QuickAction.OnDismissListener listener) {
        setOnDismissListener(this);

        mDismissListener = listener;
    }

    @Override
    public void onDismiss() {
        if (!mDidAction && mDismissListener != null) {
            mDismissListener.onDismiss();
        }
    }

    /**
     * Listener for item click
     */
    public interface OnActionItemClickListener {
        public abstract void onItemClick(QuickAction source, int pos,
                                         int actionId);
    }

    /**
     * Listener for window dismiss
     */
    public interface OnDismissListener {
        public abstract void onDismiss();
    }
}
