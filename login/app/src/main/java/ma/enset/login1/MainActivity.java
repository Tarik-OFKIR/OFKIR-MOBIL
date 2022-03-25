package ma.enset.login1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String email;
    String password;
    TextView user_email;
    TextView user_password;
    Button btn_logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bundle bundle = getIntent().getExtras();
        email = bundle.getString("email");
        password = bundle.getString("password");
        user_email = findViewById(R.id.useremailtext);
        user_password= findViewById(R.id.passwordtext);
        user_email.setText(email);
        user_password.setText(password);

        btn_logout = findViewById(R.id.button_out);

        btn_logout.setOnClickListener(view -> {
            Intent i = new Intent(this, LoginActivity.class);
            startActivity(i);
        });
    }
}