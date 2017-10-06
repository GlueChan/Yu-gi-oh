package to.msn.wings.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button button_0,
            button_000,
            button_1,
            button_2,
            button_3,
            button_4,
            button_5,
            button_6,
            button_7,
            button_8,
            button_9,
            button_Plus, //足し算
            button_subtraction, //引き算
            button_divided,     //割り算
            button_Equal;       //イコール

    EditText editText;

    float mValueOne,mValueTwo;

    boolean mAddition,mSubtract,mdivision,mMultiplication;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_0 = (Button) findViewById(R.id.Button_0);
        button_000 = (Button) findViewById(R.id.Button_000);
        button_1  = (Button) findViewById(R.id.Button_1);
        button_2  = (Button) findViewById(R.id.Button_2);
        button_3  = (Button) findViewById(R.id.Button_3);
        button_4  = (Button) findViewById(R.id.Button_4);
        button_5  = (Button) findViewById(R.id.Button_5);
        button_6  = (Button) findViewById(R.id.Button_6);
        button_7  = (Button) findViewById(R.id.Button_7);
        button_8  = (Button) findViewById(R.id.Button_8);
        button_9  = (Button) findViewById(R.id.Button_9);
        button_Plus = (Button) findViewById(R.id.Button_Plus);
        button_subtraction = (Button) findViewById(R.id.Button_subtraction);
        button_Equal = (Button) findViewById(R.id.Button_Equal);
        button_divided = (Button) findViewById(R.id.Button_divided);

    }
}
