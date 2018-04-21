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
import android.widget.Toast;

import static to.msn.wings.sample.MainActivity.setPlayer1Life;
import static to.msn.wings.sample.MainActivity.setPlayer2Life;

/**
 * Created by 4163209 on 10/24/2017.
 */

public class Player1_screen extends AppCompatActivity implements View.OnClickListener,TextWatcher {

    private int sound1, sound2, sound3, sound4, sound5,
            sound6, sound7, sound8, sound9, sound0, sound00, sound000,
            soundAdd, soundSub, soundDivision, soundEqual, soundButton;

    Button button0, button1, button2, button3, button4, button5,
            button6, button7, button8, button9, button00, button000,
            buttonAdd,       //足し算
            buttonSub,       //引き算
            buttonDivision, //割り算
            buttonC,         //クリア
            buttonEqual,    //イコール
            buttonReturn,
            buttonPrev;      //1つ前のライフを表示

    private static EditText editText;

    TextView TplayerName;

    int ValueOne, ValueTwo, ValueThree, PlayerId, Test;

    int PrevValue;

    boolean Addtion, Subtraction, Division;

    DamageDatabaseControls damageDatabaseControls;

    LifeDataBaseControl lifeDataBaseControl;

    MainActivity mainActivity;

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
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dentaku_player1);

        /*データベースのインスタンス*/
        damageDatabaseControls = new DamageDatabaseControls(this);

        lifeDataBaseControl = new LifeDataBaseControl(this);

        //mainActivity = new MainActivity();

        findViewById(R.id.return_Top).setOnClickListener(this);
        findViewById(R.id.Button_Equal).setOnClickListener(this);

        //電卓の計算場所
        editText = (EditText) findViewById(R.id.Player_cal1);

        //Topmenuで変更したPlayerの名前を電卓画面にも反映させる
        TplayerName = (TextView)findViewById(R.id.Text_name);

        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

                //  (str == null || str.length() == 0)
                if (!TextUtils.isEmpty(v.getText())) {
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
        editText.setText("" + intent.getIntExtra("playerLife", 0));

        PlayerId = intent.getIntExtra("playerId", 0);

        if(PlayerId == 1){
            TplayerName.setText(intent.getStringExtra("player1"));
            Log.d("TplayerName1",TplayerName.getText().toString());
        }
        if(PlayerId == 2){
            TplayerName.setText(intent.getStringExtra("playerName2"));
            Log.d("TplayerName2",TplayerName.getText().toString());
        }

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
        buttonC = (Button) findViewById(R.id.LifeCLEAR);
        buttonEqual = (Button) findViewById(R.id.Button_Equal);
        buttonReturn = (Button) findViewById(R.id.return_Top);

        buttonPrev = (Button) findViewById(R.id.Prev_Life);

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
        soundButton = pool.load(this, R.raw.test, 1);
        soundEqual = pool.load(this, R.raw.test, 1);
        soundButton = pool.load(this, R.raw.test, 1);


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
                pool.play(sound2, 1.0f, 1.0f, 1, 0, 1);

                editText.setText(editText.getText() + "2");
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pool.play(sound3, 1.0f, 1.0f, 1, 0, 1);

                editText.setText(editText.getText() + "3");
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pool.play(sound4, 1.0f, 1.0f, 1, 0, 1);

                editText.setText(editText.getText() + "4");
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pool.play(sound5, 1.0f, 1.0f, 1, 0, 1);

                editText.setText(editText.getText() + "5");
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pool.play(sound6, 1.0f, 1.0f, 1, 0, 1);

                editText.setText(editText.getText() + "6");
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pool.play(sound7, 1.0f, 1.0f, 1, 0, 1);

                editText.setText(editText.getText() + "7");
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pool.play(sound8, 1.0f, 1.0f, 1, 0, 1);

                editText.setText(editText.getText() + "8");
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pool.play(sound9, 1.0f, 1.0f, 1, 0, 1);

                editText.setText(editText.getText() + "9");
            }
        });

        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pool.play(soundAdd, 1.0f, 1.0f, 1, 0, 1);
                editText.setText("8000");
                buttonPrev.setText("8000");
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
                    Test = 1;
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
                    ValueOne = Integer.parseInt(editText.getText().toString());
                    Subtraction = true;
                    Test = 1;
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
                    ValueOne = Integer.parseInt(editText.getText().toString());
                    Division = true;
                    Test = 1;
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

                    ValueOne = Prev_Life(ValueOne);
                    ValueThree = ValueOne + ValueTwo;
                    editText.setText(ValueThree + "");
                    ValueOne = Cd_ValueThree(ValueThree);
                    Log.d("足し算：", "" + editText.getText().toString());
                    Test = 1;
                    Addtion = false;
                    Test = 0;

                }
                if (Subtraction) {
                    Log.d("ValueOne", "" + ValueOne);
                    Log.d("ValueTwo", "" + ValueTwo);

                    ValueOne = Prev_Life(ValueOne);

                    if (ValueOne - ValueTwo < 0) {
                        editText.setText("0");
                        Log.d("引き算マイナス：", "" + editText.getText().toString());
                        Test = 1;
                        Subtraction = false;
                        Test = 0;

                    } else {

                        ValueOne = Prev_Life(ValueOne);

                        ValueThree = ValueOne - ValueTwo;

                        editText.setText(ValueThree + "");

                        ValueOne = Cd_ValueThree(ValueThree);

                        Log.d("引き算：", "" + editText.getText().toString());
                        Test = 1;
                        Subtraction = false;
                        Test = 0;
                    }
                }

                if (Division) {
                    //ValueTwoが0ではない時
                    if (ValueTwo != 0) {
                        Log.d("ValueOne", "" + ValueOne);
                        Log.d("ValueTwo", "" + ValueTwo);

                        ValueOne = Prev_Life(ValueOne);

                        //getIsjudgeで切り上げした答えをValueThreeに代入
                        ValueThree = getIsjudge(ValueOne, ValueTwo);

                        //ValueThreeの値をValueOneに代入
                        editText.setText(ValueThree + "");

                        ValueOne = Cd_ValueThree(ValueThree);
                        Log.d("割り算：", "" + editText.getText().toString());
                        Test = 1;
                        Division = false;
                        Test = 0;

                        //ValueTwoが"0"の時
                    } else {
                        ValueOne = Prev_Life(ValueOne);
                        judgeZero(ValueTwo, "0では割れませんよ");
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
                if (editText.length() == 0) {
                    return true;
                }
                if (editText.length() >= 1) {
//                    Uri uri = Uri.parse("http://morijyobi.ac.jp/");
//                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
//                    startActivity(intent);
                    ValueTwo = Integer.parseInt(editText.getText().toString());
                }
                return false;
            }
        });


        //editTextの中身がなしの場合Top画面に戻れなくなる
        buttonReturn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (editText.length() == 0) {
                    return true;
                }
                return false;
            }
        });

        //＋ボタンが押されたときに変数Testに1が入る
        //変数Testが1の時＋ボタンは押せなくなる
        //＝ボタンが押されると変数Testは0になる
        buttonAdd.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (Test == 1) {
                    return true;
                }
                if (Test == 0) {
                    Test = 0;
                }
                return false;
            }
        });

        //－ボタンが押されたときに変数Testに1が入る
        //変数Testが1の時－ボタンは押せなくなる
        //＝ボタンが押されると変数Testは0になる
        buttonSub.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (Test == 1) {
                    return true;
                }
                if (Test == 0) {
                    Test = 0;
                }
                return false;
            }
        });

        //÷ボタンが押されたときに変数Testに1が入る
        //変数Testが1の時÷ボタンは押せなくなる
        //＝ボタンが押されると変数Testは0になる
        buttonDivision.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (Test == 1) {
                    return true;
                }
                if (Test == 0) {
                    Test = 0;
                }
                return false;
            }
        });

        buttonPrev.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                pool.play(soundDivision, 1.0f, 1.0f, 1, 0, 1);

                //editTextの中身がValueOneと同じ場合は押させない
                if (editText.getText().equals(buttonPrev.getText())) {
                    Log.d("押せない", editText.equals(buttonPrev.getText()) + "");
                    return true;
                }

                //editTextの中身とbuttonPrevの中身が違う場合は押せるようにする
                //1つ前の値をeditTextにセットする
                editText.setText(buttonPrev.getText());
                return false;
            }
        });
    }

    //文字列が修正される直前に呼び出されるメソッド
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    //文字1つを入力したときに呼び出される
    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
    }

    //最後に呼ばれるメソッド
    @Override
    public void afterTextChanged(Editable s) {
    }


    @Override
    protected void onStart() {
        super.onStart();
        damageDatabaseControls.damageAddBtnCreate((LinearLayout) findViewById(R.id.damageBtnLayout));
        lifeDataBaseControl.lifeAddBtnCreate((EditText) findViewById(R.id.Player_cal1));
        lifeDataBaseControl.lifeAddBtnCreate((EditText) findViewById(R.id.Player_cal2));
    }

    public static void setPlayerAPtext(String text) {
        Log.i("setPlayer1APtext", text);
        editText.setText(text);
    }
    public void judgeZero(int ValueTwo, String text) {
        try {
            if (ValueTwo == 0) {
                throw new ArithmeticException();
            }
        } catch (java.lang.ArithmeticException devied_by_zero) {
            String s = String.valueOf(ValueOne);
            Toast.makeText(this, text, Toast.LENGTH_LONG).show();
            editText.setText(s);
            Test = 0;
        }
    }

    public int getIsjudge(int ValueOne, int ValueTwo) {

        //ValueOneが0以外の時かつValueTowが1以上
        if (ValueOne != 0 && ValueTwo >= 1) {

            //editTextの中身がある時
            if (editText.length() > 0) {

                //doubleに変換し答えを出す
                double d = (double) ValueOne / ValueTwo;

                Log.d("d", "" + d);

                //小数点以下を切り上げする
                d = Math.ceil(d);

                //切り上げしたdをint型へ変換
                ValueThree = (int) d;

                Log.d("ValueThree", "" + ValueThree);

            }
        }
        return ValueThree;

    }


    //ValueThreeに格納された答えをValueOneに入れ替える
    public int Cd_ValueThree(int ValueThree) {

        ValueOne = ValueThree;

        return ValueOne;
    }

    //1つ前のライフに戻す
    public int Prev_Life(int ValueOne){
        PrevValue = ValueOne;
        buttonPrev.setText(PrevValue+"");
        Log.d("buttonPrev",""+ PrevValue);
        ValueOne = PrevValue;
        return ValueOne;
    }


//    //TopMenuで変更したPlayer1の名前を計算画面のPlayerのところにセットする
//    public void setPlayer1Name(String name){
//        PlayerName1.setText(name);
//        Log.d("PlayerName1",""+ PlayerName1.getText());
//    }
//
//    //TopMenuで変更したPlayer2の名前を計算画面のPlayerのところにセットする
//    public void setPlayer2Name(String name){
//        PlayerName2.setText(name);
//        Log.d("PlayerName2",""+ PlayerName2.getText());
//    }


    public void onClick(View view) {     //ボタンがクリックされたとき
        switch (view.getId()) {
            case R.id.return_Top:       //トップに戻る
                // プレイヤーIDに合わせてライフを更新する
                switch (PlayerId) {
                    case 1:
                        setPlayer1Life(editText.getText().toString());
                        //TplayerName.setText("");
                        break;
                    case 2:
                        setPlayer2Life(editText.getText().toString());
                        //TplayerName.setText("");
                        break;
                    default:
                        break;
                }
                finish();
                break;

            }
        }
    }
