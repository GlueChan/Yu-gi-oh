package to.msn.wings.sample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by 4163209 on 10/24/2017.
 */

public class Player1_screen extends AppCompatActivity implements View.OnClickListener{
    Button button0,button1,button2,button3,button4,button5,
            button6,button7,button8,button9;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dentaku_player1);

        findViewById(R.id.return_Top).setOnClickListener(this);
    }
    public void onClick(View view) {     //ボタンがクリックされたとき
        switch (view.getId()) {
            case R.id.return_Top:       //トップに戻る
                Intent itop = new Intent(Player1_screen.this, MainActivity.class);
                startActivity(itop);
                break;
        }
    }

}
