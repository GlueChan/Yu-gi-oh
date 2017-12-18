package to.msn.wings.sample;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

/**
 * Created by 4163214 on 12/14/2017.
 */

public class Photo extends AppCompatActivity{
    private Uri m_uri;
    private static final int REQUEST_CHOOSER=1000;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gallery);
        setViews();
    }
    private void setViews(){
        Button button=(Button)findViewById(R.id.get_image);
    }
}
