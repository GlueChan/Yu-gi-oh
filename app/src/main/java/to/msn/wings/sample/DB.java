package to.msn.wings.sample;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import static to.msn.wings.sample.R.layout.db;

/**
 * Created by 4163209 on 11/14/2017.
 */

public class DB extends AppCompatActivity implements View.OnClickListener{
    private DamageDatabaseHelper helper = null;
    private EditText txtDamage = null;
    Cursor cursor =null;
    private DamageDatabaseControls mDamageDatabaseControls;

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(db);

        findViewById(R.id.return_Page).setOnClickListener(this);


        //ヘルパーを準備
        helper = new DamageDatabaseHelper(this);
        txtDamage = (EditText) findViewById(R.id.txtDamage);

        //データベースを取得
        SQLiteDatabase db = helper.getWritableDatabase();
        mDamageDatabaseControls = new DamageDatabaseControls(this);

        try {
            Toast.makeText(this, "接続しました", Toast.LENGTH_SHORT).show();

        } finally {
            db.close();
        }
    }

    public void onSave() {
        SQLiteDatabase db = helper.getWritableDatabase();
        try {
            ContentValues cv = new ContentValues();

            cv.put("damage", txtDamage.getText().toString());

            cursor = db.query("damage", null, null, null, null, null, null, null);

            //入力したテキストが空白の場合はeditTextに0を入力する
            if (txtDamage.length() == 0) {
                Toast toast = Toast.makeText(this, "数字を入力して", Toast.LENGTH_LONG);
                toast.show();
                txtDamage.setText("0");

            } else {
                db.insertWithOnConflict("damage", null, cv, SQLiteDatabase.CONFLICT_REPLACE);

                Toast.makeText(this, "データ登録完了", Toast.LENGTH_SHORT).show();
            }

        } finally {
            db.close();
        }
    }

    public void onClick(View view) {     //ボタンがクリックされたとき
        switch (view.getId()) {
            case R.id.return_Page:    //前のページに戻る
//                Intent ipage = new Intent(DB.this, Menu.class);
//                startActivity(ipage);
                finish();
                break;
            case R.id.btnSave:
                onSave();
                break;

//            case R.id.btnSearch:
//                // ダメージボタンをLineaLayoutに追加
//                mDamageDatabaseControls.damageAddBtnCreate((LinearLayout) findViewById(R.id.damageBtnLayout));
//                break;

            default:
                break;
        }
    }
}

