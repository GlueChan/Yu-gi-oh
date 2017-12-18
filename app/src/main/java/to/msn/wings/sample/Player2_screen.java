package to.msn.wings.sample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

/**
 * Created by 4163214 on 10/26/2017.
 */

public class Player2_screen extends AppCompatActivity implements View.OnClickListener{
    Button button0, button1, button2, button3, button4, button5,
            button6, button7, button8, button9, button00, button000,
            buttonAdd,       //足し算
            buttonSub,       //引き算
            buttonDivision, //割り算
            buttonC,         //クリア
            buttonEqual;    //イコール

    EditText editText;

    int ValueOne, ValueTwo;

    boolean Addtion, Subtraction, Division;

    DamageDatabaseControls damageDatabaseControls;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dentaku_player2);

        findViewById(R.id.return_Top).setOnClickListener(this);

        damageDatabaseControls = new DamageDatabaseControls(this);


        button0 = (Button) findViewById(R.id.Button_0);
        button00 = (Button) findViewById(R.id.Button_00);
        button000 = (Button) findViewById(R.id.Button_000);
        button1 = (Button) findViewById(R.id.Button_1);
        button2 = (Button) findViewById(R.id.Button_2);
        button3 = (Button) findViewById(R.id.Button_3);
        button4 = (Button) findViewById(R.id.Button_4);
        button5 = (Button) findViewById(R.id.Button_5);
        button6 = (Button) findViewById(R.id.Button_6);
        button7 = (Button) findViewById(R.id.Button_7);
        button8 = (Button) findViewById(R.id.Button_8);
        button9 = (Button) findViewById(R.id.Button_9);

        buttonAdd = (Button) findViewById(R.id.Button_Add);
        buttonSub = (Button) findViewById(R.id.Button_subtraction);
        buttonDivision = (Button) findViewById(R.id.Button_Dvision);
        buttonC = (Button) findViewById(R.id.return_prev);
        buttonEqual = (Button) findViewById(R.id.Button_Equal);

        editText = (EditText) findViewById(R.id.Player_cal2);

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText() + "0");
            }
        });

        button00.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText() + "00");
            }
        });

        button000.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText() + "000");
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


        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editText == null) {
                    editText.setText("");
                } else {
                    ValueOne = Integer.parseInt(editText.getText() + "");
                    Addtion = true;
                    editText.setText(null);
                }
            }
        });

        buttonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ValueOne = Integer.parseInt(editText.getText() + "");
                Subtraction = true;
                editText.setText(null);
            }
        });

        buttonDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ValueOne = Integer.parseInt(editText.getText() + "");
                Subtraction = true;
                editText.setText(null);

            }
        });


        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ValueTwo = Integer.parseInt(editText.getText() + "");

                if (Addtion == true) {
                    editText.setText(ValueOne + ValueTwo + "");
                    Addtion = false;
                }

                if (Subtraction == true) {
                    editText.setText(ValueOne - ValueTwo + "");
                    Subtraction = false;
                }

                if (Division == true) {
                    editText.setText(ValueOne / ValueTwo + "");
                    Division = false;
                }
            }

        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        damageDatabaseControls.damageAddBtnCreate((LinearLayout)findViewById(R.id.damageBtnLayout));
    }


    public void onClick(View view) {     //ボタンがクリックされたとき
        switch (view.getId()) {
            case R.id.return_Top:       //トップに戻る
                Intent itop = new Intent(Player2_screen.this, MainActivity.class);
                startActivity(itop);
                break;
        }
    }
}
