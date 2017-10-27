package to.msn.wings.sample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by 4163214 on 10/26/2017.
 */

public class Image_setting extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.image_setting_and_change);

        findViewById(R.id.return_Page).setOnClickListener(this);
        findViewById(R.id.return_Top).setOnClickListener(this);
    }

    public void onClick(View view) {     //ボタンがクリックされたとき
        switch (view.getId()) {
            case R.id.return_Top:    //トップに戻る
                Intent itop = new Intent(Image_setting.this, MainActivity.class);
                startActivity(itop);
                break;
            case R.id.return_Page:    //前のページに戻る
                Intent ipage = new Intent(Image_setting.this, Menu.class);
                startActivity(ipage);
                break;
        }
    }
}
