package to.msn.wings.sample;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by 4163209 on 11/14/2017.
 */

public class DamageDatabaseHelper extends SQLiteOpenHelper {
    static final private String DBNAME = "DAMAGE";
    static final private int VERSION =1;

    //コンストラクター
   public DamageDatabaseHelper(Context context) {
       super(context,DBNAME,null,VERSION);
   }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
    }

    //データベース作成時にテーブルとダメージデータを作成

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE damage("+
                "number INTEGER PRIMARY KEY, name TEXT , damage INTEGER)");

        db.execSQL("INSERT INTO damage(number,name,damage)"+
                "VALUES('1','ダメージ100',100)");


    }
}

