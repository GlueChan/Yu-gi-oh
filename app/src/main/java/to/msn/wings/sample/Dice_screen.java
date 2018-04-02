package to.msn.wings.sample;


import android.annotation.TargetApi;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by 4163214 on 10/26/2017.
 */

public class Dice_screen extends AppCompatActivity implements View.OnClickListener {
    private int sound;
    Button button1;
    ImageView dice;

    @SuppressWarnings("deprecation")   // 警告メッセージの抑制
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private SoundPool buildSoundPool(int poolMax) {
        SoundPool pool = null;

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            pool = new SoundPool(poolMax, AudioManager.STREAM_MUSIC, 0);
        } else {
            AudioAttributes attr = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_MEDIA)
                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                    .build();

            pool = new SoundPool.Builder()
                    .setAudioAttributes(attr)
                    .setMaxStreams(poolMax)
                    .build();
        }
        return pool;
    }

    final int SOUND_POOL_MAX = 6;
    SoundPool pool = buildSoundPool(SOUND_POOL_MAX);


    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.dice);

        findViewById(R.id.return_Top).setOnClickListener(this);

        button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);

        dice = (ImageView) findViewById(R.id.dice);

        sound = pool.load(this, R.raw.saikoro, 1);

    }

    public void onClick(final View view) {     //ボタンがクリックされたとき
        switch (view.getId()) {
            case R.id.return_Top:       //トップに戻る
                finish();
                break;
            case R.id.button1:
                pool.play(sound, 1.0f, 1.0f, 0, 0, 1);
        }
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (view == button1) {
                    TypedArray typedArray = getResources().obtainTypedArray(R.array.dice);
                    int i = (int) (Math.floor(Math.random() * 6));
                    Drawable drawable = typedArray.getDrawable(i);
                    dice.setImageDrawable(drawable);
                }
            }
        }, 1000);
    }
}

