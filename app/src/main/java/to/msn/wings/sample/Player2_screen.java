package to.msn.wings.sample;

import android.annotation.TargetApi;
import android.content.Intent;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
/**
 * Created by 4163214 on 10/26/2017.
 */

public class Player2_screen extends AppCompatActivity implements View.OnClickListener,TextWatcher{
    private int sound1, sound2, sound3, sound4, sound5,
            sound6, sound7, sound8, sound9, sound0,sound00, sound000,
            soundAdd, soundSub, soundDivision, soundEqual;

    Button button0, button1, button2, button3, button4, button5,
            button6, button7, button8, button9, button00, button000,
            buttonAdd,       //足し算
            buttonSub,       //引き算
            buttonDivision, //割り算
            buttonEqual;    //イコール

    private static EditText editText;

    int ValueOne, ValueTwo;

    boolean Addtion, Subtraction, Division,Equal;


    DamageDatabaseControls damageDatabaseControls;
	 LifeDataBaseControl lifeDataBaseControl;


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

       /*データベースのインスタンス*/
        damageDatabaseControls = new DamageDatabaseControls(this);
    	lifeDataBaseControl = new LifeDataBaseControl(this);
    	
    	findViewById(R.id.return_Top).setOnClickListener(this);
    	
    	 editText = (EditText) findViewById(R.id.Player_cal2);

        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

                //  (str == null || str.length() == 0)
                if(!TextUtils.isEmpty(v.getText())) {
                    ValueTwo = Integer.parseInt(v.getText().toString());
                } else {
                    ValueTwo = 0;
                }
                v.setText(String.valueOf(ValueTwo));

                return false;
            }
        });


        // 現在のintentを取得する
        Intent intent = getIntent();
        // intentから指定キーの文字列を取得する
        String player2_life = intent.getStringExtra("player2_life");
        editText.setText(player2_life);

        //リスナーをセット
        editText.addTextChangedListener(this);

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
        buttonSub = (Button) findViewById(R.id.Button_Subtraction);
        buttonDivision = (Button) findViewById(R.id.Button_Division);
        buttonEqual = (Button) findViewById(R.id.Button_Equal);

        sound1 = pool.load(this, R.raw.test, 1);
        sound2 = pool.load(this, R.raw.test, 1);
        sound3 = pool.load(this, R.raw.test, 1);
        sound4 = pool.load(this, R.raw.test, 1);
        sound5 = pool.load(this, R.raw.test, 1);
        sound6 = pool.load(this, R.raw.test, 1);
        sound7 = pool.load(this, R.raw.test, 1);
        sound8 = pool.load(this, R.raw.test, 1);
        sound9 = pool.load(this, R.raw.test, 1);
        sound0 = pool.load(this, R.raw.test, 1);
        sound00 = pool.load(this, R.raw.test, 1);
        sound000 = pool.load(this, R.raw.test, 1);
        soundAdd = pool.load(this, R.raw.test, 1);
        soundSub = pool.load(this, R.raw.test, 1);
        soundDivision = pool.load(this, R.raw.test, 1);
        soundEqual = pool.load(this, R.raw.test, 1);

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
                pool.play(soundAdd, 1.0f, 1.0f, 1, 0, 1);
                if (editText.length() == 0) {
                    Addtion = false;
                    editText.setText("");
                } else {
                    ValueOne = Integer.parseInt(editText.getText().toString());
                    Addtion = true;
                    editText.setText(null);
                }
            }
        });

        //引きざん
        buttonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pool.play(soundSub, 1.0f, 1.0f, 1, 0, 1);

                if (editText.length() == 0) {
                    Subtraction = false;
                    editText.setText("");
                } else {
                    Subtraction = true;
                    ValueOne = Integer.parseInt(editText.getText().toString());
                    editText.setText(null);
                }
            }
        });

        //わり算
        buttonDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pool.play(soundDivision, 1.0f, 1.0f, 1, 0, 1);

                if (editText.length() == 0) {
                    Division = false;
                    editText.setText("");
                } else {
                    Division = true;
                    ValueOne = Integer.parseInt(editText.getText().toString());
                    editText.setText(null);
                }
            }
        });


        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pool.play(soundEqual, 1.0f, 1.0f, 1, 0, 1);

                ValueTwo = Integer.parseInt(editText.getText().toString());

                if (Addtion) {
                    Log.d("ValueOne", "" + ValueOne);
                    Log.d("ValueTwo", "" + ValueTwo);
                    editText.setText(ValueOne + ValueTwo + "");
                    Log.d("足し算：", "" + editText.getText().toString());
                    Addtion = false;
                }

                if (Subtraction) {
                    Log.d("ValueOne", "" + ValueOne);
                    Log.d("ValueTwo", "" + ValueTwo);

                    if (ValueOne - ValueTwo < 0) {
                        editText.setText("0");
                        Log.d("引き算マイナス：", "" + editText.getText().toString());
                        Subtraction = false;
                    } else {
                        editText.setText(ValueOne - ValueTwo + "");
                        Log.d("引き算：", "" + editText.getText().toString());
                        Subtraction = false;
                    }
                }

                if (Division) {
                    Log.d("ValueOne", "" + ValueOne);
                    Log.d("ValueTwo", "" + ValueTwo);
                    editText.setText(ValueOne / ValueTwo + "");
                    Log.d("割り算：", "" + editText.getText().toString());
                    Division = false;

                    if (ValueOne / ValueTwo < -1) {
                        editText.setText(0);
                        Log.d("割り算マイナス：", "" + editText.getText().toString());
                        Division = false;
                    }
                }
            }
        });

        //editTextに入力されている文字列を判断し,
        //文字列が0の場合はイコールボタンを押せなくさせ、
        //文字列が1以上(ValueOneに値が入っている)場合はValueTwoに値を入れてイコールを押せるようにする
        buttonEqual.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(editText.length()==0){
                    return true;
                }

                if(editText.length() >=1){
                    ValueTwo = Integer.parseInt(editText.getText().toString());
                }
                return false;
            }
        });
    }


    //先頭の"0"を削除する
    public static String DeleteZero(String  str){
        return str.replaceFirst("^0+","");
    }

    //文字列が修正される直前に呼び出されるメソッド
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count,int after) {
    }

    //文字1つを入力したときに呼び出される
    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
    }

    //最後に呼ばれるメソッド
    @Override
    public void afterTextChanged(Editable s){
        String string = s.toString();

        if(string.length()>4){
            ValueOne = Integer.parseInt(string);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        damageDatabaseControls.damageAddBtnCreate((LinearLayout)findViewById(R.id.damageBtnLayout));
    	lifeDataBaseControl.lifeAddBtnCreate((EditText) findViewById(R.id.Player_cal2));
    }

    public static void setPlayer2APtext(String text) {
        Log.i("setPlayer2APtext", text);
        editText.setText(text);
    }

    public void onClick(View view) {     //ボタンがクリックされたとき
        switch (view.getId()) {
            case R.id.return_Top:       //トップに戻る
//                Intent itop = new Intent(Player2_screen.this, MainActivity.class);
//                startActivity(itop);
                MainActivity.setPlayer2Life(editText.getText().toString());
                MainActivity.setPlayer2Buttonlife(editText.getText().toString());
                finish();
                break;
        }
    }
}
