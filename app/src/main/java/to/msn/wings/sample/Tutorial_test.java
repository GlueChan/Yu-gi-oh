package to.msn.wings.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;

public class Tutorial_test extends AppCompatActivity implements View.OnClickListener {
    ImageView imageView;
    ScrollView scrollView;
    ImageView imageView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial_test);
        imageView = new ImageView(this);
        scrollView = new ScrollView(this);
        imageView1 = new ImageView(this);
        findViewById(R.id.Button_return_top).setOnClickListener(this);

    }


    public void onClick(View view) {     //ボタンがクリックされたとき
        switch (view.getId()) {
            case R.id.Button_return_top:    //トップに戻る
                finish();
                break;
        }
    }
}
