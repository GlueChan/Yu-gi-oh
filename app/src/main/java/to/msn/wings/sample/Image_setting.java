package to.msn.wings.sample;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by 4163214 on 10/26/2017.
 */

public class Image_setting extends AppCompatActivity implements View.OnClickListener{

    private Bitmap gallery;

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.image_setting_and_change);

        findViewById(R.id.return_Page).setOnClickListener(this);
        findViewById(R.id.return_Top).setOnClickListener(this);
        findViewById(R.id.Add_photo).setOnClickListener(this);
        findViewById(R.id.to_Sample).setOnClickListener(this);
        findViewById(R.id.to_Album).setOnClickListener(this);
        findViewById(R.id.Life_point).setOnClickListener(this);

        Intent ipic=getIntent();
        gallery=(Bitmap)ipic.getParcelableExtra("Data");

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
            /*case R.id.Add_photo:    //画像を追加
                Intent iphoto = new Intent(Image_setting.this, Menu.class);
                startActivity(iphoto);
                break;*/
            case R.id.to_Sample:    //サンプルに移動
                Intent isample = new Intent(Image_setting.this, Life_background.class);
                startActivity(isample);
                break;
            /*case R.id.to_Album:    //アルバムに移動
                Intent ialbum = new Intent(Image_setting.this, Menu.class);
                startActivity(ialbum);
                break;*/
            case R.id.Life_point:    //ライフポイントの背景画像変更
                Intent ilife = new Intent(Image_setting.this, Picture.class);
                startActivity(ilife);
                break;
        }
    }
}
