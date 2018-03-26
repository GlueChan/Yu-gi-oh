package to.msn.wings.sample;

import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    PreferenceManager preferenceManager;

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.main);

        preferenceManager=new PreferenceManager(this);

        findViewById(R.id.player).setOnClickListener(this);
        findViewById(R.id.player2).setOnClickListener(this);
        findViewById(R.id.menu).setOnClickListener(this);
        findViewById(R.id.coin).setOnClickListener(this);
        findViewById(R.id.dice).setOnClickListener(this);

        //preferenceManager.getIntData(Config.PREF_KEY_PLAYER1_BACKGROUND,6);
        //preferenceManager.getIntData(Config.PREF_KEY_PLAYER2_BACKGROUND,6);
    }

    @Override
    protected void onStart() {
        super.onResume();
        Button buttonplayer1 = (Button)findViewById(R.id.player);
        Button buttonplayer2 = (Button)findViewById(R.id.player2);

        int resId1 = preferenceManager.getIntData(Config.PREF_KEY_PLAYER1_BACKGROUND,6);    //初回起動時
        int resId2 = preferenceManager.getIntData(Config.PREF_KEY_PLAYER2_BACKGROUND,6);    //初回起動時

        String play1_bgpath=preferenceManager.getStringData("Player1_Path",null);
        String play2_bgpath=preferenceManager.getStringData("Player2_Path",null);

        if(play1_bgpath==null) {
            buttonplayer1.setBackgroundResource(Config.getBackgroundImageId(resId1));
            //buttonplayer2.setBackgroundResource(Config.getBackgroundImageId(resId2));
        }if(play2_bgpath==null) {
            //buttonplayer1.setBackgroundResource(Config.getBackgroundImageId(resId1));
            buttonplayer2.setBackgroundResource(Config.getBackgroundImageId(resId2));
        }/*if(play1_bgpath=="0"){

        }if(play2_bgpath=="0"){

        }*/else{
            Bitmap bmp =setupBackgroundBitmap(getContentResolver(),play1_bgpath);
            Bitmap bmp2 =setupBackgroundBitmap(getContentResolver(),play2_bgpath);
            BitmapDrawable image = new BitmapDrawable(bmp);
            BitmapDrawable image2 = new BitmapDrawable(bmp2);
            buttonplayer1.setBackground(image);
            buttonplayer2.setBackground(image2);
        }
    }

    public void onClick(View view){     //ボタンがクリックされたとき
        //String tag=(String)view.getTag();
        switch (view.getId()) {
            case R.id.player:           //プレイヤー1のボタンがクリック
                Intent iplayer = new Intent(MainActivity.this, Player1_screen.class);
                startActivity(iplayer);
                break;
            case R.id.player2:          //プレイヤー2のボタンがクリック
                Intent iplayer2 = new Intent(MainActivity.this, Player2_screen.class);
                startActivity(iplayer2);
                break;
            case R.id.menu:             //メニュー画面を開く
                Intent imenu = new Intent(MainActivity.this, Menu.class);
                startActivity(imenu);
                break;
            case R.id.coin:             //コイン画面を開く
                Intent icoin = new Intent(MainActivity.this, Coin1_screen.class);
                startActivity(icoin);
                break;
            case R.id.dice:             //ダイス画面を開く
                Intent idice = new Intent(MainActivity.this, Dice_screen.class);
                startActivity(idice);
                break;
        }

    }

    public static Bitmap setupBackgroundBitmap(ContentResolver contentResolver, String imagePath) {

        Bitmap bitmap = null;
        File file = new File(imagePath);

        try {
            Uri uri = Uri.fromFile(file);

            //bitmap = MediaStore.Images.Media.getBitmap(contentResolver,uri);

            InputStream inputStream = new FileInputStream(file);

            bitmap = BitmapFactory.decodeStream(inputStream, null, null);
            inputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return bitmap;
    }

}
