package to.msn.wings.sample;

import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Coin extends AppCompatActivity {
    Button button1, button2, button3;
    ImageView coin1, coin2, coin3;

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);

        coin1 = (ImageView) findViewById(R.id.coin1);
        coin2 = (ImageView) findViewById(R.id.coin2);
        coin3 = (ImageView) findViewById(R.id.coin3);
    }

    private void setCoin1() {
        button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCoin1();
                if (v == button1) {
                    TypedArray typedArray = getResources().obtainTypedArray(R.array.coin);
                    int i = (int) (Math.floor(Math.random() * 2));
                    Drawable drawable = typedArray.getDrawable(i);
                    coin1.setImageDrawable(drawable);
                }
            }
        });
    }

    private void setCoin2() {
        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCoin2();
                if (v == button2) {
                    TypedArray typedArray = getResources().obtainTypedArray(R.array.coin);
                    int i = (int) (Math.floor(Math.random() * 2));
                    Drawable drawable = typedArray.getDrawable(i);
                    coin2.setImageDrawable(drawable);
                }
            }
        });
    }

    private void setCoin3() {
        button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCoin3();
                if (v == button3) {
                    TypedArray typedArray = getResources().obtainTypedArray(R.array.coin);
                    int i = (int) (Math.floor(Math.random() * 2));
                    Drawable drawable = typedArray.getDrawable(i);
                    coin3.setImageDrawable(drawable);
                }
            }
        });
    }


    public void onClick(View view) {     //ボタンがクリックされたとき
        switch (view.getId()) {
            case R.id.coin_menu:       //コインニューに進む
                Intent icoinmenu = new Intent(this, Coin_menu.class);
                startActivity(icoinmenu);
                //finish();
                break;
//            case R.id.button1:
//                setCoin1();
//                break;
//            case  R.id.button2:
//                setCoin2();
//                break;
//            case R.id.button3:
//                setCoin3();
//                break;
        }
    }
}


