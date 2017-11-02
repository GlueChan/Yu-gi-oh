package to.msn.wings.sample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by 4163209 on 11/2/2017.
 */

public class Coin1_screen extends AppCompatActivity implements View.OnClickListener{
    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.coin_1);

        findViewById(R.id.return_Top).setOnClickListener(this);
        findViewById(R.id.coin_menu).setOnClickListener(this);
    }
    public void onClick(View view) {     //ボタンがクリックされたとき
        switch (view.getId()) {
            case R.id.return_Top:       //トップに戻る
                Intent itop = new Intent(Coin1_screen.this, MainActivity.class);
                startActivity(itop);
                break;
            case R.id.coin_menu:       //コインニューに進む
                Intent icoinmenu = new Intent(Coin1_screen.this, Coin_menu.class);
                startActivity(icoinmenu);
                break;
        }
    }
}
