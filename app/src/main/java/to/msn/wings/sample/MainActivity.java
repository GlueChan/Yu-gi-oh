package to.msn.wings.sample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.main);

        findViewById(R.id.player).setOnClickListener(this);
        findViewById(R.id.player2).setOnClickListener(this);
        findViewById(R.id.menu).setOnClickListener(this);
        findViewById(R.id.coin).setOnClickListener(this);
        findViewById(R.id.dice).setOnClickListener(this);
    }

    public void onClick(View view){     //ボタンがクリックされたとき
        //String tag=(String)view.getTag();
        switch (view.getId()) {
            case R.id.player:           //プレイヤー1のボタンがクリック
                Intent iplayer = new Intent(MainActivity.this, Player1_screen.class);
                startActivity(iplayer);
                break;
            case R.id.player2:          //プレイヤー2のボタンがクリック
                Intent iplayer2 = new Intent(MainActivity.this, Player2_screen.class);
                startActivity(iplayer2);
                break;
            case R.id.menu:             //メニュー画面を開く
                Intent imenu = new Intent(MainActivity.this, Menu.class);
                startActivity(imenu);
                break;
            case R.id.coin:             //コイン画面を開く
                Intent icoin = new Intent(MainActivity.this, Coin1_screen.class);
                startActivity(icoin);
                break;
            case R.id.dice:             //ダイス画面を開く
                Intent idice = new Intent(MainActivity.this, Dice_screen.class);
                startActivity(idice);
                break;
        }

    }
}
