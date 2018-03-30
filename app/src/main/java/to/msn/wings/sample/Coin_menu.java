package to.msn.wings.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by 4163214 on 10/26/2017.
 */

public class Coin_menu extends AppCompatActivity implements  View.OnClickListener{

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.coin_menu);

        Button coin_1mai = (Button)findViewById(R.id.coin_1mai);
        Button coin_2mai = (Button)findViewById(R.id.coin_2mai);
        Button coin_3mai = (Button)findViewById(R.id.coin_3mai);
        Button return_Top = (Button)findViewById(R.id.return_Top);

        coin_1mai.setOnClickListener(this);
        coin_2mai.setOnClickListener(this);
        coin_3mai.setOnClickListener(this);
        return_Top.setOnClickListener(this);
    }

    private  void setCoin1() {

       // findViewById(R.id.coin_1mai).setOnClickListener(this);
        setContentView(R.layout.coin_1);
    }

    private  void setCoin2() {

       // findViewById(R.id.coin_2mai).setOnClickListener(this);
        setContentView(R.layout.coin_2);
    }

    private  void setCoin3() {

       // findViewById(R.id.coin_3mai).setOnClickListener(this);
        setContentView(R.layout.coin_3);
    }


    public void onClick(View view) {     //ボタンがクリックされたとき
        switch (view.getId()) {
                case R.id.return_Top:       //トップに戻る
//                    Intent itop = new Intent(Coin_menu.this, MainActivity.class);
//                    startActivity(itop);
//                    finish();
                    finish();
                    break;
                case R.id.coin_1mai:       //Coin1_screenに進む
//                    Intent icoin1 = new Intent(Coin_menu.this,Coin1_screen.class);
//                    startActivity(icoin1);
                    setCoin1();
                    break;
                case R.id.coin_2mai:       //Coin2_screenに進む
//                    Intent icoin2 = new Intent(Coin_menu.this, Coin2_screen.class);
//                    startActivity(icoin2);
                    setCoin2();
                    break;
                case R.id.coin_3mai:       //Coin3_screenに進む
//                    Intent icoin3 = new Intent(Coin_menu.this, Coin3_screen.class);
//                    startActivity(icoin3);
                    setCoin3();
                break;
        }
    }
}
