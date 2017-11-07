package to.msn.wings.sample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by 4163209 on 11/2/2017.
 */

public class Life_background extends AppCompatActivity implements View.OnClickListener{

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.life_background);

        findViewById(R.id.return_Top).setOnClickListener(this);
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
        }
    }
}
