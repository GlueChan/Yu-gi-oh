package to.msn.wings.sample;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

/**
 * Created by 4163209 on 3/23/2018.
 */

public class SelectCoinDialog extends DialogFragment{

    public static final String TAG = "SelectCoinDialog";

    private Activity mActivity;

    private Button mBtnOK;

    /**
     * ダイアログの表示
     *
     * @param activity
     */
    public static void show(Activity activity) {
        SelectCoinDialog f = new SelectCoinDialog();
        Bundle args = new Bundle();
        //args.putString("modelSettingPath", modelSettingPath);
        f.setArguments(args);
        f.show(activity.getFragmentManager(), TAG);
    }

    /**
     * テキストダイアログの生成
     *
     * @param bundle
     * @return
     */
    @Override
    public Dialog onCreateDialog(Bundle bundle) {
        mActivity = getActivity();

        // CancelボタンのOnClick
        DialogInterface.OnClickListener btnCancel =
                new DialogInterface.OnClickListener() {
                    // ダイアログボタン押下時に呼ばれる
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // 内もしない
                    }
                };

        // ダイアログの生成
        AlertDialog.Builder ad
                = new AlertDialog.Builder(mActivity);
        ad.setTitle("コイントスの枚数選択");
        ad.setView(getView(mActivity));
        ad.setNegativeButton("キャンセル", btnCancel);


        // フラグメントの状態復帰時に保存していた値をセットする
        if (bundle != null) {
        }
        return ad.create();
    }

    /**
     * フラグメントの状態保存→onCreateDialogで使用
     *
     * @param bundle
     */
    @Override
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    private LinearLayout getView(Activity activity){

        LinearLayout layout = new LinearLayout(activity);
        layout.setOrientation(LinearLayout.VERTICAL);

        Button coin1Btn = new Button(activity);
        coin1Btn.setText("コイントス1枚");
        coin1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent coin1Intetnt = new Intent(mActivity, CointosActivity.class);
                coin1Intetnt.putExtra("coin", 1);
                startActivity(coin1Intetnt);

            }
        });
        layout.addView(coin1Btn);

        Button coin2Btn = new Button(activity);
        coin2Btn.setText("コイントス2枚");
        layout.addView(coin2Btn);
        coin2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(mActivity, CointosActivity.class);
                i.putExtra("coin", 2);
                startActivity(i);
            }
        });

        Button coin3Btn = new Button(activity);
        coin3Btn.setText("コイントス3枚");
        layout.addView(coin3Btn);
        coin3Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(mActivity, CointosActivity.class);
                i.putExtra("coin", 3);
                startActivity(i);
            }
        });

        return layout;
    }
}


