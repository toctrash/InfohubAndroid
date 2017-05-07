package cn.infohuc.infohubandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
    private TextView myTextView;
    private EditText myEditView;
    private static final String TAG = MainActivity.class.getSimpleName();
    public static final String EXTRA_STRING_USER = "user";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG,"onCreate");

        myTextView = (TextView) findViewById(R.id.myTextView);
        myEditView = (EditText) findViewById(R.id.myEditText);
        final Button sayHi = (Button) findViewById(R.id.sayHi);

        sayHi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sayHi(v);
            }
        });
    }

    public void sayHi(View v){
        String buff = myEditView.getText().toString();
        myTextView.setText(String.format(getString(R.string.hiing), buff));
    }
    public void sayHello(View v){
        Log.d(TAG, "ssyHello");
        Intent newIntent = new Intent(this,Welcome.class);
        String buff = ((EditText)findViewById(R.id.myEditText)).getText().toString();
        newIntent.putExtra(EXTRA_STRING_USER, buff);
        startActivity(newIntent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"onStart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"onDestroy");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"onPause");
    }
}
