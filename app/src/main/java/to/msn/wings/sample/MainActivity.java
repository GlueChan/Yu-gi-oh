package to.msn.wings.sample;

import android.Manifest;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    PreferenceManager preferenceManager;
    LifeDataBaseControl lifeDataBaseControl;

    static TextView Player1Text;
    static TextView Player2Text;

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.main);

        Player1Text = (TextView) findViewById(R.id.Player1_Life);
        Player2Text = (TextView) findViewById(R.id.Player2_Life);

        preferenceManager=new PreferenceManager(this);
        lifeDataBaseControl = new LifeDataBaseControl(this);

        findViewById(R.id.player).setOnClickListener(this);
        findViewById(R.id.player2).setOnClickListener(this);
        findViewById(R.id.menu).setOnClickListener(this);
        findViewById(R.id.coin).setOnClickListener(this);
        findViewById(R.id.dice).setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();

        Button buttonplayer1 = (Button)findViewById(R.id.player);
        Button buttonplayer2 = (Button)findViewById(R.id.player2);

        int resId1 = preferenceManager.getIntData(Config.PREF_KEY_PLAYER1_BACKGROUND,6);    //初回起動時
        int resId2 = preferenceManager.getIntData(Config.PREF_KEY_PLAYER2_BACKGROUND,6);    //初回起動時

        String play1_bgpath=preferenceManager.getStringData("Player1_Path","0");
        String play2_bgpath=preferenceManager.getStringData("Player2_Path","0");

        /*if(play1_bgpath=="0"){
            buttonplayer1.setBackgroundResource(Config.getBackgroundImageId(resId1));
        }else{
            Bitmap bmp =setupBackgroundBitmap(getContentResolver(),play1_bgpath);
            BitmapDrawable image = new BitmapDrawable(bmp);
            buttonplayer1.setBackground(image);
        }*/

        /*if(play2_bgpath=="0"){
            buttonplayer2.setBackgroundResource(Config.getBackgroundImageId(resId2));
        }else{
            Bitmap bmp2 =setupBackgroundBitmap(getContentResolver(),play2_bgpath);
            BitmapDrawable image2 = new BitmapDrawable(bmp2);
            buttonplayer2.setBackground(image2);
        }*/

        if (play1_bgpath.startsWith("/storage")) {
            Bitmap bmp =setupBackgroundBitmap(getContentResolver(),play1_bgpath);
            BitmapDrawable image = new BitmapDrawable(bmp);
            buttonplayer1.setBackground(image);
        }else{
            buttonplayer1.setBackgroundResource(Config.getBackgroundImageId(resId1));
        }

        if (play2_bgpath.startsWith("/storage")) {
            Bitmap bmp2 =setupBackgroundBitmap(getContentResolver(),play2_bgpath);
            BitmapDrawable image2 = new BitmapDrawable(bmp2);
            buttonplayer2.setBackground(image2);
        }else{
            buttonplayer2.setBackgroundResource(Config.getBackgroundImageId(resId2));
        }
    }

    public void onClick(View view){     //ボタンがクリックされたとき
        //String tag=(String)view.getTag();
        switch (view.getId()) {
            case R.id.player:           //プレイヤー1のボタンがクリック
                Intent iPlyer = new Intent(MainActivity.this, Player1_screen.class);
                String life = Player1Text.getText().toString();
                iPlyer.putExtra("player1_life",life);
                startActivity(iPlyer);
                break;
            case R.id.player2:          //プレイヤー2のボタンがクリック
                Intent iPlayer2 = new Intent(MainActivity.this, Player2_screen.class);
                String life2 = Player2Text.getText().toString();
                iPlayer2.putExtra("player2_life",life2);
                startActivity(iPlayer2);
                break;
            case R.id.menu:             //メニュー画面を開く
                Intent imenu = new Intent(MainActivity.this, Menu.class);
                startActivity(imenu);
                break;
            case R.id.coin:             //コイン画面を開く
                SelectCoinDialog dialog = new SelectCoinDialog();
                dialog.show(this);
//                Intent icoin = new Intent(MainActivity.this, Coin_menu.class);
//                startActivity(icoin);
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

    static void setPlayer1Life(String life){
        Player1Text.setText(life);
    }

    static void setPlayer2Life(String life2){
        Player2Text.setText(life2);
    }
}