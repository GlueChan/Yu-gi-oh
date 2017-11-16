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

public class DB extends AppCompatActivity {
    private DamageDatabaseHelper helper = null;
    private EditText txtNUMBER = null;
    private EditText txtNAME   = null;
    private EditText txtDamage =null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(db);

        //ヘルパーを準備
        helper = new DamageDatabaseHelper(this);
        txtNUMBER = (EditText) findViewById(R.id.txtNumber);
        txtNAME = (EditText) findViewById(R.id.txtNAME);
        txtDamage = (EditText) findViewById(R.id.txtDamage);

        //データベースを取得
        SQLiteDatabase db = helper.getWritableDatabase();

        try{
            Toast.makeText(this, "接続しました", Toast.LENGTH_SHORT).show();

        }finally {
            db.close();
        }
    }


    public void onSave(View view){
        SQLiteDatabase db = helper.getWritableDatabase();
        try {
            ContentValues cv = new ContentValues();
            cv.put("number",txtNUMBER.getText().toString());
            cv.put("name",txtNAME.getText().toString());
            cv.put("damage",txtDamage.getText().toString());
            db.insertWithOnConflict("damage",null,cv,SQLiteDatabase.CONFLICT_REPLACE);
            Toast.makeText(this,"データ登録完了",Toast.LENGTH_SHORT).show();
        }finally {
            db.close();
        }
    }

    public void onSearch(View view){
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cs = null;

        try {
            String[] cols = {"number", "name", "damage"};
            String [] params = {txtNUMBER.getText().toString()};
            cs = db.query("damage",cols,"number = ?",params,null,null,null,null);

            if(cs.moveToFirst()){
                txtNAME.setText(cs.getString(1));
                txtDamage.setText(cs.getString(2));
            }else {
                Toast.makeText(this,"データがありません",Toast.LENGTH_SHORT).show();
            }
        }finally {
            cs.close();
            db.close();
        }
    }
}
