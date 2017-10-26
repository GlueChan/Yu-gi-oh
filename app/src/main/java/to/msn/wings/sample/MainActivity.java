package to.msn.wings.sample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.main);

        findViewById(R.id.player).setOnClickListener(this);
    }

    public void onClick(View view){     //ボタンがクリックされたとき
        //String tag=(String)view.getTag();
        switch (view.getId()) {
            case R.id.player:
                Intent intent = new Intent(MainActivity.this, player1gamen.class);
                startActivity(intent);
        }

    }
}
