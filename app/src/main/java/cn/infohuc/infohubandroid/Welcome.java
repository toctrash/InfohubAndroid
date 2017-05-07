package cn.infohuc.infohubandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class Welcome extends AppCompatActivity {
    private static final String TAG = Welcome.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        String name = getIntent().getStringExtra(MainActivity.EXTRA_STRING_USER);
        Log.d(TAG, "onCreate: "+name);
        TextView myTextView = (TextView) findViewById(R.id.welTextView);
        myTextView.setText(name);
    }
}
