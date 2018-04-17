package to.msn.wings.sample;

import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import static android.graphics.Bitmap.createScaledBitmap;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    PreferenceManager preferenceManager;
    LifeDataBaseControl lifeDataBaseControl;

    static TextView Player1Text;
    static TextView Player2Text;

    static ImageView ibtnPlayer1;
    static ImageView ibtnPlayer2;

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.main);

        preferenceManager=new PreferenceManager(this);
        lifeDataBaseControl = new LifeDataBaseControl(this);

        Player1Text = (TextView) findViewById(R.id.tvP1Life);
        Player2Text = (TextView) findViewById(R.id.tvP2Life);


        // プレイヤーの初期値を設定
        Player1Text.setText(String.valueOf(lifeDataBaseControl.getPlayerDefLife()));
        Player2Text.setText(String.valueOf(lifeDataBaseControl.getPlayerDefLife()));


        findViewById(R.id.layoutP1).setOnClickListener(this);
        findViewById(R.id.layoutP2).setOnClickListener(this);
        findViewById(R.id.btnMenu).setOnClickListener(this);
        findViewById(R.id.btnCoin).setOnClickListener(this);
        findViewById(R.id.btnDice).setOnClickListener(this);

        findViewById(R.id.btnReset).setOnClickListener(this);


       //TopMenuの画像に書いてるライフポイント
        ibtnPlayer1 = (ImageView) findViewById(R.id.ivP1);
        ibtnPlayer2 = (ImageView) findViewById(R.id.ivP2);

        //preferenceManager.getIntData(Config.PREF_KEY_PLAYER1_BACKGROUND,6);
        //preferenceManager.getIntData(Config.PREF_KEY_PLAYER2_BACKGROUND,6);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {

        ImageView buttonplayer1 = (ImageView)findViewById(R.id.ivP1);
        ImageView buttonplayer2 = (ImageView)findViewById(R.id.ivP2);

        int resId1 = preferenceManager.getIntData(Config.PREF_KEY_PLAYER1_BACKGROUND,6);    //初回起動時
        int resId2 = preferenceManager.getIntData(Config.PREF_KEY_PLAYER2_BACKGROUND,6);    //初回起動時

        String play1_bgpath=preferenceManager.getStringData("Player1_Path","0");
        String play2_bgpath=preferenceManager.getStringData("Player2_Path","0");

        setPlayerImage(ibtnPlayer1, play1_bgpath, 1);
        setPlayerImage(ibtnPlayer2, play2_bgpath, 2);

//        if (play1_bgpath.startsWith("/storage")) {
//            Bitmap bmp1 =setupBackgroundBitmap(getContentResolver(),play1_bgpath);
//            Bitmap bmpFitSize = createScaledBitmap(bmp1,buttonplayer1.getWidth(),buttonplayer1.getHeight(),false);
//            buttonplayer1.setImageBitmap(bmpFitSize);
//        }else{
//            buttonplayer1.setBackgroundResource(Config.getBackgroundImageId(resId1));
//        }
//
//        //画像をリサイズする
//        if (play2_bgpath.startsWith("/storage")) {
//            Bitmap bmp2 =setupBackgroundBitmap(getContentResolver(),play2_bgpath);
//            Bitmap bmpFitSize = createScaledBitmap(bmp2,buttonplayer2.getWidth(), buttonplayer2.getHeight(), false);
//            buttonplayer2.setImageBitmap(bmpFitSize);
//        }else{
//            buttonplayer2.setBackgroundResource(Config.getBackgroundImageId(resId2));
//        }
    }

    public void onClick(View view){     //ボタンがクリックされたとき
        //String tag=(String)view.getTag();
        switch (view.getId()) {
            case R.id.layoutP1:           //プレイヤー1のボタンがクリック
                Intent iPlayer = new Intent(MainActivity.this, Player1_screen.class);
                int life = Integer.valueOf(Player1Text.getText().toString());
                iPlayer.putExtra("playerLife",life);
                iPlayer.putExtra("playerId",1);
                startActivity(iPlayer);
                break;
            case R.id.layoutP2:          //プレイヤー2のボタンがクリック
                Intent iPlayer2 = new Intent(MainActivity.this, Player1_screen.class);
                int life2 = Integer.valueOf(Player2Text.getText().toString());
                iPlayer2.putExtra("playerLife",life2);
                iPlayer2.putExtra("playerId",2);
                startActivity(iPlayer2);
                break;
            case R.id.btnMenu:             //メニュー画面を開く
                Intent imenu = new Intent(MainActivity.this, Menu.class);
                startActivity(imenu);
                break;
            case R.id.btnCoin:             //コイン画面を開く
                SelectCoinDialog dialog = new SelectCoinDialog();
                dialog.show(this);
                break;
            case R.id.btnDice:             //ダイス画面を開く
                Intent idice = new Intent(MainActivity.this, Dice_screen.class);
                startActivity(idice);
                break;
            case R.id.btnReset:
                MainActivity.setPlayer1Life("8000");
                MainActivity.setPlayer2Life("8000");
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

    /**
     * プレイヤーのImageViewに画像をセットする
     * @param imageView 画像をセットするImageView
     * @param imagePath ユーザーの指定した画像
     * @param userId プレイヤーのID（Default画像の切り替えで使用）
     */
    private void setPlayerImage(ImageView imageView, String imagePath, int userId) {
        if (imagePath.startsWith("/storage")) {
            // ユーザーのストレージに保存されている画像
            Bitmap bmp = setupBackgroundBitmap(getContentResolver(), imagePath);
            // 画像をImageViewに合わせてリサイズする
            Bitmap bmpFitSize = createScaledBitmap(bmp, imageView.getWidth(), imageView.getHeight(), false);
            Log.d("imageView.getWidth",imageView.getWidth() +"");
            Log.d("imageView.getHeight",imageView.getHeight() +"");
            // ImageViewに画像をセットする
            imageView.setImageBitmap(bmpFitSize);
        } else {
            // Defaultの背景画像を表示する
            imageView.setImageResource(Config.getBackgroundImageId(userId));
        }
    }
}

