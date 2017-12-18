package to.msn.wings.sample;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * Created by 4163209 on 12/12/2017.
 */

public class DamageDatabaseControls {

    private Context mContext;
    private DamageDatabaseHelper damageDatabaseHelper;


    //コンストラクター
    public DamageDatabaseControls(Context context) {
        mContext = context;
        damageDatabaseHelper = new DamageDatabaseHelper(mContext);
    }

    public void damageAddBtnCreate(LinearLayout layout) {
        SQLiteDatabase db = damageDatabaseHelper.getReadableDatabase();
        Cursor cs = null;

        try {
            String[] cols = {"number", "name", "damage"};
            cs = db.query("damage", cols, null, null, null, null, null, null);

            //dbにデータがある間ボタンを生成
            //もし、データがなければ終了
            if (cs.moveToFirst()) {
                while (true) {
                    addButton(layout, cs.getString(2));
                    if (!cs.moveToNext()) break;
                }
            } else {
                Toast.makeText(mContext, "データがありません", Toast.LENGTH_SHORT).show();
            }
        } finally {
            cs.close();
            db.close();
        }
    }


    /**
     * pearentにボタンを追加する
     *
     * @param text
     */
    private void addButton(LinearLayout layout,String text) {
        Button btn = new Button(mContext);
        btn.setText(text);
        btn.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        layout.addView(btn);
    }
}
