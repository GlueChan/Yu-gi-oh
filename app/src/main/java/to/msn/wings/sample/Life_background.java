package to.msn.wings.sample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by 4163209 on 11/2/2017.
 */

public class Life_background extends AppCompatActivity implements View.OnClickListener{
    int setNumber=0;

    PreferenceManager preferenceManager;

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.life_background);

        preferenceManager=new PreferenceManager(this);

        findViewById(R.id.return_Top).setOnClickListener(this);
        findViewById(R.id.return_prev).setOnClickListener(this);
        findViewById(R.id.change_player1).setOnClickListener(this);
        findViewById(R.id.change_player2).setOnClickListener(this);
        findViewById(R.id.background_change).setOnClickListener(this);
        findViewById(R.id.background_change2).setOnClickListener(this);
    }

    public void onClick(View view) {     //ボタンがクリックされたとき
        switch (view.getId()) {
            case R.id.return_Top:       //トップに戻る
                Intent itop = new Intent(Life_background.this, MainActivity.class);
                startActivity(itop);
                break;
            case R.id.return_prev:       //画像設定に戻る
                Intent iprev = new Intent(Life_background.this, Image_setting.class);
                startActivity(iprev);
                break;
            case R.id.change_player1:       //対象プレイヤーを1にする
                setNumber=1;
                Config.changeID(1);
                break;
            case R.id.change_player2:       //対象プレイヤーを2にする
               setNumber=2;
                Config.changeID(2);
                break;
            case R.id.background_change:       //背景画像を変更
                if(android.os.Build.VERSION.SDK_INT< android.os.Build.VERSION_CODES.JELLY_BEAN){
                    if(setNumber==1)
                        preferenceManager.putData(Config.PREF_KEY_PLAYER1_BACKGROUND,0);        //画像を変更する
                    else if(setNumber==2)
                        preferenceManager.putData(Config.PREF_KEY_PLAYER2_BACKGROUND,0);        //画像を変更する
                }else{
                    if(setNumber==1)
                        preferenceManager.putData(Config.PREF_KEY_PLAYER1_BACKGROUND,0);        //画像を変更する
                    else if(setNumber==2)
                        preferenceManager.putData(Config.PREF_KEY_PLAYER2_BACKGROUND,0);        //画像を変更する
                }
                break;
            case R.id.background_change2:       //背景画像を変更
                if(android.os.Build.VERSION.SDK_INT< android.os.Build.VERSION_CODES.JELLY_BEAN){
                    if(setNumber==1)
                        preferenceManager.putData(Config.PREF_KEY_PLAYER1_BACKGROUND,1);        //画像を変更する
                    else if(setNumber==2)
                        preferenceManager.putData(Config.PREF_KEY_PLAYER2_BACKGROUND,1);        //画像を変更する
                }else{
                    if(setNumber==1)
                        preferenceManager.putData(Config.PREF_KEY_PLAYER1_BACKGROUND,1);        //画像を変更する
                    else if(setNumber==2)
                        preferenceManager.putData(Config.PREF_KEY_PLAYER2_BACKGROUND,1);        //画像を変更する
                }
                break;
        }
    }
}
