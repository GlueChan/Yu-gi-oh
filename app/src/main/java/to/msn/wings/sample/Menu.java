package to.msn.wings.sample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import static to.msn.wings.sample.R.id.Tutorial;

/**
 * Created by 4163214 on 10/26/2017.
 */

public class Menu extends AppCompatActivity implements View.OnClickListener{
    
    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.menu_screen);

        findViewById(R.id.Button_return_top).setOnClickListener(this);
        findViewById(R.id.Button_Change).setOnClickListener(this);
        findViewById(R.id.Button_damage).setOnClickListener(this);
        findViewById(R.id.setting_life).setOnClickListener(this);
        findViewById(Tutorial).setOnClickListener(this);
        
    }

    public void onClick(View view) {     //ボタンがクリックされたとき
        switch (view.getId()) {
            case R.id.Button_return_top:    //トップに戻る
                finish();
                break;
            case R.id.Button_Change:    //画像の追加・変更
                Intent ichange = new Intent(Menu.this, Picture.class);    //Image_setting
                startActivity(ichange);
                break;
            case R.id.Button_damage:    //ダメージ量の変更
                Intent idamage = new Intent(Menu.this,DB.class);
                startActivity(idamage);
                break;
            case R.id.setting_life:    //初期ライフの設定
                Intent ilife = new Intent(Menu.this, DB_Life.class);
                startActivity(ilife);
                break;
            case Tutorial:        //Tutorial
                Intent iTutorial = new Intent(Menu.this,Tutorial_test.class);
                startActivity(iTutorial);
        }
    }
}
