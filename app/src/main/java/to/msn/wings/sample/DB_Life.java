package to.msn.wings.sample;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class DB_Life extends AppCompatActivity implements View.OnClickListener{
    private  LifeDatabaseHelper helper = null;
    private EditText txtLife = null;

    public static int Count = 0;

    public static int GetCount(){
        return  Count;
    }

    private  LifeDataBaseControl mLifeDataBaseControl;
    @Override
        protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.life_setting);
        findViewById(R.id.return_Page).setOnClickListener(this);


        //ヘルパーを準備
        helper = new LifeDatabaseHelper(this);
        txtLife = (EditText) findViewById(R.id.txtLife);

        //データベースを取得
        SQLiteDatabase db = helper.getWritableDatabase();
        mLifeDataBaseControl = new LifeDataBaseControl(this);

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
            cv.put("life", txtLife.getText().toString());
            //db.insertWithOnConflict("life", null, cv, SQLiteDatabase.CONFLICT_REPLACE);
            //db.updateWithOnConflict("life", null, cv,  SQLiteDatabase.CONFLICT_REPLACE);
            db.update(LifeDatabaseHelper.TABLE_LIFE, cv, "number = ?",new String[]{"1"} );

            Toast.makeText(this, "データ登録完了", Toast.LENGTH_SHORT).show();


            // 登録と同時にMainActivityの表示も初期化
            MainActivity.setPlayer1Life(txtLife.getText().toString());
            MainActivity.setPlayer2Life(txtLife.getText().toString());
        } finally {
            db.close();
        }
    }

    public void onClick(View view) {     //ボタンがクリックされたとき
        switch (view.getId()) {
            case R.id.return_Page:       //トップに戻る
//                Intent itop = new Intent(DB_Life.this, Menu.class);
//                startActivity(itop);
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

