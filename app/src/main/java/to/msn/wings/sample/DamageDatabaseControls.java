package to.msn.wings.sample;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * Created by 4163209 on 12/12/2017.
 */

public class DamageDatabaseControls {

    private Context mContext;
    private DamageDatabaseHelper damageDatabaseHelper;
    EditText editText;

    private Handler handler;

    //コンストラクター
    public DamageDatabaseControls(Context context) {
        mContext = context;
        damageDatabaseHelper = new DamageDatabaseHelper(mContext);
        handler = new Handler();
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

    public void addButton(LinearLayout layout, final String text) {
        Button btn = new Button(mContext);
        btn.setText(text);
        btn.setBackgroundResource(R.drawable.lightblue);
        Log.d("textの値は", text);
        btn.setWidth(100);
        btn.setHeight(100);
        btn.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("",text);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        Player1_screen.setPlayerAPtext(text);
                    }
                });
            }
        });
        layout.addView(btn);
    }
}