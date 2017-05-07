package cn.infohuc.infohubandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {
    private static final String TAG = MainActivity.class.getSimpleName();
    public static final String EXTRA_STRING_USER = "user";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void sayHello(View v){
        Log.d(TAG, "ssyHello: ssss");
        Intent newIntent = new Intent(this,Welcome.class);
        String buff = ((EditText)findViewById(R.id.myEditText)).getText().toString();
        newIntent.putExtra(EXTRA_STRING_USER, buff);
        startActivity(newIntent);
    }
}
