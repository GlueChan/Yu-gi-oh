package to.msn.wings.sample;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.content.ContentValues.TAG;

public class LifeDataBaseControl {
    private Context mContext;
    private LifeDatabaseHelper lifeDatabaseHelper;




    //コンストラクター
    public LifeDataBaseControl(Context context) {
        mContext = context;
        lifeDatabaseHelper = new LifeDatabaseHelper(mContext);
    }

    public void lifeAddBtnCreate(EditText editText) {
        SQLiteDatabase db = lifeDatabaseHelper.getReadableDatabase();
        Cursor cs = null;

        try {
            String[] cols = {"number", "name", "life"};
            cs = db.query("life", cols, null, null, null, null, null, null);

            //dbにデータがある間ボタンを生成
            //もし、データがなければ終了
            if (cs.moveToFirst()) {
                while (true) {
                    //ChangeLife(editText, cs.getString(2));
                    getPlayerDefLife();
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

//
//    public void ChangeLifeOnMenu(TextView textView) {
//        SQLiteDatabase db = lifeDatabaseHelper.getReadableDatabase();
//        Cursor cs = null;
//
//        try {
//            String[] cols = {"number", "name", "life"};
//            cs = db.query("life", cols, null, null, null, null, null, null);
//
//            //dbにデータがある間ボタンを生成
//            //もし、データがなければ終了
//            if (cs.moveToFirst()) {
//                while (true) {
//                    ChangeLifeOnMenu(textView, cs.getString(2));
//                    if (!cs.moveToNext()) break;
//                }
//            } else {
//                Toast.makeText(mContext, "データがありません", Toast.LENGTH_SHORT).show();
//            }
//        } finally {
//            cs.close();
//            db.close();
//        }
//    }


    public int getPlayerDefLife() {
        SQLiteDatabase db = lifeDatabaseHelper.getReadableDatabase();
        Cursor cs = null;
        int defLife = 0;

        try {
            String[] cols = {"number", "name", "life"};
            cs = db.query("life", cols, null, null, null, null, null, null);

            //dbにデータがある間ボタンを生成
            //もし、データがなければ終了
            if (cs.moveToFirst()) {
                defLife = cs.getInt(2);
//                while (true) {
//                    array.add();
//                    if (!cs.moveToNext()) break;
//                }
            } else {
                Toast.makeText(mContext, "データがありません", Toast.LENGTH_SHORT).show();
            }
        } finally {
            cs.close();
            db.close();
        }
        Log.i(TAG, "getPlayerDefLife:" + defLife);
        return defLife;

    }




//    /**
//     * pearentにボタンを追加する
//     *
//     * @param text
//     */
//    private void ChangeLife(EditText editText, String text) {
//       //TODO  editText.setText(text);
//        //editText.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
//        //editText.addView(editText);
//    }

    private void ChangeLifeOnMenu(TextView textView, String text) {
        textView.setText(text);
    }
}

