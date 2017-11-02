package to.msn.wings.sample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by 4163209 on 11/2/2017.
 */

public class Damage_setting extends AppCompatActivity implements View.OnClickListener{
    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.damage_setting);

        findViewById(R.id.return_Top).setOnClickListener(this);
        findViewById(R.id.return_prev).setOnClickListener(this);
    }
    public void onClick(View view) {     //ボタンがクリックされたとき
        switch (view.getId()) {
            case R.id.return_Top:       //トップに戻る
                Intent itop = new Intent(Damage_setting.this, MainActivity.class);
                startActivity(itop);
                break;
            case R.id.return_prev:       //メニューに戻る
                Intent iprev = new Intent(Damage_setting.this, Menu.class);
                startActivity(iprev);
                break;
        }
    }
}
