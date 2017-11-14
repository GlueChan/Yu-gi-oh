package to.msn.wings.sample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by 4163214 on 10/26/2017.
 */

public class Life_setting extends AppCompatActivity implements View.OnClickListener{

    Button button0, button1, button2, button3, button4, button5,
            button6, button7, button8, button9,
            decision; //決定


    EditText editText;


    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.life_setting);

        findViewById(R.id.return_Page).setOnClickListener(this);
        findViewById(R.id.return_Top).setOnClickListener(this);

        button0 = (Button) findViewById(R.id.Button_0);
        button1 = (Button) findViewById(R.id.Button_1);
        button2 = (Button) findViewById(R.id.Button_2);
        button3 = (Button) findViewById(R.id.Button_3);
        button4 = (Button) findViewById(R.id.Button_4);
        button5 = (Button) findViewById(R.id.Button_5);
        button6 = (Button) findViewById(R.id.Button_6);
        button7 = (Button) findViewById(R.id.Button_7);
        button8 = (Button) findViewById(R.id.Button_8);
        button9 = (Button) findViewById(R.id.Button_9);

        decision = (Button)findViewById(R.id.Button_decision); //決定ボタン

        editText = (EditText) findViewById(R.id.setting_life);

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText() + "0");
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText() + "1");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText() + "2");
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText() + "3");
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText() + "4");
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText() + "5");
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText() + "6");
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText() + "7");
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText() + "8");
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText() + "9");
            }
        });
    }

    public void onClick(View view) {     //ボタンがクリックされたとき
        switch (view.getId()) {
            case R.id.return_Top:    //トップに戻る
                Intent itop = new Intent(Life_setting.this, MainActivity.class);
                startActivity(itop);
                break;
            case R.id.return_Page:    //前のページに戻る
                Intent ipage = new Intent(Life_setting.this, Menu.class);
                startActivity(ipage);
                break;
        }
    }
}
