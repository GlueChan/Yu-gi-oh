package to.msn.wings.sample;

/**
 * Created by 4163214 on 12/7/2017.
 */

/**
 * 共通で使用する関数群
 */
public class Config {

    public static final  String PREF_KEY_PLAYER1_BACKGROUND="pref_key_player1_background";
    public static final  String PREF_KEY_PLAYER2_BACKGROUND="pref_key_player2_background";
    public static int playerId=1;

    /**
     * 画像のＩＤを返す関数
     * @param id
     * @return
     */
    public static final int getBackgroundImageId(int id){
        int resId;
        switch (id){        //idによって取得する画像を変える
            case 0:
                resId = R.drawable.silence;
                break;
            case 1:
                resId=R.drawable.satisfaction;
                break;
            case 6:
                resId=R.drawable.cyber;
                break;
            default:
                resId = R.drawable.cyber;
                break;
        }
        return resId;
    }

    public static final void changeID(int id){
        switch (id){
            case 1:
                playerId=1;
                break;
            case 2:
                playerId=2;
                break;
            default:
                break;
        }
    }

    public static final int returnID(){
        return playerId;
    }

}
