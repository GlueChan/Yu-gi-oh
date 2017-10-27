package to.msn.wings.sample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by 4163214 on 10/26/2017.
 */

public class Dice_screen extends AppCompatActivity implements View.OnClickListener{

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.dice);

        findViewById(R.id.return_Top).setOnClickListener(this);
    }
    public void onClick(View view) {     //ボタンがクリックされたとき
        switch (view.getId()) {
            case R.id.return_Top:       //トップに戻る
                Intent itop = new Intent(Dice_screen.this, MainActivity.class);
                startActivity(itop);
                break;

        }
    }
}
