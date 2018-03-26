package to.msn.wings.sample;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;
import java.io.IOException;

import static to.msn.wings.sample.R.id.player;

/**
 * Created by 4163214 on 1/16/2018.
 */

public class Picture extends AppCompatActivity implements View.OnClickListener{
    private static final int READ_REQUEST_CODE=42;
    ImageView imageView;
    private Bitmap gallery;
    int setNumber=0;
    Button playerbut;
    PreferenceManager preferenceManager;

    @Override
    protected void onCreate(Bundle bundle){
        super.onCreate(bundle);
        setContentView(R.layout.gallery);

        preferenceManager=new PreferenceManager(this);

        Button button1=(Button)findViewById(R.id.get_image);
        Button button2=(Button)findViewById(R.id.set_image);
        imageView=(ImageView)findViewById(R.id.image_view);

        playerbut = (Button) findViewById(player);

        findViewById(R.id.return_Page).setOnClickListener(this);
        findViewById(R.id.return_Top).setOnClickListener(this);
        findViewById(R.id.change_player1).setOnClickListener(this);
        findViewById(R.id.change_player2).setOnClickListener(this);

        button1.setOnClickListener(new View.OnClickListener(){
            //
            @Override
            public void onClick(View v){
                Intent intent=new Intent(Intent.ACTION_OPEN_DOCUMENT);
                intent.addCategory(Intent.CATEGORY_OPENABLE);
                intent.setType("image/*");

                startActivityForResult(intent,READ_REQUEST_CODE);

            }
        });

        button2.setOnClickListener(new View.OnClickListener(){
            //
            @Override
            public void onClick(View v){
                /*preferenceManager.putData("Player1_Path", 0);
                preferenceManager.putData("Player2_Path", 0);
                //Log.d("Player1_Path","null");
                Log.d("Player1_path",preferenceManager.getStringData("Player1_Path",null));*/
            }
        });
        /*button2.setOnClickListener(new View.OnClickListener(){
            //
            @Override
            public void onClick(View v){
                Intent intent=new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                intent.setType("image/*");

                startActivityForResult(intent,READ_REQUEST_CODE);
            }
        });*/
    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.return_Page:      //前のページに戻る
                Intent ipage=new Intent(Picture.this,Menu.class);      //Image_setting
                //画像データを渡す
                ipage.putExtra("Data",gallery);
                startActivity(ipage);
                break;
            case R.id.return_Top:       //トップに戻る
                Intent itop=new Intent(Picture.this,MainActivity.class);
                startActivity(itop);
                break;
            case R.id.change_player1:   //対象をプレイヤー1に変える
                setNumber=1;
                Log.d("Player1",setNumber+"Change");
                break;
            case R.id.change_player2:   //対象をプレイヤー2に変える
                setNumber=2;
                Log.d("Player2",setNumber+"Change");
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode,int resultCode,
                                 Intent resultData){
        if(requestCode==READ_REQUEST_CODE&&resultCode== Activity.RESULT_OK){
            Uri uri=null;
            if(resultData !=null){
                String filePas=getImagePath(getContentResolver(),resultData.getData());

                Log.d("failpath",filePas);
                uri=resultData.getData();
                Log.d("uri",uri.getPath());
                Log.d("setNuber",setNumber+"");
                try{
                    Bitmap bitmap=MediaStore.Images.Media.getBitmap(getContentResolver(),uri);
                    imageView.setImageBitmap(bitmap);
                    gallery=MediaStore.Images.Media.getBitmap(getContentResolver(),uri);
                    if(setNumber==1) {
                        preferenceManager.putData("Player1_Path", filePas);
                        Log.d("Player1_path","OK");
                    }else if(setNumber==2){
                        preferenceManager.putData("Player2_Path", filePas);
                        Log.d("Player2_path","OK");
                    }
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }


    /**
     * 選択された画像ファイルパスを返す
     *
     * @param contentResolver
     * @param uri
     * @return
     */
    public static String getImagePath(ContentResolver contentResolver, Uri uri) {

        String retPath = "";

        if (uri == null) return retPath;

        File file = new File(uri.getPath());
        if (file.exists()) {
            return uri.getPath();
        }

        if (Build.VERSION.SDK_INT < 19) {

            String[] columns = {MediaStore.Images.Media.DATA};
            Cursor cursor = contentResolver.query(uri, columns, null, null, null);
            if (cursor != null) {
                cursor.moveToFirst();
                retPath = cursor.getString(0);
                cursor.close();
            }
        } else {

            // 画像のファイルパスを取得
            String id = DocumentsContract.getDocumentId(uri);
            Cursor cursor = null;
            switch (uri.getAuthority()) {
                case "com.android.providers.media.documents":
                    //ギャラリーからの場合
                    String selection = "_id=?";
                    String[] selectionArgs = new String[]{id.split(":")[1]};
                    cursor = contentResolver.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[]{MediaStore.Images.Media.DATA}, selection, selectionArgs, null);
                    break;

                case "com.android.providers.downloads.documents":
                    // ダウンロードからの場合
                    Uri docUri = ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(id));
                    cursor = contentResolver.query(docUri, new String[]{MediaStore.Images.Media.DATA}, null, null, null);
                    break;

                default:
                    // その他
                    break;
            }

            if (cursor != null) {
                // ファイルパスを取得して保存
                if (cursor.moveToFirst()) {
                    retPath = cursor.getString(0);
                }
                cursor.close();
            }
        }

        return retPath;
    }
}
