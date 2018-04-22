package to.msn.wings.sample;

import android.os.Bundle;

import com.stephentuso.welcome.BasicPage;
import com.stephentuso.welcome.TitlePage;
import com.stephentuso.welcome.WelcomeActivity;
import com.stephentuso.welcome.WelcomeConfiguration;
import com.stephentuso.welcome.WelcomeHelper;

public class TutorialActivity extends WelcomeActivity {
    WelcomeHelper welcomeHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        welcomeHelper = new WelcomeHelper(this,TutorialActivity.class);
        welcomeHelper.show(savedInstanceState);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        welcomeHelper.onSaveInstanceState(outState);
    }

    @Override
    protected WelcomeConfiguration configuration() {
        return new WelcomeConfiguration.Builder(this)
                .defaultBackgroundColor(R.color.colorAccent)
                .page(new TitlePage(R.drawable.cyber,
                        "Title")
                )
                .page(new BasicPage(R.drawable.cyber,
                        "Header",
                        "More text.")
                        .background(R.color.colorAccent)
                )
                .page(new BasicPage(R.drawable.cyber,
                        "Lorem ipsum",
                        "dolor sit amet.")
                )
                .swipeToDismiss(true)
                .build();
    }
    }

