package cn.infohuc.infohubandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class Welcome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        String name = getIntent().getStringExtra("name");
//        Log.d("myTag", "onCreate: "+name);
        TextView myTextView = (TextView) findViewById(R.id.welTextView);
        myTextView.setText(name);
    }
}
