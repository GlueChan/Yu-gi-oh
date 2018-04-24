package to.msn.wings.sample;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by 4163209 on 12/19/2017.
 */

public class LifeDatabaseHelper extends SQLiteOpenHelper {
    static final private String DBNAME = "DALIFE";
    static final private int VERSION = 1;

    public static final String TABLE_LIFE = "life";

    //コンストラクター
    public LifeDatabaseHelper(Context context) {
        super(context,DBNAME,null,VERSION);
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
    }

    //データベース作成時にテーブルとダメージデータを作成

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE life("+
                "number INTEGER PRIMARY KEY, name TEXT , " + TABLE_LIFE +" INTEGER,)");

        db.execSQL("INSERT INTO "+ TABLE_LIFE +"(number,name,life)"+
                "VALUES('1','ライフ8000',8000)");
    }

    //データベースをバージョンアップしたとき、テーブルを再編成
    public void onUpgrade(SQLiteDatabase db,int old_v,int new_v){
        db.execSQL("DROP TABLE IF EXISTS life");
        onCreate(db);
    }
}


