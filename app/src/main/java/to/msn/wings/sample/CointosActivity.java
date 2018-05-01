package to.msn.wings.sample;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import static to.msn.wings.sample.R.drawable.gold;
import static to.msn.wings.sample.R.drawable.gold1;

public class CointosActivity extends AppCompatActivity implements View.OnClickListener {
    Button button1, button2, button3;
    ImageView coin1, coin2, coin3;
    int selectCoinCount;

    int mCoinFlg = 0;

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_cointos);

        // dialogで選択されたコインの枚数を取得
        selectCoinCount = getIntent().getIntExtra("coin", 1);

        // コインの表示場所
        LinearLayout layoutCoin = (LinearLayout) findViewById(R.id.layout_coin);

        // 戻るボタンのonClickイベント
        Button btnBack = (Button) findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        // コインの表示場所
        LinearLayout layoutCoin = (LinearLayout) findViewById(R.id.layout_coin);
        // 指定された回数、コインボタンを追加する
        for (int i = 0; i < selectCoinCount; i++) {
            layoutCoin.addView(createButton(), (int) convertDp2Px(100, getApplicationContext()), (int) convertDp2Px(100, getApplicationContext()));
        }
    }

    private Button createButton() {
      final Button btn = new Button(this);
        btn.setBackgroundResource(gold);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // コイントス処理関数を呼び出す
                ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 1.0f, 1.0f, 0.0f, Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF, 0.5f);
                scaleAnimation.setDuration(100);
                //コインの長さを変更
                scaleAnimation.setRepeatCount(10);
                scaleAnimation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        mCoinFlg = (int) (Math.floor(Math.random() * 2));
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                        mCoinFlg++;

                        if (mCoinFlg % 2 == 0){
                            btn.setBackgroundResource(gold1);
                        }else{
                            btn.setBackgroundResource(gold);
                        }
                    }
                });

                AnimationSet animationSet = new AnimationSet(true);
                animationSet.addAnimation(scaleAnimation);
                btn.startAnimation(animationSet);
            }
        });
        return btn;
    }



    /**
     * dpをpxに変換する
     * @param dp
     * @param context
     * @return
     */
    public static float convertDp2Px(float dp, Context context){
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        return dp * metrics.density;
    }

    /**
     * pxをdpに変換する
     *
     * @param px
     * @param context
     * @return
     */
    public static float convertPx2Dp(int px, Context context) {
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        return px / metrics.density;
    }


    public void onClick(View view) {     //ボタンがクリックされたとき
        switch (view.getId()) {
            case R.id.return_Top:       //トップに戻る
                Intent itop = new Intent(CointosActivity.this, MainActivity.class);
                startActivity(itop);
                finish();
                break;
        }
    }
}