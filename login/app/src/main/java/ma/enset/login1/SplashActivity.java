package ma.enset.login1;

import static android.support.v4.content.ContextCompat.startActivity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.window.SplashScreen;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends Activity {
    private static int SPLASH_TIME_OUT = 3000;

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.splashscreen);
        new Handler().postDelayed( new Runnable() {
            @Override
            public void run() {
                // This method will be executed once the timer is  over // Start your app main activity
                Intent i = new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(i);
                // close this activity
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}
