package to.msn.wings.sample;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

/**
 * Created by 4163214 on 12/7/2017.
 */

public class PreferenceManager {
    // デバック用のタグ
    private static final String TAG = "PreferenceManager";

    private Context mContext;
    private String PREFERENCE_NAME = "pref";
    private SharedPreferences mPreferences;
    private SharedPreferences.Editor mEdit;

    /**
     * コンストラクター
     *
     * @param context 呼び出し元のcontext
     */
    public PreferenceManager(Context context) {
        mContext = context;
        mPreferences = mContext.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
        mEdit = mPreferences.edit();
    }

    /**
     * データをPreferenceに保存する
     *
     * @param key 保存する値のkey
     * @param val 保存する値
     */
    public void putData(String key, Object val) {
        if (val instanceof Integer) {
            mEdit.putInt(key, (int) val);
            mEdit.apply();
            Log.i(TAG, String.format("保存成功：key=%s val=%d", key, val));
        } else if (val instanceof Integer) {
            mEdit.putInt(key, (int) val);
            mEdit.apply();
            Log.i(TAG, String.format("保存成功：key=%s val=%d", key, val));
        } else if (val instanceof Long) {
            mEdit.putLong(key, (long) val);
            mEdit.apply();
            Log.i(TAG, String.format("保存成功：key=%s val=%d", key, val));
        } else if (val instanceof Float) {
            mEdit.putFloat(key, (float) val);
            mEdit.apply();
            Log.i(TAG, String.format("保存成功：key=%s val=%f", key, val));
        } else if (val instanceof String) {
            mEdit.putString(key, (String) val);
            mEdit.apply();
        } else if (val instanceof Boolean) {
            mEdit.putBoolean(key, (boolean) val);
            mEdit.apply();
            Log.i(TAG, String.format("保存成功：key=%s val=%s", key, val));
        } else {
            Log.e(TAG, "この型は保存出来ません");
        }
    }


    /**
     * Preferenceからデータ（Int型）を読み込む
     *
     * @param key    読み込むデータのkey
     * @param defVal データがなかった時の戻り値（初期値）
     * @return
     */
    public int getIntData(String key, int defVal) {
        return mPreferences.getInt(key, defVal);
    }

    /**
     * Preferenceからデータ（Long型）を読み込む
     *
     * @param key    読み込むデータのkey
     * @param defVal データがなかった時の戻り値（初期値）
     * @return
     */
    public long getLongData(String key, long defVal) {
        return mPreferences.getLong(key, defVal);
    }

    /**
     * Preferenceからデータ（String型）を読み込む
     *
     * @param key    読み込むデータのkey
     * @param defVal データがなかった時の戻り値（初期値）
     * @return
     */
    public float getFloatData(String key, float defVal) {
        return mPreferences.getFloat(key, defVal);
    }

    /**
     * Preferenceからデータ（String型）を読み込む
     *
     * @param key    読み込むデータのkey
     * @param defVal データがなかった時の戻り値（初期値）
     * @return
     */
    public String getStringData(String key, String defVal) {
        return mPreferences.getString(key, defVal);
    }

    /**
     * Preferenceからデータ（Boolean型）を読み込む
     *
     * @param key    読み込むデータのkey
     * @param defVal データがなかった時の戻り値（初期値）
     * @return
     */
    public boolean getBooleanData(String key, boolean defVal) {
        return mPreferences.getBoolean(key, defVal);

    }
}
