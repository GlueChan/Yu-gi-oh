package to.msn.wings.sample;

import android.annotation.TargetApi;
import android.content.Intent;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by 4163214 on 10/26/2017.
 */

public class Player2_screen extends AppCompatActivity implements View.OnClickListener{
    private int sound1, sound2, sound3, sound4, sound5,
            sound6, sound7, sound8, sound9, sound0,sound00, sound000,
            soundAdd, soundSub, soundDivision, soundC, soundEqual;

    Button button0, button1, button2, button3, button4, button5,
            button6, button7, button8, button9, button00, button000,
            buttonAdd,       //足し算
            buttonSub,       //引き算
            buttonDivision, //割り算
            buttonC,         //クリア
            buttonEqual;    //イコール

    EditText editText;

    int ValueOne, ValueTwo;

    boolean Addtion, Subtraction, Division;

    @SuppressWarnings("deprecation")
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private SoundPool buildSoundPool(int poolMax)
    {
        SoundPool pool = null;

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            pool = new SoundPool(poolMax, AudioManager.STREAM_MUSIC, 0);
        }
        else {
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
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dentaku_player2);

        findViewById(R.id.return_Top).setOnClickListener(this);

        button0 = (Button) findViewById(R.id.Button_0);
        button00 = (Button) findViewById(R.id.Button_00);
        button000 = (Button) findViewById(R.id.Button_000);
        button1 = (Button) findViewById(R.id.Button_1);
        button2 = (Button) findViewById(R.id.Button_2);
        button3 = (Button) findViewById(R.id.Button_3);
        button4 = (Button) findViewById(R.id.Button_4);
        button5 = (Button) findViewById(R.id.Button_5);
        button6 = (Button) findViewById(R.id.Button_6);
        button7 = (Button) findViewById(R.id.Button_7);
        button8 = (Button) findViewById(R.id.Button_8);
        button9 = (Button) findViewById(R.id.Button_9);

        buttonAdd = (Button) findViewById(R.id.Button_Add);
        buttonSub = (Button) findViewById(R.id.Button_subtraction);
        buttonDivision = (Button) findViewById(R.id.Button_Dvision);
        buttonC = (Button) findViewById(R.id.return_prev);
        buttonEqual = (Button) findViewById(R.id.Button_Equal);

        editText = (EditText) findViewById(R.id.Player_cal2);

        sound1 = pool.load(this, R.raw.one, 1);
        sound2 = pool.load(this, R.raw.two, 1);
        sound3 = pool.load(this, R.raw.three, 1);
        sound4 = pool.load(this, R.raw.fore, 1);
        sound5 = pool.load(this, R.raw.five, 1);
        sound6 = pool.load(this, R.raw.six, 1);
        sound7 = pool.load(this, R.raw.seven, 1);
        sound8 = pool.load(this, R.raw.eight, 1);
        sound9 = pool.load(this, R.raw.nine, 1);
        sound0 = pool.load(this, R.raw.nine, 1);
        sound00 = pool.load(this, R.raw.nine, 1);
        sound000 = pool.load(this, R.raw.nine, 1);
        soundAdd = pool.load(this, R.raw.nine, 1);
        soundSub = pool.load(this, R.raw.nine, 1);
        soundDivision = pool.load(this, R.raw.nine, 1);
        soundC = pool.load(this, R.raw.nine, 1);
        soundEqual = pool.load(this, R.raw.nine, 1);

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pool.play(sound0, 1.0f, 1.0f, 0, 0, 1);
                editText.setText(editText.getText() + "0");
            }
        });

        button00.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pool.play(sound00, 1.0f, 1.0f, 0, 0, 1);
                editText.setText(editText.getText() + "00");
            }
        });

        button000.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pool.play(sound000, 1.0f, 1.0f, 0, 0, 1);
                editText.setText(editText.getText() + "000");
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pool.play(sound1, 1.0f, 1.0f, 0, 0, 1);
                editText.setText(editText.getText() + "1");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pool.play(sound2, 1.0f, 1.0f, 0, 0, 1);
                editText.setText(editText.getText() + "2");
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pool.play(sound3, 1.0f, 1.0f, 0, 0, 1);
                editText.setText(editText.getText() + "3");
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pool.play(sound4, 1.0f, 1.0f, 0, 0, 1);
                editText.setText(editText.getText() + "4");
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pool.play(sound5, 1.0f, 1.0f, 0, 0, 1);
                editText.setText(editText.getText() + "5");
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pool.play(sound6, 1.0f, 1.0f, 0, 0, 1);
                editText.setText(editText.getText() + "6");
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pool.play(sound7, 1.0f, 1.0f, 0, 0, 1);
                editText.setText(editText.getText() + "7");
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pool.play(sound8, 1.0f, 1.0f, 0, 0, 1);
                editText.setText(editText.getText() + "8");
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pool.play(sound9, 1.0f, 1.0f, 0, 0, 1);
                editText.setText(editText.getText() + "9");
            }
        });


        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pool.play(soundAdd, 1.0f, 1.0f, 0, 0, 1);
                if (editText == null) {
                    editText.setText("");
                } else {
                    ValueOne = Integer.parseInt(editText.getText() + "");
                    Addtion = true;
                    editText.setText(null);
                }
            }
        });

        buttonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pool.play(soundSub, 1.0f, 1.0f, 0, 0, 1);
                ValueOne = Integer.parseInt(editText.getText() + "");
                Subtraction = true;
                editText.setText(null);
            }
        });

        buttonDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pool.play(soundDivision, 1.0f, 1.0f, 0, 0, 1);
                ValueOne = Integer.parseInt(editText.getText() + "");
                Subtraction = true;
                editText.setText(null);

            }
        });


        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pool.play(soundEqual, 1.0f, 1.0f, 0, 0, 1);
                ValueTwo = Integer.parseInt(editText.getText() + "");

                if (Addtion == true) {
                    editText.setText(ValueOne + ValueTwo + "");
                    Addtion = false;
                }

                if (Subtraction == true) {
                    editText.setText(ValueOne - ValueTwo + "");
                    Subtraction = false;
                }

                if (Division == true) {
                    editText.setText(ValueOne / ValueTwo + "");
                    Division = false;
                }
            }

        });
    }

    public void onClick(View view) {     //ボタンがクリックされたとき
        switch (view.getId()) {
            case R.id.return_Top:       //トップに戻る
                Intent itop = new Intent(Player2_screen.this, MainActivity.class);
                startActivity(itop);
                break;
        }
    }
}
