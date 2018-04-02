package to.msn.wings.sample;

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

public class Dice_screen extends AppCompatActivity implements View.OnClickListener{
    Button button1;
    ImageView dice;

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.dice);

        findViewById(R.id.return_Top).setOnClickListener(this);

        button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);

        dice = (ImageView) findViewById(R.id.dice);
    }
    public void onClick(View view) {     //ボタンがクリックされたとき
        switch (view.getId()) {
            case R.id.return_Top:       //トップに戻る
                finish();
                break;
            case R.id.button1:
                TypedArray typedArray = getResources().obtainTypedArray(R.array.dice);
                int i = (int)(Math.floor(Math.random() * 6));
                Drawable drawable = typedArray.getDrawable(i);
                dice.setImageDrawable(drawable);
                break;
        }
    }
}
