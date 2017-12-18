package to.msn.wings.sample;

import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by 4163214 on 10/26/2017.
 */

public class Coin3_screen extends AppCompatActivity implements View.OnClickListener{
    Button button1;
    ImageView coin1, coin2, coin3;

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.coin_3);

        findViewById(R.id.return_Top).setOnClickListener(this);
        findViewById(R.id.coin_menu).setOnClickListener(this);

        button1 = (Button)findViewById(R.id.button1);
        button1.setOnClickListener(this);

        coin1 = (ImageView)findViewById(R.id.coin1);
        coin2 = (ImageView)findViewById(R.id.coin2);
        coin3 = (ImageView)findViewById(R.id.coin3);
    }
    public void onClick(View view) {     //ボタンがクリックされたとき
        switch (view.getId()) {
            case R.id.return_Top:       //トップに戻る
                Intent itop = new Intent(Coin3_screen.this, MainActivity.class);
                startActivity(itop);
                break;
            case R.id.coin_menu:       //コインニューに進む
                Intent icoinmenu = new Intent(Coin3_screen.this, Coin_menu.class);
                startActivity(icoinmenu);
                break;
        }
        if (view == button1) {
            TypedArray typedArray = getResources().obtainTypedArray(R.array.coin);
            int i = (int)(Math.floor(Math.random() * 2));
            Drawable drawable = typedArray.getDrawable(i);
            coin1.setImageDrawable(drawable);
        }
        if (view == button1) {
            TypedArray typedArray = getResources().obtainTypedArray(R.array.coin);
            int i = (int)(Math.floor(Math.random() * 2));
            Drawable drawable = typedArray.getDrawable(i);
            coin2.setImageDrawable(drawable);
        }
        if (view == button1) {
            TypedArray typedArray = getResources().obtainTypedArray(R.array.coin);
            int i = (int)(Math.floor(Math.random() * 2));
            Drawable drawable = typedArray.getDrawable(i);
            coin3.setImageDrawable(drawable);
        }
    }
}
