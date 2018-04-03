package to.msn.wings.sample;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by 4163209 on 11/2/2017.
 */

public class Coin1_screen extends AppCompatActivity implements View.OnClickListener{
    ImageView coin;

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.coin_1);

        findViewById(R.id.return_Top).setOnClickListener(this);
        findViewById(R.id.coin_menu).setOnClickListener(this);

        findViewById(R.id.button1).setOnClickListener(this);

        //coin = (ImageView)findViewById(R.id.coin);
    }
    public void onClick(View view) {     //ボタンがクリックされたとき
        switch (view.getId()) {
            case R.id.return_Top:       //トップに戻る
                Intent itop = new Intent(Coin1_screen.this, MainActivity.class);
                startActivity(itop);
                finish();
                break;
            case R.id.coin_menu:       //コインニューに進む
                Intent icoinmenu = new Intent(Coin1_screen.this, Coin_menu.class);
                startActivity(icoinmenu);
                finish();
                break;
            case R.id.button1:
                TypedArray typedArray = getResources().obtainTypedArray(R.array.coin);
                int i = (int)(Math.floor(Math.random() * 2));
                Drawable drawable = typedArray.getDrawable(i);
                coin.setImageDrawable(drawable);
                break;
        }
    }
}
